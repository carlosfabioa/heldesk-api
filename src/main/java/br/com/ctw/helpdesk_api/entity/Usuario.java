package br.com.ctw.helpdesk_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "tb_usuario", uniqueConstraints = {@UniqueConstraint(name = "uk_usuario_email", columnNames = "email")})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(unique = true, nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 100)
    private String senha;

    @Column(name= "data_criacao", nullable = false, updatable = false )
    private Instant dataCriacao;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "tb_usuario_perfil", joinColumns = @JoinColumn(name = "usuario_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "perfil_id", nullable = false),
            uniqueConstraints = @UniqueConstraint(name = "uk_usuario_perfil", columnNames = {"usuario_id", "perfil_id"})
    )
    private Set<Perfil> perfis = new HashSet<>();
}
