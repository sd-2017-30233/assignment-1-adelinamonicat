package dataAccesser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import model.Employee;

public class EmployeeGateway {

	private Employee employee;
	private JComboBox box;
	private int idE;
	private String name;
	private String pass;
	private Connection cnx = null;

	public EmployeeGateway() {

	}

	public EmployeeGateway(JComboBox box) {
		this.box = box;

	}

	public EmployeeGateway(String name, String pass) {
		this.name = name;
		this.pass = pass;
	}

	public void insertEmp() {

		String query = " insert into employee(name, password)"

				+ " values (?, ?)";
		DBConnection db = new DBConnection();
		Connection cnx = null;
		try {
			cnx = db.connect();
			PreparedStatement preparedStmt = cnx.prepareStatement(query);
			preparedStmt.setString(1, name);
			preparedStmt.setString(2, pass);

			preparedStmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateEmp(int id, String uName, String uPass) {
		String query = "UPDATE employee SET name=?, password=? WHERE idemployee= ? ";
		PreparedStatement preparedStmt;
		DBConnection db = new DBConnection();
		Connection cnx = null;
		try {
			cnx = db.connect();
			preparedStmt = cnx.prepareStatement(query);

			preparedStmt.setString(1, uName);

			preparedStmt.setString(2, uPass);
			preparedStmt.setInt(3, id);

			preparedStmt.executeUpdate();

			cnx.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void deleteEmp(int idEm) {

		String query = "DELETE FROM employee WHERE idemployee = ? ";
		PreparedStatement preparedStmt;
		DBConnection db = new DBConnection();
		Connection cnx = null;
		try {
			cnx = db.connect();
			preparedStmt = cnx.prepareStatement(query);

			preparedStmt.setInt(1, idEm);
			preparedStmt.executeUpdate();

			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void fillCombo() {
		try {
			String query = "SELECT * FROM employee";
			DBConnection db = new DBConnection();
			Connection cnx = null;
			cnx = db.connect();
			// create the java statement
			Statement st;
			st = cnx.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {

				String id = rs.getString("idemployee");
				box.addItem(id);
			}
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void fillFields(JTextField nameE, JTextField passE, int idEm) {
		String query = "SELECT * FROM employee where idemployee = ?";
		PreparedStatement pst;
		DBConnection db = new DBConnection();
		Connection cnx = null;
		try {
			cnx = db.connect();
			pst = cnx.prepareStatement(query);
			pst.setInt(1, idEm);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				nameE.setText((rs.getString("name")));
				passE.setText(rs.getString("password"));

			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public boolean match(String nameC, String passC) {
		boolean boo = false;
		String query = "SELECT * FROM employee where name=?";
		PreparedStatement pst;
		DBConnection db = new DBConnection();
		Connection cnx = null;
		try {
			cnx = db.connect();
			pst = cnx.prepareStatement(query);
			pst.setString(1, nameC);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				if (passC.equals(rs.getString("password")))
					boo = true;
				else
					boo = false;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return boo;
	}

}
