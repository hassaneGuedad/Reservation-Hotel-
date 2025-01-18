/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

/**
 *
 * @author PC
 */
public class Users {
 private int id_u;
    private String nom;
    private String prenom;
    private String login;
    private String password;
    private static int count=0;
    
	public Users(int id_u, String nom, String prenom, String login, String password) {
		super();
		this.id_u = ++count;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
	}
        
        
       public Users(String nom, String prenom, String login, String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
	}

	public int getId_U() {
		return id_u;
	}

	public void setId(int id_u) {
		this.id_u = id_u;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Users [id=" + id_u + ", nom=" + nom + ", prenom=" + prenom + ", login=" + login + ", password=" + password
				+ "]";
	}
	
	

}


