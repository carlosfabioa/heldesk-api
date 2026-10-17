package br.com.ctw.helpdesk_api.entity;

import br.com.ctw.helpdesk_api.entity.enums.Prioridade;
import br.com.ctw.helpdesk_api.entity.enums.StatusChamado;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_chamado")
public class Chamado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 150)
    private String titulo;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private StatusChamado status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Prioridade prioridades;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Usuario cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tecnico_id")
    private Usuario tecnico;

    @Column(name="data_atualizacao")
    private Instant dataAtualizacao;

    @OneToMany(mappedBy = "chamado", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Resposta> respostas = new ArrayList<>();
}
