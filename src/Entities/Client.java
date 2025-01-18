package Entities;

public class Client {
	
	private int id;
	private String nom;
	private String prenom;
	private String tele;
	private String email;
	private static int count=0; 
	
	
	public Client(String nom, String prenom, String tele, String email) {
		super();
		this.id = ++count;
		this.nom = nom;
		this.prenom = prenom;
		this.tele = tele;
		this.email = email;
	}
	public Client(int id, String nom, String prenom, String tele, String email) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.tele = tele;
		this.email = email;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public String getTele() {
		return tele;
	}


	public void setTele(String tele) {
		this.tele = tele;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return nom+" "+prenom;
	}
	
	

}
