package com.majorbit.ejbs;

import java.util.Properties;

import javax.ejb.Stateful;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.ws.rs.core.Response;

import com.majorbit.model.Email;

@Stateful(name="emailService",mappedName="ejb/emailServiceImplEJBJNDI")
public class EmailServiceImpl implements EmailService{

	@Override
	public String sendmail(Email email) {
		String risposta = "";
        String destinatario = email.getEmailDestinatario();
        String titolo = email.getTitolo();
        String messaggio = email.getMessaggio();

        String host = "smtp.gmail.com"; // 
        String username = "mailsocialmbit@gmail.com"; 
        String password = "anenntpupjbexwet"; // 

        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            message.setSubject(titolo);
            message.setText(messaggio);

            Transport.send(message);

            risposta = "Email inviata";
        } catch (MessagingException e) {
            e.printStackTrace();
            risposta =  "Errore durante l'invio dell'email";
        }
        return risposta;
    }

}
