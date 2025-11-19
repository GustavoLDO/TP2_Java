package br.universidade.loja.controller;

import br.universidade.loja.model.Categoria;
import br.universidade.loja.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchTransactionManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    public Categoria salvar(@RequestBody Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    @GetMapping
    public List<Categoria> listar(){
        return categoriaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Categoria buscarPorId(@PathVariable Long id){
        return categoriaRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Categoria nao encontrada id:"+id));
    }
}
