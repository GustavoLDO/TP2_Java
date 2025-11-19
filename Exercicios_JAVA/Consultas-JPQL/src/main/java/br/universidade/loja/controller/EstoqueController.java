package br.universidade.loja.controller;

import br.universidade.loja.model.Estoque;
import br.universidade.loja.repository.EstoqueRepository;
import br.universidade.loja.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public List<Estoque> listarTodos() {
        return estoqueRepository.findAll();
    }

    @GetMapping("/total")
    public Integer total() {
        return estoqueRepository.findTotalItensEmEstoque();
    }

    @PostMapping
    public Estoque salvar(@RequestBody Estoque estoque) {

        Long idProduto = estoque.getProduto().getId();

        // Verifica se o produto existe antes de salvar
        if (!produtoRepository.existsById(idProduto)) {
            throw new RuntimeException("Produto com ID " + idProduto + " não existe!");
        }

        return estoqueRepository.save(estoque);
    }
}
