package Entities;

public class Categorie {
	private int id_cat;
	private String code;
	private  String libelle;
	private static int count = 0;
	
	
	public Categorie(String code, String libelle) {
		super();
		this.id_cat = ++count;
		this.code = code;
		this.libelle = libelle;
	}
	
	public Categorie(int id_cat, String code, String libelle) {
		super();
		this.id_cat = id_cat;
		this.code = code;
		this.libelle = libelle;
	}


	public int getId_cat() {
		return id_cat;
	}


	public void setId(int id_cat) {
		this.id_cat = id_cat;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	@Override
	public String toString() {
		return  libelle ;
	}
	
	

}
