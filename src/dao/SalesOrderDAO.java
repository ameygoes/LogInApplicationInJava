package dao;

import model.SalesOrder;
import utility.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalesOrderDAO {
	public Boolean addSalesOrder(SalesOrder salesOrder) throws ClassNotFoundException, SQLException {
        Connection con = DBConnection.getConnection();
        //Fill your code here
        return false;
    }
	public List<SalesOrder> obtainAllSalesOrder()throws ClassNotFoundException, SQLException{
		List<SalesOrder> itemList=new ArrayList<SalesOrder>();
		//Fill your code here
		return itemList;
	}
}
