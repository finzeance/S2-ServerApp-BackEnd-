/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.co.mii.serverapp.services;

import id.co.mii.serverapp.models.dto.requests.EmailRequest;
import java.io.File;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 *
 * @author Zidane
 */
@Service
@AllArgsConstructor
public class EmailService {

    private JavaMailSender mailSender;

    public EmailRequest sendSimpleMessage(EmailRequest emailRequest) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(emailRequest.getTo());
        message.setSubject(emailRequest.getSubject());
        message.setText(emailRequest.getBody());
        mailSender.send(message);

        System.out.println();
        System.out.println("Email success to send...");

        return emailRequest;
    }

    public EmailRequest sendMessageWithAttachment(EmailRequest emailRequest) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(emailRequest.getTo());
            helper.setSubject(emailRequest.getSubject());
            helper.setText(emailRequest.getBody());

            FileSystemResource file = new FileSystemResource(
                    new File(emailRequest.getAttach())
            );

            helper.addAttachment(file.getFilename(), file);
            mailSender.send(message);
            System.out.println();
            System.out.println("Email success to send...");

        } catch (Exception e) {
            throw new IllegalStateException("Email failed to send..."); //
        }
        return emailRequest;

    }

    public EmailRequest sendMessageWithMultiAttachment(EmailRequest emailRequest) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(InternetAddress.parse(emailRequest.getTo())); //cara 1
            helper.setSubject(emailRequest.getSubject());
            helper.setText(emailRequest.getBody());

            FileSystemResource file = new FileSystemResource(
                    new File(emailRequest.getAttach())
            );

            helper.addAttachment(file.getFilename(), file);
            mailSender.send(message);
            System.out.println();
            System.out.println("Email success to send...");

        } catch (Exception e) {
            throw new IllegalStateException("Email failed to send..."); //
        }
        return emailRequest;

    }

    public Iterable<EmailRequest> sendMessageWithAttachmentMultipleObject(Iterable<EmailRequest> emailRequests) {
        emailRequests.forEach(emailRequest -> {
            try {
                MimeMessage message = mailSender.createMimeMessage();
                MimeMessageHelper helper = new MimeMessageHelper(message, true);

                helper.setTo(emailRequest.getTo());
                helper.setSubject(emailRequest.getSubject());
                helper.setText(emailRequest.getBody());

                FileSystemResource file = new FileSystemResource(
                        new File(emailRequest.getAttach())
                );

                helper.addAttachment(file.getFilename(), file);
                mailSender.send(message);
                System.out.println();
                System.out.println("Email success to send...");
            } catch (Exception e) {
                throw new IllegalStateException("Email failed to send...");
            }
        });
        return emailRequests;
    }

}
