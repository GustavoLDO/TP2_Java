package br.universidade.loja.repository;

import br.universidade.loja.model.Categoria;
import br.universidade.loja.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}