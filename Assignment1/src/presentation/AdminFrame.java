package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;

import businessLogic.EmployeeBusinessLogic;
import dataAccesser.EmployeeGateway;

import javax.swing.JComboBox;
import javax.swing.JButton;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPasswordField;

public class AdminFrame {

	JFrame frame;
	private JTextField insID;
	private JTextField insName;
	private JTextField uName;
	private JPasswordField insPass;
	private JPasswordField uPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminFrame window = new AdminFrame();
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
	public AdminFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 775, 383);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEmployees = new JLabel("Employees");
		lblEmployees.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEmployees.setBounds(12, 13, 118, 22);
		frame.getContentPane().add(lblEmployees);
		
		JLabel lblInsertNewEmployee = new JLabel("Insert new employee");
		lblInsertNewEmployee.setBounds(22, 48, 127, 16);
		frame.getContentPane().add(lblInsertNewEmployee);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setBounds(37, 90, 56, 16);
		frame.getContentPane().add(lblId);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(37, 119, 56, 16);
		frame.getContentPane().add(lblName);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(37, 148, 72, 16);
		frame.getContentPane().add(lblPassword);
		
		insID = new JTextField();
		insID.setBounds(118, 87, 127, 22);
		frame.getContentPane().add(insID);
		insID.setColumns(10);
		
		insName = new JTextField();
		insName.setColumns(10);
		insName.setBounds(118, 116, 127, 22);
		frame.getContentPane().add(insName);
		
		JLabel lblViewAndUpdate = new JLabel("View and update");
		lblViewAndUpdate.setBounds(264, 48, 102, 16);
		frame.getContentPane().add(lblViewAndUpdate);
		
		JLabel label = new JLabel("Name:");
		label.setBounds(282, 119, 56, 16);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Id:");
		label_1.setBounds(282, 90, 56, 16);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Password:");
		label_2.setBounds(282, 148, 72, 16);
		frame.getContentPane().add(label_2);
		
		uName = new JTextField();
		uName.setColumns(10);
		uName.setBounds(363, 116, 127, 22);
		frame.getContentPane().add(uName);
		
		JLabel lblDelete = new JLabel("Delete");
		lblDelete.setBounds(520, 48, 56, 16);
		frame.getContentPane().add(lblDelete);
		
		JLabel lblId_1 = new JLabel("Id:");
		lblId_1.setBounds(537, 90, 56, 16);
		frame.getContentPane().add(lblId_1);
		
		JComboBox uCombo = new JComboBox();
		uCombo.setBounds(363, 87, 127, 22);
		frame.getContentPane().add(uCombo);
		
		EmployeeGateway eCombo1 = new EmployeeGateway(uCombo);
		eCombo1.fillCombo();
		
		JComboBox deleteCombo = new JComboBox();
		deleteCombo.setBounds(579, 87, 127, 22);
		frame.getContentPane().add(deleteCombo);
		
		EmployeeGateway eCombo2 = new EmployeeGateway(deleteCombo);
		eCombo2.fillCombo();
		
		insPass = new JPasswordField();
		insPass.setBounds(118, 145, 127, 22);
		frame.getContentPane().add(insPass);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int iID = Integer.parseInt(insID.getText());
				String iName = insName.getText();
				String iPass = insPass.getText();
				EmployeeBusinessLogic employeeBusinessLogic = new EmployeeBusinessLogic();
				employeeBusinessLogic.insertEmp(iName, iPass);
				
				uCombo.removeAllItems();
				eCombo1.fillCombo();
				
				deleteCombo.removeAllItems();
				eCombo2.fillCombo();
				
				insID.setText("");
				insName.setText("");
				insPass.setText("");
			}
		});
		btnInsert.setBounds(76, 196, 97, 25);
		frame.getContentPane().add(btnInsert);
		
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int viewID = Integer.parseInt(uCombo.getSelectedItem().toString());
				EmployeeBusinessLogic employeeBusinessLogic = new EmployeeBusinessLogic();
				employeeBusinessLogic.fillFields(uName, uPass, viewID);
				
			}
		});
		btnView.setBounds(282, 196, 97, 25);
		frame.getContentPane().add(btnView);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int iID = Integer.parseInt(uCombo.getSelectedItem().toString());
				String nameU = uName.getText();
				String passU = uPass.getText();
				
				EmployeeBusinessLogic employeeBusinessLogic = new EmployeeBusinessLogic();
				employeeBusinessLogic.updateEmp(nameU, passU, iID);
				
				uName.setText("");
				uPass.setText("");
				
			}
		});
		btnUpdate.setBounds(403, 196, 97, 25);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int del = Integer.parseInt(deleteCombo.getSelectedItem().toString());
				EmployeeBusinessLogic employeeBusinessLogic = new EmployeeBusinessLogic();
				employeeBusinessLogic.deleteEmp(del);
				uCombo.removeAllItems();
				eCombo1.fillCombo();
				
				deleteCombo.removeAllItems();
				eCombo2.fillCombo();
				
			}
		});
		btnDelete.setBounds(579, 196, 97, 25);
		frame.getContentPane().add(btnDelete);
		
		uPass = new JPasswordField();
		uPass.setBounds(363, 145, 127, 22);
		frame.getContentPane().add(uPass);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnBack.setBounds(282, 282, 97, 25);
		frame.getContentPane().add(btnBack);
		
		
	}
}

