package com.curso.mc.service;


import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import com.curso.mc.domain.Cliente;
import com.curso.mc.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);

	void sendEmail(SimpleMailMessage msg);

	void sendOrderConfirmationHtmlEmail(Pedido obj);

	void sendHtmlEmail(MimeMessage msg);
	
	void sendNewPasswordEmail(Cliente cliente, String newPass);

}