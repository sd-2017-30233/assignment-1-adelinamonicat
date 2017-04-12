package businessLogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dataAccesser.DBConnection;

public class TransferTransactionScript {
	private TransferTransactionScript acc;

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
				balance = rs1.getInt("amount");
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		return balance;

	}

	public void updateBalance(int amount, int idClient) {
		String query = "UPDATE account SET amount=? WHERE client_idclient = ? ";
		PreparedStatement preparedStmt;
		DBConnection db = new DBConnection();
		Connection cnx = null;
		try {
			cnx = db.connect();
			preparedStmt = cnx.prepareStatement(query);

			preparedStmt.setInt(1, amount);

			preparedStmt.setInt(2, idClient);

			// execute the java preparedstatement
			preparedStmt.executeUpdate();

			cnx.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void transfer(int ac1, int ac2, int amount) {

		acc = new TransferTransactionScript();

		int balN1 = acc.retAmount(ac1);
		int balN2 = acc.retAmount(ac2);

		balN1 -= amount;
		balN2 += amount;

		acc.updateBalance(balN1, ac1);
		acc.updateBalance(balN2, ac2);

	}

	public void payBill(int accountId, int amount) {
		acc = new TransferTransactionScript();

		int bal = acc.retAmount(accountId);
		bal -= amount;

		acc.updateBalance(bal, accountId);
	}
}
