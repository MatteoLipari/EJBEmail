package com.majorbit.model;

import java.io.Serializable;

public class Email implements Serializable{
	private String emailDestinatario,titolo,messaggio;

	public String getEmailDestinatario() {
		return emailDestinatario;
	}

	public void setEmailDestinatario(String emailDestinatario) {
		this.emailDestinatario = emailDestinatario;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getMessaggio() {
		return messaggio;
	}

	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}

	public Email() {}
	public Email(String emailDestinatario, String titolo, String messaggio) {
		this.emailDestinatario = emailDestinatario;
		this.titolo = titolo;
		this.messaggio = messaggio;
	}
	
}

