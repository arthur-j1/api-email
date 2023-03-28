package com.crud.confirmacaoEmail.controller;

import com.crud.confirmacaoEmail.entitys.EmailEntity;
import com.crud.confirmacaoEmail.services.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    EmailService emailService;

    @PostMapping("/enviar-email")
    public ResponseEntity<EmailEntity> enviarEmail(@RequestBody @Valid EmailEntity email){
        emailService.sendEmail(email);
        return new ResponseEntity<>(email, HttpStatus.CREATED);
    }





}