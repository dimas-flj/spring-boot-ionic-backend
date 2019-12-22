package com.learn.cursomc.services;

import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.learn.cursomc.config.AppGlobalConfigurations;
import com.learn.cursomc.domain.Cliente;
import com.learn.cursomc.domain.Pedido;

public abstract class AbstractEmailService implements EmailService {
	@Autowired
	private TemplateEngine templateEngine;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private AppGlobalConfigurations gConfig;
	
	private String mail_sender;
	
	public void sendOrderConfirmationEmail(Pedido obj) {
		SimpleMailMessage sm = prepareSimpleMailMessageFromPedido(obj);
		sendEmail(sm);
	}
	
	protected SimpleMailMessage prepareSimpleMailMessageFromPedido(Pedido obj) {
		mail_sender = gConfig.getMail().getSender();
		
		SimpleMailMessage sm = new SimpleMailMessage();
		
		sm.setTo(obj.getCliente().getEmail());
		sm.setFrom(mail_sender);
		sm.setSubject("Pedido confirmado: Código(" + obj.getId() + ")");
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText(obj.toString());
		
		return sm;
	}
	
	protected String htmlFromTemplatePedido(Pedido obj) {
		Context context = new Context();
		context.setVariable("pedido", obj);
		
		return templateEngine.process("email/confirmacaoPedido", context);
	}
	
	public void sendOrderConfirmationHtmlEmail(Pedido obj) {
		try {
			MimeMessage mm = prepareMimeMessageFromPedido(obj);
			sendHtmlEmail(mm);
		}
		catch(MessagingException e) {
			e.printStackTrace();
			
			sendOrderConfirmationEmail(obj);
		}
	}
	
	protected MimeMessage prepareMimeMessageFromPedido(Pedido obj) throws MessagingException {
		mail_sender = gConfig.getMail().getSender();
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mmh = new MimeMessageHelper(mimeMessage, true);
		
		mmh.setTo(obj.getCliente().getEmail());
		mmh.setFrom(mail_sender);
		mmh.setSubject("Pedido confirmado: Código(" + obj.getId() + ")");
		mmh.setSentDate(new Date(System.currentTimeMillis()));
		mmh.setText(htmlFromTemplatePedido(obj), true);
		
		return mimeMessage;
	}
	
	public void sendNewPasswordEmail(Cliente cliente, String newPass) {
		SimpleMailMessage sm = prepareNewPasswordEmail(cliente, newPass);
		sendEmail(sm);
		
	}
	
	protected SimpleMailMessage prepareNewPasswordEmail(Cliente cliente, String newPass) {
		mail_sender = gConfig.getMail().getSender();
		SimpleMailMessage sm = new SimpleMailMessage();
		
		sm.setTo(cliente.getEmail());
		sm.setFrom(mail_sender);
		sm.setSubject("Solicitação de nova senha.");
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText("Nova senha: " + newPass);
		
		return sm;
	}
}