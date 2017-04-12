package businessLogic;

import javax.swing.JTextField;

import dataAccesser.EmployeeGateway;

public class EmployeeBusinessLogic {

	public void insertEmp(String name, String pass) {
		EmployeeGateway emp = new EmployeeGateway(name, pass);
		emp.insertEmp();
	}

	public void fillFields(JTextField nameE, JTextField passE, int idEm) {
		EmployeeGateway emp = new EmployeeGateway();
		emp.fillFields(nameE, passE, idEm);
	}

	public void updateEmp(String name, String pass, int id) {
		EmployeeGateway emp = new EmployeeGateway(name, pass);
		emp.updateEmp(id, name, pass);
	}

	public void deleteEmp(int idEm) {
		EmployeeGateway emp = new EmployeeGateway();
		emp.deleteEmp(idEm);
	}
	
	public boolean match(String name, String pass){
		EmployeeGateway emp = new EmployeeGateway();
		return emp.match(name, pass);
	}

}
