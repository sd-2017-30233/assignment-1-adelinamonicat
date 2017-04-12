package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;

import businessLogic.AccountBusinessLogic;
import businessLogic.TransferTransactionScript;

import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AccountFrame {

	JFrame frame;
	private JTextField insOP;
	private JTextField insType;
	private JTextField insAmount;
	private JTextField insDate;
	private JTextField uAmount;
	private JTextField uDate;
	private JTextField vID;
	private JTextField vType;
	private JTextField transferAm;
	private TransferTransactionScript transfer;
	private JTextField payField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountFrame window = new AccountFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AccountFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1011, 580);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblAccount = new JLabel("Account");
		lblAccount.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAccount.setBounds(12, 13, 95, 41);
		frame.getContentPane().add(lblAccount);

		JLabel lbllszxa = new JLabel("Insert new account");
		lbllszxa.setBounds(22, 52, 114, 41);
		frame.getContentPane().add(lbllszxa);

		insOP = new JTextField();
		insOP.setColumns(100);
		insOP.setBounds(121, 128, 184, 28);
		frame.getContentPane().add(insOP);

		JLabel label_2 = new JLabel("Operation:");
		label_2.setBounds(52, 128, 57, 36);
		frame.getContentPane().add(label_2);

		JLabel lblType = new JLabel("Type:");
		lblType.setBounds(52, 177, 57, 28);
		frame.getContentPane().add(lblType);

		insType = new JTextField();
		insType.setColumns(10);
		insType.setBounds(121, 175, 184, 28);
		frame.getContentPane().add(insType);

		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setBounds(51, 218, 57, 28);
		frame.getContentPane().add(lblAmount);

		insAmount = new JTextField();
		insAmount.setColumns(10);
		insAmount.setBounds(121, 218, 184, 28);
		frame.getContentPane().add(insAmount);

		insDate = new JTextField();
		insDate.setColumns(10);
		insDate.setBounds(121, 259, 184, 28);
		frame.getContentPane().add(insDate);

		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(51, 259, 57, 28);
		frame.getContentPane().add(lblDate);

		JLabel label_6 = new JLabel("View and Update");
		label_6.setBounds(335, 43, 200, 50);
		frame.getContentPane().add(label_6);

		JLabel lblId = new JLabel("Id:");
		lblId.setBounds(366, 130, 57, 28);
		frame.getContentPane().add(lblId);

		JLabel lblAmount_1 = new JLabel("Amount:");
		lblAmount_1.setBounds(366, 218, 57, 28);
		frame.getContentPane().add(lblAmount_1);

		uAmount = new JTextField();
		uAmount.setColumns(10);
		uAmount.setBounds(436, 218, 184, 28);
		frame.getContentPane().add(uAmount);

		JLabel lblDate_1 = new JLabel("Date:");
		lblDate_1.setBounds(366, 259, 57, 28);
		frame.getContentPane().add(lblDate_1);

		uDate = new JTextField();
		uDate.setColumns(10);
		uDate.setBounds(436, 259, 184, 28);
		frame.getContentPane().add(uDate);

		JLabel lblType_1 = new JLabel("Type:");
		lblType_1.setBounds(366, 177, 57, 28);
		frame.getContentPane().add(lblType_1);

		JLabel lblDeleteAccount = new JLabel("Delete account");
		lblDeleteAccount.setBounds(669, 41, 200, 50);
		frame.getContentPane().add(lblDeleteAccount);

		JLabel label_1 = new JLabel("Id:");
		label_1.setBounds(704, 85, 57, 28);
		frame.getContentPane().add(label_1);

		JComboBox deleteCombo = new JComboBox();
		deleteCombo.setBounds(773, 83, 181, 28);
		frame.getContentPane().add(deleteCombo);

		JComboBox insCombo = new JComboBox();
		insCombo.setBounds(121, 85, 181, 28);
		frame.getContentPane().add(insCombo);

		JComboBox idC = new JComboBox();
		idC.setBounds(435, 85, 181, 28);
		frame.getContentPane().add(idC);
		AccountBusinessLogic accountBusinessLogicI = new AccountBusinessLogic(idC);
		AccountBusinessLogic accountBusinessLogicA = new AccountBusinessLogic(insCombo);
		AccountBusinessLogic accountBusinessLogicD = new AccountBusinessLogic(deleteCombo);
		accountBusinessLogicI.AccountBusinessLogicCombo3();
		accountBusinessLogicA.AccountBusinessLogicCombo1();
		accountBusinessLogicD.AccountBusinessLogicCombo3();

		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					// String idOperation =
					// insCombo.getSelectedItem().toString();
					String insI = insOP.getText();

					String iType = insType.getText();
					int iAmount = Integer.parseInt(insAmount.getText());
					String iDate = insDate.getText();

					accountBusinessLogicA.insertAccount(insI, 1, iType, iAmount, iDate);

					insOP.setText("");
					insType.setText("");
					insAmount.setText("");
					insDate.setText("");
					idC.removeAllItems();
					accountBusinessLogicI.AccountBusinessLogicCombo3();
					deleteCombo.removeAllItems();
					accountBusinessLogicD.AccountBusinessLogicCombo3();
				} catch (NumberFormatException e1) {
					e1.printStackTrace();
					System.out.println("Completati toate field-urile");
				}

			}
		});
		btnInsert.setBounds(109, 300, 97, 25);
		frame.getContentPane().add(btnInsert);

		vID = new JTextField();
		vID.setColumns(10);
		vID.setBounds(436, 128, 184, 28);
		frame.getContentPane().add(vID);

		vType = new JTextField();
		vType.setColumns(10);
		vType.setBounds(436, 169, 184, 28);
		frame.getContentPane().add(vType);

		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String viewID = idC.getSelectedItem().toString();
				accountBusinessLogicI.fillFields(vID, vType, uAmount, uDate, viewID);
			}
		});
		btnView.setBounds(346, 300, 97, 25);
		frame.getContentPane().add(btnView);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int viewID = Integer.parseInt(idC.getSelectedItem().toString());

					int insID = Integer.parseInt(vID.getText());
					String type = vType.getText();
					int amount = Integer.parseInt(uAmount.getText());
					String date = uDate.getText();
					accountBusinessLogicA.updateAccount(type, amount, date, viewID);
					// account = new AccountGateway(viewID, type, amount, date);
					// account.updateAccount(type, amount, date, viewID);

					vID.setText("");
					vType.setText("");
					uAmount.setText("");
					uDate.setText("");
				} catch (NumberFormatException e1) {
					System.out.println("Completati toate field-urile");
				}

			}
		});
		btnUpdate.setBounds(497, 300, 97, 25);
		frame.getContentPane().add(btnUpdate);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int del = Integer.parseInt(deleteCombo.getSelectedItem().toString());
				accountBusinessLogicD.deleteAccount(del);
				idC.removeAllItems();
				accountBusinessLogicI.AccountBusinessLogicCombo3();

				deleteCombo.removeAllItems();
				accountBusinessLogicD.AccountBusinessLogicCombo3();
			}
		});
		btnDelete.setBounds(756, 149, 97, 25);
		frame.getContentPane().add(btnDelete);

		JLabel lblIdClient = new JLabel("Id client:");
		lblIdClient.setBounds(52, 91, 56, 16);
		frame.getContentPane().add(lblIdClient);

		JLabel label = new JLabel("Id client:");
		label.setBounds(367, 91, 56, 16);
		frame.getContentPane().add(label);

		JLabel lblTransfer = new JLabel("Transfer");
		lblTransfer.setBounds(669, 209, 56, 16);
		frame.getContentPane().add(lblTransfer);

		JLabel lblFrom = new JLabel("From:");
		lblFrom.setBounds(705, 265, 56, 16);
		frame.getContentPane().add(lblFrom);

		JLabel lblTo = new JLabel("To:");
		lblTo.setBounds(704, 304, 56, 16);
		frame.getContentPane().add(lblTo);
		JComboBox fromCombo = new JComboBox();
		fromCombo.setBounds(756, 262, 181, 28);
		frame.getContentPane().add(fromCombo);
		AccountBusinessLogic accountBusinessLogicFrom = new AccountBusinessLogic(fromCombo);
		accountBusinessLogicFrom.AccountBusinessLogicCombo3();

		JComboBox toCombo = new JComboBox();
		toCombo.setBounds(756, 301, 181, 28);
		frame.getContentPane().add(toCombo);
		AccountBusinessLogic accountBusinessLogicTo = new AccountBusinessLogic(toCombo);
		accountBusinessLogicTo.AccountBusinessLogicCombo3();

		transferAm = new JTextField();
		transferAm.setColumns(10);
		transferAm.setBounds(756, 345, 184, 28);
		frame.getContentPane().add(transferAm);

		JButton btnTransfer = new JButton("Transfer");
		btnTransfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int from = Integer.parseInt(fromCombo.getSelectedItem().toString());
				int to = Integer.parseInt(toCombo.getSelectedItem().toString());
				int amountToTransfer = Integer.parseInt(transferAm.getText());

				transfer = new TransferTransactionScript();
				transfer.transfer(from, to, amountToTransfer);
				transferAm.setText("");

			}
		});
		btnTransfer.setBounds(756, 390, 97, 25);
		frame.getContentPane().add(btnTransfer);

		JLabel lblAmount_2 = new JLabel("Amount:");
		lblAmount_2.setBounds(704, 348, 56, 16);
		frame.getContentPane().add(lblAmount_2);

		JLabel lblPayBills = new JLabel("Pay bills");
		lblPayBills.setBounds(22, 364, 56, 16);
		frame.getContentPane().add(lblPayBills);

		JLabel lblAccountId = new JLabel("Id:");
		lblAccountId.setBounds(52, 413, 45, 16);
		frame.getContentPane().add(lblAccountId);

		JLabel lblAmount_3 = new JLabel("Amount:");
		lblAmount_3.setBounds(52, 452, 56, 16);
		frame.getContentPane().add(lblAmount_3);

		payField = new JTextField();
		payField.setColumns(10);
		payField.setBounds(121, 449, 184, 28);
		frame.getContentPane().add(payField);

		JComboBox payCombo = new JComboBox();
		payCombo.setBounds(124, 410, 181, 28);
		frame.getContentPane().add(payCombo);

		AccountBusinessLogic accountBusinessLogicPay = new AccountBusinessLogic(payCombo);
		accountBusinessLogicPay.AccountBusinessLogicCombo3();

		JButton btnPay = new JButton("Pay");
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int paySource = Integer.parseInt(payCombo.getSelectedItem().toString());
				int amountBill = Integer.parseInt(payField.getText());

				transfer = new TransferTransactionScript();
				transfer.payBill(paySource, amountBill);

				payField.setText("");

			}
		});
		btnPay.setBounds(109, 495, 97, 25);
		frame.getContentPane().add(btnPay);

		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 16));
		button.setBounds(426, 495, 97, 25);
		frame.getContentPane().add(button);

	}
}
