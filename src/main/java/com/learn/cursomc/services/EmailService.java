package com.learn.cursomc.services;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import com.learn.cursomc.domain.Pedido;

public interface EmailService {
	// VERSAO TEXTO PLANO ::::::::::::
	void sendOrderConfirmationEmail(Pedido obj);
	void sendEmail(SimpleMailMessage msg);
	// VERSAO TEXTO PLANO ::::::::::::
	
	// VERSAO HTML ::::::::::::
	void sendOrderConfirmationHtmlEmail(Pedido obj);
	void sendHtmlEmail(MimeMessage msg);
	// VERSAO HTML ::::::::::::
}