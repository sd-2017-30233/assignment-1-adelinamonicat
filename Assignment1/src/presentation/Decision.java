package presentation;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class Decision {
	private EmployeeFrame emp;
	private AccountFrame acc;
	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Decision window = new Decision();
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
	public Decision() {
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
		
		JLabel lblAcces = new JLabel("Access info about:");
		lblAcces.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAcces.setBounds(108, 65, 165, 31);
		frame.getContentPane().add(lblAcces);
		
		JButton btnCients = new JButton("Cients");
		btnCients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				emp = new EmployeeFrame();
				 emp.frame.setVisible(true);
			}
		});
		btnCients.setBounds(48, 139, 97, 25);
		frame.getContentPane().add(btnCients);
		
		JButton btnAccounts = new JButton("Accounts");
		btnAccounts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acc = new AccountFrame();
				acc.frame.setVisible(true);
			}
		});
		btnAccounts.setBounds(234, 139, 97, 25);
		frame.getContentPane().add(btnAccounts);
	}
}
