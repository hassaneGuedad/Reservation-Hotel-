package Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connection.Connexion;
import DAO.IDAO;
import Entities.Categorie;
import Entities.Chambre;


public class ChambreService implements IDAO<Chambre>{
	

	@Override
	public boolean Create(Chambre o) {
		final String query1 ="insert into Chambre values (null,?,?)";
		try {
			PreparedStatement ps = Connexion.getCnx().prepareStatement(query1);
			ps.setString(1, o.getTelephone());
                        ps.setInt(2,o.getCat().getId_cat() );
			if(ps.executeUpdate() == 1)
				return true;
		} catch (SQLException e) {
			System.out.println("Erreur de création de la chambre");
		}
		return false;
	}

	@Override
	public boolean Update(Chambre o) {
		final String query2 ="update chambre set telephone=?,id_cat=? where id_ch=?";
		try {
			PreparedStatement ps = Connexion.getCnx().prepareStatement(query2);
			ps.setString(1, o.getTelephone());
			ps.setInt(2, o.getCat().getId_cat());
			ps.setInt(3, o.getId_ch());
			if(ps.executeUpdate()==1)
				return true;
		} catch (SQLException e) {
			System.out.println("Erreur de modification");
		}
		return false;
	}

	@Override
	public boolean Delete(Chambre o) {
		final String query ="delete from Chambre where id_ch=?";
		try {
			PreparedStatement ps = Connexion.getCnx().prepareStatement(query);
			ps.setInt(1, o.getId_ch());
                        if(ps.executeUpdate()==1)
				return true;
		} catch (SQLException e) {
			System.out.println("Erreur de suppression");
		}
		return false;
	}

	@Override
	public Chambre findById(int id) {
		final String query3 = "select * from Chambre where id_ch=?";
		try {
			PreparedStatement ps = Connexion.getCnx().prepareStatement(query3);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				CategorieService categorieService = new CategorieService();
                Categorie categorie = categorieService.findById(rs.getInt("id_cat"));
				return new Chambre(rs.getInt(1), rs.getString(2), categorie);}
			} catch (SQLException e) {
			System.out.println("Erreur de selection by id");
		
	}
		return null;
}

	@Override
	public List<Chambre> findAll() {
	       List<Chambre> chambres = new ArrayList<>();
	        try {
	            String query = "SELECT * FROM chambre";
	            PreparedStatement ps = Connexion.getCnx().prepareStatement(query);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	                CategorieService categorieService = new CategorieService();
	                Categorie categorie = categorieService.findById(rs.getInt("id_cat"));
	                Chambre chambre = new Chambre(rs.getString("telephone"), categorie);
	                chambre.setId_ch(rs.getInt("id_ch")); 
	                chambres.add(chambre);
	            }
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
		return chambres;
	}
	

}
