package com.learn.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.learn.cursomc.domain.Pedido;

public interface EmailService {
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
}