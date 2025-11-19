package br.universidade.loja.repository;

import br.universidade.loja.model.Estoque;
import br.universidade.loja.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
    @Query(value = "SELECT SUM(quantidade) FROM estoque", nativeQuery = true)
    Integer findTotalItensEmEstoque();
}
