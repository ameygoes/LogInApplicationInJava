
package dao;

import model.Product;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utility.DBConnection;

public class ProductDAO {
    public Boolean addProduct(Product product) throws ClassNotFoundException, SQLException {
        Connection con = DBConnection.getConnection();
        //Fill your code here
        return false;
    }
    public List<Product> obtainAllProducts() throws ClassNotFoundException, SQLException{
        List<Product> productList = new ArrayList<Product>();
        Connection con = DBConnection.getConnection();
        //Fill your code here
        return productList;
    }
	
    public Product obtainProductById(Long id) throws ClassNotFoundException, SQLException {
    	Connection con = DBConnection.getConnection();
        //Fill your code here
        return null;
    }

	public Boolean updateProduct(Product product) throws ClassNotFoundException, SQLException {
		Connection con = DBConnection.getConnection();
		//Fill your code here
		return false;
	}
    public Product obtainProductByName(String name) throws ClassNotFoundException, SQLException {
    	Connection con = DBConnection.getConnection();
        //Fill your code here
        return null;
    }
}
