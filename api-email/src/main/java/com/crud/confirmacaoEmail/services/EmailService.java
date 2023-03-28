package com.crud.confirmacaoEmail.services;

import com.crud.confirmacaoEmail.entitys.EmailEntity;
import com.crud.confirmacaoEmail.enums.StatusEmail;
import com.crud.confirmacaoEmail.repositorys.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

@Service
public class EmailService {

    @Autowired
    EmailRepository emailRepository;

    @Autowired
    private JavaMailSender emailSender;

    public EmailEntity sendEmail(EmailEntity email){
        email.setDataEnvioEmail(LocalDateTime.now());
        try {

            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(email.getRemetente());
            message.setTo(email.getDestino());
            message.setSubject(email.getTitulo());
            message.setText(email.getTexto());
            emailSender.send(message);
            email.setStatusEmail(StatusEmail.SENT);
        }catch (MailException e){
            email.setStatusEmail(StatusEmail.ERROR);
        }finally {
            return emailRepository.save(email);
        }


    }




}