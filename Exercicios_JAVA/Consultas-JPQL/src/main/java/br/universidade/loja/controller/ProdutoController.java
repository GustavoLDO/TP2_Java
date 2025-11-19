package br.universidade.loja.controller;

import br.universidade.loja.model.Produto;
import br.universidade.loja.repository.ProdutoRepository;
import br.universidade.loja.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto produto) {

        Long idCategoria = produto.getCategoria().getId();
        Optional<?> categoria = categoriaRepository.findById(idCategoria);

        if (categoria.isEmpty()) {
            throw new RuntimeException("Categoria com ID " + idCategoria + " não existe.");
        }

        return produtoRepository.save(produto);
    }
}
