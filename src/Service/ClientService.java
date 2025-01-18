package Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connection.Connexion;
import DAO.IDAO;
import Entities.Client;

public class ClientService implements IDAO<Client>{

	@Override
	public boolean Create(Client o) {
		final String query1 ="insert into Client values (null,?,?,?,?)";
		try {
			PreparedStatement ps = Connexion.getCnx().prepareStatement(query1);
			ps.setString(1, o.getNom());
			ps.setString(2, o.getPrenom());
			ps.setString(3, o.getTele());
			ps.setString(4, o.getEmail());
			if(ps.executeUpdate()==1)
				return true;
		} catch (SQLException e) {
			System.out.println("Erreur de création du client");
		}
		return false;
	}

	@Override
	public boolean Update(Client o) {
		final String query2 ="update Client set nom=?,prenom=?,tele=?,email=? where id=?";
		try {
			PreparedStatement ps = Connexion.getCnx().prepareStatement(query2);
			ps.setString(1, o.getNom());
			ps.setString(2, o.getPrenom());
			ps.setString(3, o.getTele());
			ps.setString(4, o.getEmail());
			ps.setInt(5, o.getId());
			if(ps.executeUpdate()==1)
				return true;
		} catch (SQLException e) {
			System.out.println("Erreur de modification");
		}
		return false;
	}

	@Override
	public boolean Delete(Client o) {
		final String query ="delete from Client where id=?";
		try {
			PreparedStatement ps = Connexion.getCnx().prepareStatement(query);
			ps.setInt(1, o.getId());
			if(ps.executeUpdate()==1)
				return true;
		} catch (SQLException e) {
			System.out.println("Erreur de suppression");
		}
		return false;
	}

	@Override
	public Client findById(int id) {
		final String query3 = "select * from Client where id=?";
		try {
			PreparedStatement ps = Connexion.getCnx().prepareStatement(query3);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				return new Client(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getString(5));
			} catch (SQLException e) {
			System.out.println("Erreur de selection by id");
		}
		return null;
	}

	@Override
	public List<Client> findAll() {
		final String query4 = "select * from Client";
		List<Client> ls = new ArrayList<>();
		try {
			PreparedStatement ps = Connexion.getCnx().prepareStatement(query4);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ls.add( new Client(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getString(5)));
			}
			return ls;
			} catch (SQLException e) {
			System.out.println("Erreur de selection");
		}
		return null;
	}


	
	

}
