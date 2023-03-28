package com.crud.confirmacaoEmail.entitys;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Usuario {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "usuario_id", nullable = false)
    private Long usuario_id;

    @NotBlank
    String nome;

    @NotBlank
    String email;
    @NotBlank
    String senha;




}