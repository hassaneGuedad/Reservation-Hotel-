package Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connection.Connexion;
import DAO.IDAO;
import Entities.Categorie;

public class CategorieService implements IDAO<Categorie>{

	@Override
	public boolean Create(Categorie o) {
		final String query1 ="insert into Categorie values (null,?,?)";
		try {
			PreparedStatement ps = Connexion.getCnx().prepareStatement(query1);
			ps.setString(1, o.getCode());
			ps.setString(2, o.getLibelle());
			if(ps.executeUpdate() == 1)
				return true;
		} catch (SQLException e) {
			System.out.println("Erreur de création");
		}
		return false;
	}

	@Override
	public boolean Update(Categorie o) {
		final String query2 ="update Categorie set code=?,libelle=? where id_cat=?";
		try {
			PreparedStatement ps = Connexion.getCnx().prepareStatement(query2);
			ps.setString(1, o.getCode());
			ps.setString(2, o.getLibelle());
			ps.setInt(3, o.getId_cat());
			if(ps.executeUpdate()==1)
				return true;
		} catch (SQLException e) {
			System.out.println("Erreur de modification");
		}
		return false;
	}

	@Override
	public boolean Delete(Categorie o) {
		final String query ="delete from Categorie where id_cat=?";
		try {
			PreparedStatement ps = Connexion.getCnx().prepareStatement(query);
			ps.setInt(1, o.getId_cat());
			if(ps.executeUpdate()==1)
				return true;
		} catch (SQLException e) {
			System.out.println("Erreur de suppression");
		}
		return false;
	}

	@Override
	public Categorie findById(int id) {
		final String query3 = "select * from Categorie where id_cat=?";
		try {
			PreparedStatement ps = Connexion.getCnx().prepareStatement(query3);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				return new Categorie(rs.getInt(1),rs.getString(2),rs.getString(3));
			} catch (SQLException e) {
			System.out.println("Erreur de selection by id");
		}
		return null;
	}

       
	public Categorie findByLibelle(String libelle) {
		final String query3 = "select * from Categorie where libelle = ?";
		try {
			PreparedStatement ps = Connexion.getCnx().prepareStatement(query3);
			ps.setString(1, libelle);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				return new Categorie(rs.getInt(1),rs.getString(2),rs.getString(3));
			} catch (SQLException e) {
			System.out.println("Erreur de selection by libelle");
		}
		return null;
	}
	@Override
	public List<Categorie> findAll() {
		final String query4 = "select * from Categorie";
		List<Categorie> ls = new ArrayList<>();
		try {
			PreparedStatement ps = Connexion.getCnx().prepareStatement(query4);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ls.add( new Categorie(rs.getInt(1),rs.getString(2),rs.getString(3)));
			}
			return ls;
			} catch (SQLException e) {
			System.out.println("Erreur de selection");
		}
		return null;
	}

}
