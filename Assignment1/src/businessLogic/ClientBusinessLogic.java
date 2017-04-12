package businessLogic;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import dataAccesser.ClientGateway;

public class ClientBusinessLogic {
public JComboBox comboBox;
	
	public ClientBusinessLogic(JComboBox comboBox) {
		this.comboBox= comboBox;
	}
	
	public void insertClient(String name, String id, String cnp, String address, String pass){
		ClientGateway clientGateway= new ClientGateway(name,id,cnp,address,pass);
		clientGateway.insertClient();
		
	}
	public void updateClient(int id,String name, String idCard, String cnp, String address, String pass){
		ClientGateway clientGateway= new ClientGateway(name,idCard,cnp,address,pass);
		clientGateway.updateClient(id, name, idCard, cnp, address, pass);
		
	}
	
	public void fillFields(JTextField idC, JTextField idCard, JTextField cnp, JTextField adress, JTextField pass,String name){
		ClientGateway clientGateway = new ClientGateway();
		clientGateway.fillFields(idC, idCard, cnp, adress, pass, name);
	}
	
	public void fillCombo(){
		ClientGateway clientGateway= new ClientGateway(comboBox);
		clientGateway.fillCombo();
	}
}
