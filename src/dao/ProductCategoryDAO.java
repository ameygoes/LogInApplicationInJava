package dao;

import model.ProductCategory;
import utility.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductCategoryDAO {
    public Boolean addProductCategory(ProductCategory productCategory) throws ClassNotFoundException, SQLException {
        Connection con = DBConnection.getConnection();
        //Fill your code here

        return false;
    }
    public ProductCategory obtainProductCategoryById(Long id) throws ClassNotFoundException, SQLException{
        ProductCategory productCategory = null;
        Connection connection = DBConnection.getConnection();
        //Fill your code here
        connection.close();
        return productCategory;
    }
    
    public List<ProductCategory> obtainAllProductCategory() throws ClassNotFoundException, SQLException{
        List<ProductCategory> productCategoryList = new ArrayList<ProductCategory>();
        Connection con = DBConnection.getConnection();
        //Fill your code here
        con.close();
        return productCategoryList;
    }
}
