package br.com.ctw.helpdesk_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "tb_resposta")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String mensagem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chamado_id", nullable = false)
    private Chamado chamado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id", nullable = false)
    private Usuario autor;

    @Column(name = "data_criacao", nullable = false, updatable = false)
    private Instant dataCriacao;
}
