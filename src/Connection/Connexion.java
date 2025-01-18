package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {

	private static final String url= "jdbc:mysql://localhost:3306/reservation?serverTimezone=UTC";
	private static final String username= "root";
	private static final String password= "";
	private static Connection cnx = null;



	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Pilote chargé"); // Vérification
			cnx = DriverManager.getConnection(url, username, password);
			System.out.println("Connexion réussie !");
		} catch (ClassNotFoundException e) {
			System.out.println("Erreur de chargement du pilote");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Erreur de connexion à la base de données");
			e.printStackTrace();
		}
	}
	
	public static Connection getCnx() {
		return cnx;
	}

}
