import de.oszimt.lf10aContractMgmt.impl.HaseGmbHManagement;
import de.oszimt.lf10aContractMgmt.model.Contract;
import de.oszimt.lf10aContractMgmt.model.Customer;
import de.oszimt.lf10aContractMgmt.model.Employee;

public class HaseGmbHClientSimulation {

	public static void main(String[] args) {

		new HaseGmbHClientSimulation();
	}

	public HaseGmbHClientSimulation() {
		HaseGmbHManagement haseMgmtDriver = new HaseGmbHManagement();

		System.out.println(" list of the test-employees:");
		for (Employee e : haseMgmtDriver.getAllEmployees()) {
			System.out.println(e);
		}
		System.out.println("-------------------------------\n");
		System.out.println(" list of the test-customers:");
		for (Customer c : haseMgmtDriver.getAllCustomers()) {
			System.out.println(c);
		}
		System.out.println("-------------------------------\n");

		System.out.println(" list of the test-contracts:");
		for (Contract c : haseMgmtDriver.getAllContracts()) {
			System.out.println(c);
		}
	}
}
