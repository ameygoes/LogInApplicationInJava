package dao;

import model.ProductType;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utility.DBConnection;

public class ProductTypeDAO {
    public Boolean addProductType(ProductType productType) throws ClassNotFoundException, SQLException {
        Connection con = DBConnection.getConnection();
        //Fill your code here
        return false;
    }
    public List<ProductType> obtainAllProductType() throws ClassNotFoundException, SQLException{
        List<ProductType> productTypeList = new ArrayList<ProductType>();
        Connection con = DBConnection.getConnection();
        //Fill your code here
        con.close();
        return productTypeList;
    }
    
    public ProductType obtainProductTypeById(Long id) throws ClassNotFoundException, SQLException{
        ProductType productType = null;
        Connection connection = DBConnection.getConnection();
        //Fill your code here
        connection.close();
        return productType;
    }
}
