package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.PurchaseOrderItem;
import utility.DBConnection;

public class PurchaseOrderItemDAO {
	public PurchaseOrderItem obtainPurchaseOrderItemById(Long id) throws ClassNotFoundException, SQLException {
		PurchaseOrderItem s = null;
        Connection con = DBConnection.getConnection();
        //Fill your code here
        return s;
    }
    public List<PurchaseOrderItem> obtainAllPurchaseOrderItems() throws ClassNotFoundException, SQLException{
        List<PurchaseOrderItem> purchaseOrderItemList = new ArrayList<PurchaseOrderItem>();
        Connection con = DBConnection.getConnection();
        //Fill your code here
        con.close();
        return purchaseOrderItemList;
    }
}
