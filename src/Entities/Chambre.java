package Entities;

public class Chambre {
	private int id_ch;
	private String telephone;
	private Categorie cat;
	private static int count =0;
	
	
	public Chambre(String telephone, Categorie cat) {
		super();
		this.id_ch = ++count;
		this.telephone = telephone;
		this.cat = cat;
	}
	
	public Chambre(int id_ch, String telephone, Categorie cat) {
		super();
		this.id_ch = id_ch;
		this.telephone = telephone;
		this.cat = cat;
	}


	public int getId_ch() {
		return id_ch;
	}


	public void setId_ch(int id_ch) {
		this.id_ch = id_ch;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public Categorie getCat() {
		return cat;
	}


	public void setCat(Categorie cat) {
		this.cat = cat;
	}


	@Override
	public String toString() {
		return cat.getLibelle();
	}

	
}
