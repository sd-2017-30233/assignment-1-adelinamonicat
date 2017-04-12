package dataAccesser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JTextField;

public class AccountGateway {

	private int idCl, amount;
	private String type, dateCr;
	private JComboBox box;

	public AccountGateway() {

	}

	public AccountGateway(int idCl, String type, int amount, String dateCr) {
		this.idCl = idCl;
		this.type = type;
		this.amount = amount;
		this.dateCr = dateCr;
	}

	public AccountGateway(JComboBox box) {
		this.box = box;
	}

	public void insertAccount(String operation, int employeeID) {
		String query = " insert into account(client_idclient, type, amount, date, operations_idoperations)"
				+ " values (?, ?, ?, ?,?)";
		String opQuery = "insert into operations(type , employee_idemployee1)" + "values (?, ?)";
		DBConnection db = new DBConnection();
		Connection cnx = null;
		PreparedStatement preparedStmt;
		try {
			cnx = db.connect();
			preparedStmt = cnx.prepareStatement(opQuery, com.mysql.jdbc.Statement.RETURN_GENERATED_KEYS);

			preparedStmt.setString(1, operation);
			preparedStmt.setInt(2, employeeID);
			preparedStmt.execute();
			int operatioID = 0;
			try (ResultSet generatedKeys = preparedStmt.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					operatioID = (int) generatedKeys.getLong(1);
				}
			}
			preparedStmt = cnx.prepareStatement(query);
			preparedStmt.setInt(1, idCl);
			preparedStmt.setString(2, type);
			preparedStmt.setInt(3, amount);
			preparedStmt.setString(4, dateCr);
			preparedStmt.setInt(5, operatioID);

			preparedStmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateAccount(String type, int amount, String date, int idCl) {
		String query = "UPDATE account SET  type=?, amount =?, date=? WHERE client_idclient = ? ";
		PreparedStatement preparedStmt;
		DBConnection db = new DBConnection();
		Connection cnx = null;
		try {
			cnx = db.connect();
			preparedStmt = cnx.prepareStatement(query);
			preparedStmt.setString(1, type);
			preparedStmt.setInt(2, amount);
			preparedStmt.setString(3, date);
			preparedStmt.setInt(4, idCl);

			// execute the java preparedstatement
			preparedStmt.executeUpdate();

			cnx.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void deleteAccount(int idAc) {

		String query = "DELETE FROM account WHERE client_idclient = ? ";
		PreparedStatement preparedStmt;
		DBConnection db = new DBConnection();
		Connection cnx = null;
		try {
			cnx = db.connect();
			preparedStmt = cnx.prepareStatement(query);

			preparedStmt.setInt(1, idAc);
			preparedStmt.executeUpdate();

			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public int retAmount(int idCont) {
		int balance = 0;
		String query1 = "SELECT * FROM account where client_idclient = ?";

		PreparedStatement pst1;
		DBConnection db = new DBConnection();
		Connection cnx = null;
		try {
			cnx = db.connect();
			pst1 = cnx.prepareStatement(query1);
			pst1.setInt(1, idCont);
			ResultSet rs1 = pst1.executeQuery();

			while (rs1.next()) {
				// Object[] v = new Object[]{"" + rs.getInt("idclient"),
				// rs.getString("id_card"), rs.getString("cnp"),
				// rs.getString("adress"), rs.getString("password")};
				balance = rs1.getInt("amount");
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return balance;

	}

	public void fillCombo1() {
		// JComboBox box = null;
		DBConnection db = new DBConnection();
		Connection cnx = null;
		try {
			cnx = db.connect();
			String query = "SELECT * FROM client";

			// create the java statement
			Statement st;
			st = cnx.createStatement();
			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);

			// iterate through the java resultset
			while (rs.next()) {

				String idC = rs.getString("idclient");
				box.addItem(idC);
			}
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void fillCombo2() {
		DBConnection db = new DBConnection();
		Connection cnx = null;
		try {
			cnx = db.connect();
			String query = "SELECT * FROM account";

			// create the java statement
			Statement st;
			st = cnx.createStatement();
			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);

			// iterate through the java resultset
			while (rs.next()) {

				String acc = rs.getString("idaccount");
				box.addItem(acc);
			}
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void fillCombo3() {
		DBConnection db = new DBConnection();
		Connection cnx = null;
		try {
			cnx = db.connect();
			String query = "SELECT * FROM account";

			// create the java statement
			Statement st;
			st = cnx.createStatement();
			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);

			// iterate through the java resultset
			while (rs.next()) {

				String idC = rs.getString("client_idclient");
				box.addItem(idC);
			}
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void fillFields(JTextField idAcc, JTextField type, JTextField amount, JTextField date, String idClient) {
		String query = "SELECT * FROM account where client_idclient = ?";
		PreparedStatement pst;
		DBConnection db = new DBConnection();
		Connection cnx = null;
		try {
			cnx = db.connect();
			pst = cnx.prepareStatement(query);
			pst.setString(1, idClient);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				idAcc.setText(Integer.toString(rs.getInt("idaccount")));
				type.setText(rs.getString("type"));
				amount.setText(rs.getString("amount"));
				date.setText(rs.getString("date"));

			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

}
