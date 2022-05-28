package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Supplier;
import utility.DBConnection;

public class SupplierDAO {

	public List<Supplier> obtainAllSuppliers() throws ClassNotFoundException, SQLException {
		List<Supplier> sList =new ArrayList<Supplier>();
		Connection con = DBConnection.getConnection();
       //Fill your code here
        con.close();
        return sList;
	}

	public Supplier obtainSupplierById(Long supplierId) throws ClassNotFoundException, SQLException {
		Connection con = DBConnection.getConnection();
        //Fill your code here
        con.close();
        return null;
	}
}
