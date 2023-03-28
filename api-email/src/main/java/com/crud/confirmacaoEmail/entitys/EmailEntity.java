package com.crud.confirmacaoEmail.entitys;

import com.crud.confirmacaoEmail.enums.StatusEmail;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "tb_email")
public class EmailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "email_id", nullable = false)
    private UUID email_id;

    @NotBlank
    private String propietarioRef;
    @NotBlank
    private String remetente;
    @NotBlank
    private String destino;
    @NotBlank
    private String titulo;
    @Column(columnDefinition = "TEXT")
    @NotBlank
    private String texto;
    @NotBlank
    private LocalDateTime dataEnvioEmail;
    @NotBlank
    private StatusEmail statusEmail;
    @ManyToOne()
    private Usuario usuario;



}