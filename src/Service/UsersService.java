/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Connection.Connexion;
import DAO.IDAO;
import Entities.Users;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author PC
 */
public class UsersService implements IDAO<Users>{

    @Override
    public boolean Create(Users o) {
        		final String query1 ="insert into Users values (null,?,?,?,?)";
		try {
			PreparedStatement ps = Connexion.getCnx().prepareStatement(query1);
			ps.setString(1, o.getNom());
			ps.setString(2, o.getPrenom());
			ps.setString(3, o.getLogin());
			ps.setString(4, o.getPassword());
			if(ps.executeUpdate()==1)
				return true;
		} catch (SQLException e) {
			System.out.println("Erreur de création du user");
		}
		return false;
    }

    @Override
    public boolean Update(Users o) {
        		final String query2 ="update Users set nom=?,prenom=?,login=?,password=? where id_u=?";
		try {
			PreparedStatement ps = Connexion.getCnx().prepareStatement(query2);
			ps.setString(1, o.getNom());
			ps.setString(2, o.getPrenom());
			ps.setString(3, o.getLogin());
			ps.setString(4, o.getPassword());
			ps.setInt(5, o.getId_U());
			if(ps.executeUpdate()==1)
				return true;
		} catch (SQLException e) {
			System.out.println("Erreur de modification");
		}
		return false;
    }

    @Override
    public boolean Delete(Users o) {
        		final String query ="delete from Users where id_u=?";
		try {
			PreparedStatement ps = Connexion.getCnx().prepareStatement(query);
			ps.setInt(1, o.getId_U());
			if(ps.executeUpdate()==1)
				return true;
		} catch (SQLException e) {
			System.out.println("Erreur de suppression");
		}
		return false;
    }

    @Override
    public Users findById(int id) {
        		final String query3 = "select * from Users where id_u=?";
		try {
			PreparedStatement ps = Connexion.getCnx().prepareStatement(query3);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				return new Users(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getString(5));
			} catch (SQLException e) {
			System.out.println("Erreur de selection by id");
		}
		return null;
    }

    @Override
    public List<Users> findAll() {
        		final String query4 = "select * from Users";
		List<Users> ls = new ArrayList<>();
		try {
			PreparedStatement ps = Connexion.getCnx().prepareStatement(query4);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ls.add( new Users(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getString(5)));
			}
			return ls;
			} catch (SQLException e) {
			System.out.println("Erreur de selection");
		}
		return null;
    }
    
    public static boolean validateUser(String login, String password) {
    String query = "SELECT COUNT(*) AS user_count FROM users WHERE login = ? AND password = ?";

    try {
    PreparedStatement ps = Connexion.getCnx().prepareStatement(query);
        ps.setString(1, login);
        ps.setString(2, password);
        ResultSet resultSet = ps.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt("user_count") > 0; 
        }
    } catch (SQLException e) {
        System.err.println("Erreur lors de la validation de l'utilisateur : " + e.getMessage());
    }

    return false; 
}
    
}
   

