package br.com.desafiocompasso.core.model;

import lombok.*;
import javax.persistence.*;

/**
 * [Desafio Compasso] - Criação da classe responsável por manter encapsulada os dados do produto.
 * @author Weslley Medeiros
 * @since 04/07/2021
 */
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DesafioCompasso implements AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private Double price;

}
