package presentation;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import businessLogic.EmployeeBusinessLogic;
import dataAccesser.ClientGateway;
import dataAccesser.EmployeeGateway;


public class Login {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private AdminFrame admin;
	private Decision dec;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
	
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(50, 63, 81, 41);
		frame.getContentPane().add(lblName);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(50, 127, 81, 50);
		frame.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(137, 72, 177, 32);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(137, 136, 177, 32);
		frame.getContentPane().add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				EmployeeBusinessLogic emLogic = new EmployeeBusinessLogic();
				
				
				String name = textField.getText();
				String pass = passwordField.getText();
				
				if (name.equals("admin") && (pass.equals("admin"))){
					admin = new AdminFrame();
					admin.frame.setVisible(true);
				}
				else if (emLogic.match(name,pass)){
					 dec = new Decision();
					 dec.frame.setVisible(true);
				}
				else System.out.println("Completati toate campurile !");
			
			}
		});
		btnLogin.setBounds(150, 203, 97, 25);
		frame.getContentPane().add(btnLogin);
		
	}
}
