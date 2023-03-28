package com.crud.confirmacaoEmail.repositorys;

import com.crud.confirmacaoEmail.entitys.EmailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmailRepository extends JpaRepository<EmailEntity, UUID> {
}
