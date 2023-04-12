/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.co.mii.serverapp.controller;

import id.co.mii.serverapp.models.dto.requests.EmailRequest;
import lombok.AllArgsConstructor;
import id.co.mii.serverapp.services.EmailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Zidane
 */
@RestController
@RequestMapping("/email")
@AllArgsConstructor
public class EmailController {
    private EmailService emailService;
    
    @PostMapping("/simple")
    public EmailRequest sendSimpleMessage(@RequestBody EmailRequest emailRequest){
        return emailService.sendSimpleMessage(emailRequest);
    }
    @PostMapping("/attach")
    public EmailRequest sendMessageWithAttachment(@RequestBody EmailRequest emailRequest){
        return emailService.sendMessageWithAttachment(emailRequest);
    }
    @PostMapping("/multi-attach")
    public EmailRequest sendMessageWithMultiAttachment(@RequestBody EmailRequest emailRequest){
        return emailService.sendMessageWithMultiAttachment(emailRequest);
    }
    
    @PostMapping("/multi-attach/object")
    public Iterable<EmailRequest> sendMessageWithAttachmentMultipleObject(@RequestBody Iterable<EmailRequest> emailRequests){
        return emailService.sendMessageWithAttachmentMultipleObject(emailRequests);
    }
    
    
    
}
