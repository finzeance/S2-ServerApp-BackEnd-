/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.co.mii.serverapp.services;

import id.co.mii.serverapp.models.dto.requests.EmailRequestHTML;
import java.io.File;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
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
public class EmailServiceHTML {

    private JavaMailSender mailSender;

    public EmailRequestHTML sendSimpleMessage(EmailRequestHTML emailRequest) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(emailRequest.getTo());
        message.setSubject(emailRequest.getSubject());

        message.setText(emailRequest.getBody1());
        message.setText(emailRequest.getBody2());
        message.setText(emailRequest.getBody3());
        message.setText(emailRequest.getBody4());
        mailSender.send(message);

        System.out.println();
        System.out.println("Email success to send...");

        return emailRequest;
    }

    public EmailRequestHTML sendMessageWithAttachment(EmailRequestHTML emailRequest) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(emailRequest.getTo());
            helper.setSubject(emailRequest.getSubject());

            String url1 = "https://www.linkedin.com/in/alfinzidane/";
            String url2 = "https://www.instagram.com/alfin.zdn/";
            String url3 = "https://www.github.com/finzeance/";
            String url4 = "https://wa.me/6282140783716";

            String htmlMsg
                    = "<html>"
                    + "<head>"
                    + "<style>"
                    + ".button{ border: none; color: white; padding: 8px 12px; text-align: center; text-decoration: none; display: inline-block; font-size: 8px; margin: 4px 4px; transition-duration: 0.4s; cursor: pointer}"
                    + ".button1 {background-color: white; color: black; border: 2px solid #000000;}"
                    + ".button1:hover {background-color: grey ;color: white;}"
                    + ".button2 {background-color: white; color: black; border: 2px solid #000000;}"
                    + ".button2:hover {background-color: grey ;color: white;}"
                    + ".button3 {background-color: white; color: black; border: 2px solid #000000;}"
                    + ".button3:hover {background-color: grey;color: white;}"
                    + ".button4 {background-color: white; color: black; border: 2px solid #000000;}"
                    + ".button4:hover {background-color: grey;color: white;}"
                    + "</style>"
                    + "</head>"
                    + "<body>"
                    + "<table align='center' border='1' cellpadding='50' cellspacing='10' width='950'>"
                    + "<tr> <td bgcolor='#ffffff'>"
                    + "<p style='background-color:#000000'> . </p>"
                    + "<h1 style='font-family: cursive;'><center>RESUME LAMARAN PEKERJAAN</center></h1>"
                    + "<center><img src='" + emailRequest.getImg() + "' alt='fotozidane' width='150' height='200'></center>"
                    + "<p style='background-color:#000000'> . </p>"
                    + "<p>Saya merupakan fresh graduate program Sarjana Matematika Institut Teknologi Sepuluh Nopember (ITS) dengan IPK 3,56. Saya memiliki minat di bidang Pendidikan dan Teknologi. Saya belajar banyak tentang pemrograman dasar seperti Java, Python, SQL, dll. Saya selalu terbuka untuk lowongan sebagai data analyst, data engineer, dan full stack developer. Namun, saya tidak menutup kemungkinan untuk bekerja di luar pekerjaan yang saya sebutkan sebelumnya. Selanjutnya, saya sertakan lampiran pendukung dan profil saya secara singkat di bawah ini:"
                    + "<p style='background-color:#000000'> . </p>"
                    + "<p><b>Nama</b> \t\t\t:" + emailRequest.getBody1()
                    + "<br><b>Umur</b> \t\t\t:" + emailRequest.getBody2()
                    + "<br><b>Tempat tinggal</b> \t:" + emailRequest.getBody3()
                    + "<br><b>Lulusan</b> \t\t\t:" + emailRequest.getBody4()
                    + "<p style='background-color:#000000'> . </p>"
                    + "<b>Portofolio</b>:"
                    + "<button class='button button3'><a style ='text-decoration:none;' href='" + url3 + "'>GitHub</a></button>"
                    + "<p style='background-color:#000000'> . </p>"
                    + "<p>Want to know me more?"
                    + "<br><b>Contact me</b> \t\t\t:"
                    + "<button class='button button1'><a style ='text-decoration:none;' href='" + url1 + "'>LinkedIn</a></button>"
                    + "<button class='button button2'><a style ='text-decoration:none;' href='" + url2 + "'>Instagram</a></button>"
                    + "<button class='button button2'><a style ='text-decoration:none;' href='" + url4 + "'>Whatsapp</a></button>"
                    + "<p style='background-color:#000000'> . </p>"
                    + "</td> </tr>"
                    + "</table>"
                    + "</body>"
                    + "</html>";

            helper.setText(htmlMsg, true);

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
//

    public EmailRequestHTML sendMessageWithMultiAttachment(EmailRequestHTML emailRequest) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(InternetAddress.parse(emailRequest.getTo())); //cara 1
            helper.setSubject(emailRequest.getSubject());

            String url1 = "https://www.linkedin.com/in/alfinzidane/";
            String url2 = "https://www.instagram.com/alfin.zdn/";
            String url3 = "https://www.github.com/finzeance/";
            String url4 = "https://wa.me/6282140783716";

            String htmlMsg
                    = "<html>"
                    + "<head>"
                    + "<style>"
                    + ".button{ border: none; color: white; padding: 8px 12px; text-align: center; text-decoration: none; display: inline-block; font-size: 8px; margin: 4px 4px; transition-duration: 0.4s; cursor: pointer}"
                    + ".button1 {background-color: white; color: black; border: 2px solid #000000;}"
                    + ".button1:hover {background-color: grey ;color: white;}"
                    + ".button2 {background-color: white; color: black; border: 2px solid #000000;}"
                    + ".button2:hover {background-color: grey ;color: white;}"
                    + ".button3 {background-color: white; color: black; border: 2px solid #000000;}"
                    + ".button3:hover {background-color: grey;color: white;}"
                    + ".button4 {background-color: white; color: black; border: 2px solid #000000;}"
                    + ".button4:hover {background-color: grey;color: white;}"
                    + "</style>"
                    + "</head>"
                    + "<body>"
                    + "<table align='center' border='1' cellpadding='50' cellspacing='10' width='950'>"
                    + "<tr> <td bgcolor='#ffffff'>"
                    + "<p style='background-color:#000000'> . </p>"
                    + "<h1 style='font-family: cursive;'><center>RESUME LAMARAN PEKERJAAN</center></h1>"
                    + "<center><img src='" + emailRequest.getImg() + "' alt='fotozidane' width='150' height='200'></center>"
                    + "<p style='background-color:#000000'> . </p>"
                    + "<p>Saya merupakan fresh graduate program Sarjana Matematika Institut Teknologi Sepuluh Nopember (ITS) dengan IPK 3,56. Saya memiliki minat di bidang Pendidikan dan Teknologi. Saya belajar banyak tentang pemrograman dasar seperti Java, Python, SQL, dll. Saya selalu terbuka untuk lowongan sebagai data analyst, data engineer, dan full stack developer. Namun, saya tidak menutup kemungkinan untuk bekerja di luar pekerjaan yang saya sebutkan sebelumnya. Selanjutnya, saya sertakan lampiran pendukung dan profil saya secara singkat di bawah ini:"
                    + "<p style='background-color:#000000'> . </p>"
                    + "<p><b>Nama</b> \t\t\t:" + emailRequest.getBody1()
                    + "<br><b>Umur</b> \t\t\t:" + emailRequest.getBody2()
                    + "<br><b>Tempat tinggal</b> \t:" + emailRequest.getBody3()
                    + "<br><b>Lulusan</b> \t\t\t:" + emailRequest.getBody4()
                    + "<p style='background-color:#000000'> . </p>"
                    + "<b>Portofolio</b>:"
                    + "<button class='button button3'><a style ='text-decoration:none;' href='" + url3 + "'>GitHub</a></button>"
                    + "<p style='background-color:#000000'> . </p>"
                    + "<p>Want to know me more?"
                    + "<br><b>Contact me</b> \t\t\t:"
                    + "<button class='button button1'><a style ='text-decoration:none;' href='" + url1 + "'>LinkedIn</a></button>"
                    + "<button class='button button2'><a style ='text-decoration:none;' href='" + url2 + "'>Instagram</a></button>"
                    + "<button class='button button2'><a style ='text-decoration:none;' href='" + url4 + "'>Whatsapp</a></button>"
                    + "<p style='background-color:#000000'> . </p>"
                    + "</td> </tr>"
                    + "</table>"
                    + "</body>"
                    + "</html>";

            helper.setText(htmlMsg, true);

            FileSystemResource file = new FileSystemResource(
                    new File(emailRequest.getAttach())
            );

            helper.addAttachment(file.getFilename(), file);
            mailSender.send(message);
            System.out.println();
            System.out.println("Email success to send...");

        } catch (MessagingException | MailException e) {
            throw new IllegalStateException("Email failed to send..."); //
        }
        return emailRequest;

    }

    public Iterable<EmailRequestHTML> sendMessageWithAttachmentMultipleObject(Iterable<EmailRequestHTML> emailRequests) {
        emailRequests.forEach(emailRequest -> {
            try {
                MimeMessage message = mailSender.createMimeMessage();
                MimeMessageHelper helper = new MimeMessageHelper(message, true);

                helper.setTo(emailRequest.getTo());
                helper.setSubject(emailRequest.getSubject());
                String url1 = "https://www.linkedin.com/in/alfinzidane/";
                String url2 = "https://www.instagram.com/alfin.zdn/";
                String url3 = "https://www.github.com/finzeance/";
                String url4 = "https://wa.me/6282140783716";

                String htmlMsg
                        = "<html>"
                        + "<head>"
                        + "<style>"
                        + ".button{ border: none; color: white; padding: 8px 12px; text-align: center; text-decoration: none; display: inline-block; font-size: 8px; margin: 4px 4px; transition-duration: 0.4s; cursor: pointer}"
                        + ".button1 {background-color: white; color: black; border: 2px solid #000000;}"
                        + ".button1:hover {background-color: grey ;color: white;}"
                        + ".button2 {background-color: white; color: black; border: 2px solid #000000;}"
                        + ".button2:hover {background-color: grey ;color: white;}"
                        + ".button3 {background-color: white; color: black; border: 2px solid #000000;}"
                        + ".button3:hover {background-color: grey;color: white;}"
                        + ".button4 {background-color: white; color: black; border: 2px solid #000000;}"
                        + ".button4:hover {background-color: grey;color: white;}"
                        + "</style>"
                        + "</head>"
                        + "<body>"
                        + "<table align='center' border='1' cellpadding='50' cellspacing='10' width='950'>"
                        + "<tr> <td bgcolor='#ffffff'>"
                        + "<p style='background-color:#000000'> . </p>"
                        + "<h1 style='font-family: cursive;'><center>RESUME LAMARAN PEKERJAAN</center></h1>"
                        + "<center><img src='" + emailRequest.getImg() + "' alt='fotozidane' width='150' height='200'></center>"
                        + "<p style='background-color:#000000'> . </p>"
                        + "<p>Saya merupakan fresh graduate program Sarjana Matematika Institut Teknologi Sepuluh Nopember (ITS) dengan IPK 3,56. Saya memiliki minat di bidang Pendidikan dan Teknologi. Saya belajar banyak tentang pemrograman dasar seperti Java, Python, SQL, dll. Saya selalu terbuka untuk lowongan sebagai data analyst, data engineer, dan full stack developer. Namun, saya tidak menutup kemungkinan untuk bekerja di luar pekerjaan yang saya sebutkan sebelumnya. Selanjutnya, saya sertakan lampiran pendukung dan profil saya secara singkat di bawah ini:"
                        + "<p style='background-color:#000000'> . </p>"
                        + "<p><b>Nama</b> \t\t\t:" + emailRequest.getBody1()
                        + "<br><b>Umur</b> \t\t\t:" + emailRequest.getBody2()
                        + "<br><b>Tempat tinggal</b> \t:" + emailRequest.getBody3()
                        + "<br><b>Lulusan</b> \t\t\t:" + emailRequest.getBody4()
                        + "<p style='background-color:#000000'> . </p>"
                        + "<b>Portofolio</b>:"
                        + "<button class='button button3'><a style ='text-decoration:none;' href='" + url3 + "'>GitHub</a></button>"
                        + "<p style='background-color:#000000'> . </p>"
                        + "<p>Want to know me more?"
                        + "<br><b>Contact me</b> \t\t\t:"
                        + "<button class='button button1'><a style ='text-decoration:none;' href='" + url1 + "'>LinkedIn</a></button>"
                        + "<button class='button button2'><a style ='text-decoration:none;' href='" + url2 + "'>Instagram</a></button>"
                        + "<button class='button button2'><a style ='text-decoration:none;' href='" + url4 + "'>Whatsapp</a></button>"
                        + "<p style='background-color:#000000'> . </p>"
                        + "</td> </tr>"
                        + "</table>"
                        + "</body>"
                        + "</html>";

                helper.setText(htmlMsg, true);

                FileSystemResource file = new FileSystemResource(
                        new File(emailRequest.getAttach())
                );

                helper.addAttachment(file.getFilename(), file);
                mailSender.send(message);
                System.out.println();
                System.out.println("Email success to send...");
            } catch (MessagingException | MailException e) {
                throw new IllegalStateException("Email failed to send...");
            }
        });
        return emailRequests;
    }

}
