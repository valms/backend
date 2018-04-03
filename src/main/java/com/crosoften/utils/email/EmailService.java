package com.crosoften.utils.email;

import com.crosoften.utils.json.JsonHandler;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

/**
 * @author Valmar Júnior
 * @version 1.0.1
 * @since 1.0.0
 */
@Service
public class EmailService {

    private JavaMailSender javaMailSender;

    @Autowired
    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    /**
     * Sends the email with the specified data.
     *
     * @param recipient Email Recipient
     * @param message   Email body
     * @param subject   Email subject
     * @return Message of success or error and a HTTP Status
     */
    public ResponseEntity<JsonObject> prepareAndSend(String recipient, String message, String subject) {

        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom("valmarjuniorsmtp@gmail.com");
            messageHelper.setTo(recipient);
            messageHelper.setSubject(subject);
            messageHelper.setText(message);
        };
        //  TODO: Response Fix
        try {

            javaMailSender.send(messagePreparator);
            return ResponseEntity.ok(JsonHandler.buildReturnJson("Email enviado com Sucesso!"));

        } catch (MailException e) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JsonHandler.buildReturnJson("Erro ao enviar o email!"));

        }
    }

}
