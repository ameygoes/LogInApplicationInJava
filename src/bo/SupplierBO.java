package bo;

import java.sql.SQLException;
import java.util.List;

import model.Supplier;

public class SupplierBO {

	public List<Supplier> obtainAllSuppliers() throws ClassNotFoundException, SQLException {
		//Fill your code here
        return null;//To keep template code without errors we have given this dummy return stmt. Change it as per the problem spec
	}

	public Supplier obtainSupplierById(Long supplierId)throws ClassNotFoundException, SQLException {
		//Fill your code here
        return null;//To keep template code without errors we have given this dummy return stmt. Change it as per the problem spec
	}
	public void displaySuppliers() throws ClassNotFoundException, SQLException {
		List<Supplier> sList=obtainAllSuppliers();
		System.out.format("%-20s %-20s %-20s %-20s %-20s\n","Id" , "Name","Mobile Number","Email-id","Address");
        for(Supplier s:sList)
        {
            System.out.println(s);
        }
	}
}
