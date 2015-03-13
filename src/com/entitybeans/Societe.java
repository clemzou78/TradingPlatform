package com.entitybeans;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the societe database table.
 * 
 */
@Entity
@NamedQuery(name="Societe.findAll", query="SELECT s FROM Societe s")
public class Societe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idSociete;

	@Lob
	private String description;

	@Lob
	private String mnemo;

	@Lob
	private String nom;

	//bi-directional one-to-one association to User
	@OneToOne(mappedBy="societe")
	private User user;

	public Societe() {
	}

	public int getIdSociete() {
		return this.idSociete;
	}

	public void setIdSociete(int idSociete) {
		this.idSociete = idSociete;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMnemo() {
		return this.mnemo;
	}

	public void setMnemo(String mnemo) {
		this.mnemo = mnemo;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}