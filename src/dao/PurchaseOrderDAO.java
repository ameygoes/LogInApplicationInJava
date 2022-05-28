package dao;

import model.PurchaseOrder;
import utility.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class PurchaseOrderDAO {

	public Boolean addPurchaseOrder(PurchaseOrder purchaseOrder) throws ClassNotFoundException, SQLException {
		Connection con = DBConnection.getConnection();
        //Fill your code here
        con.close();
        return false;
	}
}
