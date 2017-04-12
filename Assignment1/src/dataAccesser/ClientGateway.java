package dataAccesser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JTextField;

public class ClientGateway {

	private String name, idCard, cnp, adress, pass;
	private int idClient;
	private JComboBox box ;

	public ClientGateway() {

	}

	public ClientGateway(JComboBox box) {
		this.box = box;
	}

	public ClientGateway( String name, String idCard, String cnp, String adress, String pass) {
		this.idClient = idClient;
		this.name = name;
		this.idCard = idCard;
		this.cnp = cnp;
		this.adress = adress;
		this.pass = pass;
	}

	public boolean insertClient() {
		boolean boo = false;

		String query = " insert into client(name, id_card, cnp, adress, password)" + " values (?, ?, ?, ?, ?)";
		DBConnection db = new DBConnection();
		Connection cnx = null;
		try {
			cnx = db.connect();
			PreparedStatement preparedStmt = cnx.prepareStatement(query);

			preparedStmt.setString(1, name);
			preparedStmt.setString(2, idCard);
			preparedStmt.setString(3, cnp);
			preparedStmt.setString(4, adress);
			preparedStmt.setString(5, pass);

			preparedStmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boo;
	}

	public void updateClient(int id, String name, String idCard, String cnp, String adress, String password) {
		String query = "UPDATE client SET idclient=?, id_card=?, cnp=?, adress =?, password=? WHERE name = ? ";
		PreparedStatement preparedStmt;
		DBConnection db = new DBConnection();
		Connection cnx = null;
		try {
			cnx = db.connect();
			preparedStmt = cnx.prepareStatement(query);

			preparedStmt.setInt(1, id);
			preparedStmt.setString(2, idCard);
			preparedStmt.setString(3, cnp);
			preparedStmt.setString(4, adress);
			preparedStmt.setString(5, password);
			preparedStmt.setString(6, name);

			preparedStmt.executeUpdate();

			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public boolean fillCombo() {
		boolean boo = false;
		try {
			String query = "SELECT * FROM client";

			// create the java statement
			Statement st;
			DBConnection db = new DBConnection();
			Connection cnx = null;
			cnx = db.connect();
			st = cnx.createStatement();
			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {

				String name = rs.getString("name");
				box.addItem(name);
			}
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boo;

	}

	public void fillFields(JTextField idC, JTextField idCard, JTextField cnp, JTextField adress, JTextField pass,
			String name) {
		String query = "SELECT * FROM client where name = ?";
		PreparedStatement pst;
		DBConnection db = new DBConnection();
		Connection cnx = null;
		try {
			cnx = db.connect();
			pst = cnx.prepareStatement(query);
			pst.setString(1, name);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				idC.setText(Integer.toString(rs.getInt("idclient")));
				idCard.setText(rs.getString("id_card"));
				cnp.setText(rs.getString("cnp"));
				adress.setText(rs.getString("adress"));
				pass.setText(rs.getString("password"));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

	public boolean match(String nameC, String passC) {
		boolean boo = false;
		String query = "SELECT * FROM client where name = ?, password = ?";
		PreparedStatement pst;
		DBConnection db = new DBConnection();
		Connection cnx = null;
		try {
			cnx = db.connect();
			pst = cnx.prepareStatement(query);
			pst.setString(1, nameC);
			pst.setString(2, passC);
			boo = true;
			ResultSet rs = pst.executeQuery();

			/*
			 * while(rs.next()){ if (rs.getString("name").equals(nameC) &&
			 * (rs.getString("password").equals(passC))) {boo=true; break;}
			 */

			// }
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		return boo;
	}

}
