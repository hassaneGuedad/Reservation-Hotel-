package Entities;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reservation {
    
	private int id_r;
	private Date datedebut;
	private Date datefin;
	private Client c;
	private Chambre ch;
        private static int count =0;
	
	
	public Reservation(Date datedebut, Date datefin, Client c, Chambre ch) {
		super();
                this.id_r = ++count;
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.c = c;
		this.ch = ch;
	}
        
        public Reservation(int id, Date datedebut, Date datefin, Client c, Chambre ch) {
		super();
                this.id_r = id;
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.c = c;
		this.ch = ch;
	}
        
        	public int getId_r() {
		return id_r;
	}


	public void setId_r(int id_r) {
		this.id_r = id_r;
	}
	public Date getDatedebut() {
		return datedebut;
	}
	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}
	public Date getDatefin() {
		return datefin;
	}
	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}
	public Client getC() {
		return c;
	}
	public void setC(Client c) {
		this.c = c;
	}
	public Chambre getCh() {
		return ch;
	}
	public void setCh(Chambre ch) {
		this.ch = ch;
	}
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		return "Reservation [datedebut=" + sdf.format(datedebut) + ", datefin=" + sdf.format(datefin) + ", c=" + c + ", ch=" + ch + "]";
	}
	
	

}
