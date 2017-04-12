package presentation;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import businessLogic.ClientBusinessLogic;

public class EmployeeFrame {

	JFrame frame;
	private JTextField iName;
	private JTextField iID;
	private JTextField iCnp;
	private JTextField iAdress;
	private JPasswordField iPass;
	private JTextField insIDCT;
	private JTextField uIDCT;
	private JTextField uID;
	private JTextField uCnp;
	private JTextField uAdress;
	private JPasswordField uPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeFrame window = new EmployeeFrame();
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
	public EmployeeFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// ClientGateway c = new ClientGateway();
		frame = new JFrame();
		frame.setBounds(100, 100, 722, 511);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblClient = new JLabel("Client");
		lblClient.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblClient.setBounds(12, 13, 95, 41);
		frame.getContentPane().add(lblClient);

		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(50, 134, 57, 28);
		frame.getContentPane().add(lblName);

		JLabel lblNewLabel = new JLabel("Insert new client");
		lblNewLabel.setBounds(22, 52, 95, 41);
		frame.getContentPane().add(lblNewLabel);

		iName = new JTextField();
		iName.setBounds(119, 132, 184, 28);
		frame.getContentPane().add(iName);
		iName.setColumns(10);

		JLabel lblIdCard = new JLabel("Id Card:");
		lblIdCard.setBounds(49, 175, 57, 28);
		frame.getContentPane().add(lblIdCard);

		JLabel lblCnp = new JLabel("CNP:");
		lblCnp.setBounds(49, 216, 57, 28);
		frame.getContentPane().add(lblCnp);

		JLabel lblNewLabel_1 = new JLabel("Adress:");
		lblNewLabel_1.setBounds(50, 257, 76, 34);
		frame.getContentPane().add(lblNewLabel_1);

		iID = new JTextField();
		iID.setColumns(10);
		iID.setBounds(119, 175, 184, 28);
		frame.getContentPane().add(iID);

		iCnp = new JTextField();
		iCnp.setColumns(10);
		iCnp.setBounds(119, 216, 184, 28);
		frame.getContentPane().add(iCnp);

		iAdress = new JTextField();
		iAdress.setColumns(10);
		iAdress.setBounds(119, 263, 184, 28);
		frame.getContentPane().add(iAdress);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(50, 297, 66, 41);
		frame.getContentPane().add(lblPassword);

		iPass = new JPasswordField();
		iPass.setBounds(119, 301, 184, 28);
		frame.getContentPane().add(iPass);
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(440, 132, 181, 28);
		frame.getContentPane().add(comboBox);
		ClientBusinessLogic clientBusinessLogic = new ClientBusinessLogic(comboBox);
		clientBusinessLogic.fillCombo();
		//ClientGateway combo1 = new ClientGateway(comboBox);
		//combo1.fillCombo();

		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int insIDC = Integer.parseInt(insIDCT.getText());
					String insName = iName.getText();
					String insID = iID.getText();
					String insCnp = iCnp.getText();
					String insAdress = iAdress.getText();
					String insPass = iPass.getText();

					clientBusinessLogic.insertClient(insName, insID, insCnp, insAdress, insPass);

					insIDCT.setText("");
					iName.setText("");
					iID.setText("");
					iCnp.setText("");
					iAdress.setText("");
					iPass.setText("");
					comboBox.removeAllItems();
					//combo1.fillCombo();
					clientBusinessLogic.fillCombo();
				} catch (NumberFormatException e) {
					System.out.println("Completati toate field-urile");
				}

			}
		});
		btnInsert.setBounds(108, 351, 97, 25);
		frame.getContentPane().add(btnInsert);

		insIDCT = new JTextField();
		insIDCT.setColumns(10);
		insIDCT.setBounds(119, 85, 184, 28);
		frame.getContentPane().add(insIDCT);

		JLabel lblId = new JLabel("Id:");
		lblId.setBounds(50, 85, 57, 36);
		frame.getContentPane().add(lblId);

		JLabel lblUpdateClient = new JLabel("View and Update");
		lblUpdateClient.setBounds(335, 43, 200, 50);
		frame.getContentPane().add(lblUpdateClient);

		JLabel label = new JLabel("Id:");
		label.setBounds(371, 85, 57, 36);
		frame.getContentPane().add(label);

		uIDCT = new JTextField();
		uIDCT.setColumns(10);
		uIDCT.setBounds(440, 85, 184, 28);
		frame.getContentPane().add(uIDCT);

		JLabel label_1 = new JLabel("Name:");
		label_1.setBounds(371, 134, 57, 28);
		frame.getContentPane().add(label_1);

		JLabel label_2 = new JLabel("Id Card:");
		label_2.setBounds(370, 175, 57, 28);
		frame.getContentPane().add(label_2);

		uID = new JTextField();
		uID.setColumns(10);
		uID.setBounds(440, 175, 184, 28);
		frame.getContentPane().add(uID);

		JLabel label_3 = new JLabel("CNP:");
		label_3.setBounds(370, 216, 57, 28);
		frame.getContentPane().add(label_3);

		uCnp = new JTextField();
		uCnp.setColumns(10);
		uCnp.setBounds(440, 216, 184, 28);
		frame.getContentPane().add(uCnp);

		JLabel label_4 = new JLabel("Adress:");
		label_4.setBounds(371, 257, 76, 34);
		frame.getContentPane().add(label_4);

		uAdress = new JTextField();
		uAdress.setColumns(10);
		uAdress.setBounds(440, 263, 184, 28);
		frame.getContentPane().add(uAdress);

		JLabel label_5 = new JLabel("Password:");
		label_5.setBounds(371, 297, 66, 41);
		frame.getContentPane().add(label_5);

		uPass = new JPasswordField();
		uPass.setBounds(440, 301, 184, 28);
		frame.getContentPane().add(uPass);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					String insName = comboBox.getSelectedItem().toString();

					int insIDC = Integer.parseInt(uIDCT.getText());

					String insID = uID.getText();
					String insCnp = uCnp.getText();
					String insAdress = uAdress.getText();
					String insPass = uPass.getText();

					clientBusinessLogic.updateClient(insIDC, insName, insID, insCnp, insAdress, insPass);
					uIDCT.setText("");
					uID.setText("");
					uCnp.setText("");
					uAdress.setText("");
					uPass.setText("");
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					// e.printStackTrace();
					System.out.println("Completati toate field-urile");
				}

			}
		});
		btnUpdate.setBounds(527, 351, 97, 25);
		frame.getContentPane().add(btnUpdate);

		JButton btnLoad = new JButton("View");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String insName = comboBox.getSelectedItem().toString();
				clientBusinessLogic.fillFields(uIDCT, uID, uCnp, uAdress, uPass, insName);
			}
		});
		btnLoad.setBounds(395, 351, 97, 25);
		frame.getContentPane().add(btnLoad);

		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 16));
		button.setBounds(270, 412, 97, 25);
		frame.getContentPane().add(button);
	}
}
