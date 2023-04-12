/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.co.mii.serverapp.controller;

import id.co.mii.serverapp.models.dto.requests.EmailRequestHTML;
import id.co.mii.serverapp.services.EmailServiceHTML;
import lombok.AllArgsConstructor;
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
public class EmailControllerHTML {
    private EmailServiceHTML emailServiceHTML;
    
    @PostMapping("/html/simple")
    public EmailRequestHTML sendSimpleMessage(@RequestBody EmailRequestHTML emailRequest){
        return emailServiceHTML.sendSimpleMessage(emailRequest);
    }
    @PostMapping("/html/attach")
    public EmailRequestHTML sendMessageWithAttachment(@RequestBody EmailRequestHTML emailRequest){
        return emailServiceHTML.sendMessageWithAttachment(emailRequest);
    }
    @PostMapping("/html/multi-attach")
    public EmailRequestHTML sendMessageWithMultiAttachment(@RequestBody EmailRequestHTML emailRequest){
        return emailServiceHTML.sendMessageWithMultiAttachment(emailRequest);
    }
    
    @PostMapping("/html/multi-attach/object")
    public Iterable<EmailRequestHTML> sendMessageWithAttachmentMultipleObject(@RequestBody Iterable<EmailRequestHTML> emailRequests){
        return emailServiceHTML.sendMessageWithAttachmentMultipleObject(emailRequests);
    }
    
    
    
}
