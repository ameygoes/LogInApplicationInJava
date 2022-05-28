package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.SalesOrderItem;
import utility.DBConnection;

public class SalesOrderItemDAO {
	public List<SalesOrderItem> obtainAllSalesOrderItems() throws ClassNotFoundException, SQLException{
        List<SalesOrderItem> salesOrderItemList = new ArrayList<SalesOrderItem>();
        Connection con = DBConnection.getConnection();
        //Fill your code here
        con.close();
        return salesOrderItemList;
    }
	
    public SalesOrderItem obtainSalesOrderItemById(Long id) throws ClassNotFoundException, SQLException {
    	SalesOrderItem s = null;
        Connection con = DBConnection.getConnection();
        //Fill your code here
        con.close();
        return s;
    }
}
