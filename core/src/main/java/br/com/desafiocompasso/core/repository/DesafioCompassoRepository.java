package br.com.desafiocompasso.core.repository;

import br.com.desafiocompasso.core.model.DesafioCompasso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * [Desafio Compasso] - Criação da inteface de repositório responsável por realizar a requisições a base de dados.
 * @author Weslley Medeiros
 * @since 04/07/2021
 */
@Repository
public interface DesafioCompassoRepository extends JpaRepository<DesafioCompasso, Long> {
    @Query(
        value = "SELECT dc " +
                "FROM DesafioCompasso AS dc " +
                "WHERE dc.name like %?1% " +
                "OR dc.description like %?1% " +
                "OR dc.price >= ?2 " +
                "OR dc.price <= ?3"
    )
    List<DesafioCompasso> searchProduto (String q, Double min_price, Double max_price);

    @Query(
            value = "SELECT dc " +
                    "FROM DesafioCompasso AS dc " +
                    "WHERE dc.price BETWEEN ?1 AND ?2"
    )
    List<DesafioCompasso> searchProdutoBeetwen (Double min_price, Double max_price);
}