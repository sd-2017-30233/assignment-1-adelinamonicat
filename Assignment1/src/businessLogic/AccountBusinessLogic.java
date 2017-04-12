package businessLogic;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import dataAccesser.AccountGateway;

public class AccountBusinessLogic {
	
	public JComboBox comboBox;
	
	public AccountBusinessLogic(JComboBox comboBox) {
		this.comboBox= comboBox;
	}

	public void AccountBusinessLogicCombo3(){
		AccountGateway accountGateway= new AccountGateway(comboBox);
		accountGateway.fillCombo3();
	}
	
	public void AccountBusinessLogicCombo1(){
		AccountGateway accountGateway= new AccountGateway(comboBox);
		accountGateway.fillCombo3();
	} 

	public void AccountBusinessLogicCombo2(){
		AccountGateway accountGateway= new AccountGateway(comboBox);
		accountGateway.fillCombo3();
	}
	public void insertAccount(String operation, int idOp, String type, int amount, String date){
		AccountGateway accountGateway= new AccountGateway(1,type, amount, date);
		accountGateway.insertAccount(operation, 1);
	}
	public void fillFields(JTextField idAcc, JTextField type, JTextField amount, JTextField date, String idClient){
		AccountGateway accountGateway= new AccountGateway();
		accountGateway.fillFields(idAcc, type, amount, date, idClient);
	}
	public void updateAccount(String type, int amount, String date, int idCl){
		AccountGateway accountGateway= new AccountGateway();
		accountGateway.updateAccount(type, amount, date, idCl);
	}
	public void deleteAccount(int idAc){
		AccountGateway accountGateway= new AccountGateway();
		accountGateway.deleteAccount(idAc);
	}
}
