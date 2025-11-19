package br.universidade.loja.repository;

import br.universidade.loja.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    //List<Produto> findByCategoriaNomeAndPrecoLessThan(String categoria, BigDecimal precoMaximo);
    List<Produto> findByCategoriaNomeAndPrecoLessThan(String nomeCategoria, BigDecimal precoMaximo);

}
