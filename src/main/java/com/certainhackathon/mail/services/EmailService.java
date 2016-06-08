package com.certainhackathon.mail.services;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.certainhackathon.mail.model.MailInfo;

@Service
public class EmailService {

    @Autowired 
    private JavaMailSender mailSender;
    
    @Autowired
    TemplateEngine templateEngine;
    
    
    public void sendSimpleMail(MailInfo info, Context ctx) throws MessagingException {
    	sendSimpleMail(info, ctx, true);
    }    
    
    public void sendSimpleMail(MailInfo info, Context ctx, boolean additioanlRecipients) throws MessagingException {
        final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
        final MimeMessageHelper message = new MimeMessageHelper(mimeMessage, "UTF-8");
        message.setSubject(info.getSubject());
        message.setFrom("admin@certain-hackathon.com");
        message.setTo(info.getRecipient());
        
        final String htmlContent = this.templateEngine.process(info.getTemplate(), ctx);
        message.setText(htmlContent, true);
        
        try {
			this.mailSender.send(mimeMessage);
		} catch (MailException e) {
			e.printStackTrace();
			throw e;
		}
    }
    
}
