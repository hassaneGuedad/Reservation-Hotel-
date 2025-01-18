 package Service;

import Entities.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connection.Connexion;
import DAO.IDAO;



public class ReservationService implements IDAO<Reservation> {

	@Override
	public boolean Create(Reservation o) {
        final String query1 = "INSERT INTO reservation (id_r, dateDebut, dateFin, id, id_ch) VALUES (null,?,?,?,?)";
        try {
        PreparedStatement ps = Connexion.getCnx().prepareStatement(query1);
        ps.setDate(1, new java.sql.Date(o.getDatedebut().getTime()));
        ps.setDate(2, new java.sql.Date(o.getDatefin().getTime()));
        ps.setInt(3, o.getC().getId());
        ps.setInt(4, o.getCh().getId_ch());
        if (ps.executeUpdate() == 1) 
            return true;
        
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
		return false;
	
}
	@Override
	public boolean Update(Reservation o) {
	            String query2 = "UPDATE reservation SET dateDebut=?, dateFin=?, id=?, id_ch=? WHERE id_r=?";
	            try {
	            PreparedStatement ps = Connexion.getCnx().prepareStatement(query2);
	            ps.setDate(1, new java.sql.Date(o.getDatedebut().getTime()));
	            ps.setDate(2, new java.sql.Date(o.getDatefin().getTime()));
                    ps.setInt(3, o.getC().getId());
                    ps.setInt(4, o.getCh().getId_ch());
	            ps.setInt(5, o.getId_r());
	            if (ps.executeUpdate() == 1) {
	                return true;
	            }
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
		return false;
	}

	@Override
	public boolean Delete(Reservation o) {
	            String query = "DELETE FROM reservation WHERE id_r=?";
	            try {
                        System.out.println(o);
	            PreparedStatement ps = Connexion.getCnx().prepareStatement(query);
	            ps.setInt(1, o.getId_r());
	            if (ps.executeUpdate() == 1) {
	                return true;
	            }
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
		return false;
	}

	@Override
	public Reservation findById(int id) {
	            String query = "SELECT * FROM reservation WHERE id_r=?";
	            try {
	            PreparedStatement ps = Connexion.getCnx().prepareStatement(query);
	            ps.setInt(1, id);
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	                ClientService clientService = new ClientService();
	                Client client = clientService.findById(rs.getInt("id"));
	                ChambreService chambreService = new ChambreService();
	                Chambre chambre = chambreService.findById(rs.getInt("id_ch"));
	                return new Reservation(rs.getInt("id_r"),rs.getDate("dateDebut"), rs.getDate("dateFin"), client, chambre);
	            }
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
		return null;
	}


	@Override
	public List<Reservation> findAll() {
		 List<Reservation> reservations = new ArrayList<>();
	        
	            final String query = "SELECT * FROM reservation";
	            try {
	            PreparedStatement ps = Connexion.getCnx().prepareStatement(query);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	                ClientService clientService = new ClientService();
	                Client client = clientService.findById(rs.getInt("id"));
	                ChambreService chambreService = new ChambreService();
	                Chambre chambre = chambreService.findById(rs.getInt("id_ch"));
	                if (client != null && chambre != null) {
	                    Reservation reservation = new Reservation(rs.getInt("id_r"),rs.getDate("dateDebut"), rs.getDate("dateFin"), client, chambre);
	                    reservations.add(reservation);

	                    // Decorated display
	                    System.out.println("Reservation Details:");
	                    System.out.println("--------------------");
	                    System.out.println("Client: " + client.getNom() + " " + client.getPrenom());
	                    System.out.println("Chambre ID: " + chambre.getId_ch());
	                    System.out.println("Date Debut: " + reservation.getDatedebut());
	                    System.out.println("Date Fin: " + reservation.getDatefin());
	                    System.out.println("--------------------\n");
	                } else {
	                    System.out.println("Client or Chambre not found for reservation ID: " + rs.getInt("id"));
	                }
	            }
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
 	}
				return reservations;

}
	
}