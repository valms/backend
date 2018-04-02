package com.crosoften.utils.email;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class Email {

    private JavaMailSender javaMailSender;


    @Autowired
    public Email(JavaMailSender javaMailSender) {
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
    public ResponseEntity<String> prepareAndSend(String recipient, String message, String subject) {

        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom("valmarjuniorsmtp@gmail.com");
            messageHelper.setTo(recipient);
            messageHelper.setSubject(subject);
            messageHelper.setText(message);
        };

        try {


            javaMailSender.send(messagePreparator);


            return ResponseEntity.ok(buildReturnJson("Email enviado com Sucesso!"));
        } catch (MailException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(buildReturnJson("Erro ao enviar o email!"));
        }
    }


    public String buildReturnJson(String message) {
        Gson gson = new Gson();
        String json = gson.toJson(message);
        System.out.println(json);
        return json;
    }
}
