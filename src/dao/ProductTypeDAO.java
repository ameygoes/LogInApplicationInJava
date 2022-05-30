package dao;

import model.ProductType;
import utility.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static Constants.Constants.*;
import static utility.GetPreparedStatement.GetPreparedStatement;

public class ProductTypeDAO {
    public Boolean addProductType(ProductType productType) throws ClassNotFoundException, SQLException {

        if(!checkIfProductTypePresent(productType.getName())) {

            Connection connection = DBConnection.getConnection();

            // GET PREPARED STATEMENT TO INSERT A BRAND IN DB
            PreparedStatement productTypePreparedStatement = GetPreparedStatement(connection, PRODUCT_TYPE_INSERT_BRANDE_DETAILS_SQL);

            // REPLACE THE ACTUAL VALUE FOR BRAND NAME IN PLACE OF ?
            productTypePreparedStatement.setString(1, productType.getName());
            productTypePreparedStatement.setString(2,productType.getDescription());

            // GET THE RESULT OF BRAND INSERTION OPERATION
            // RESULT IS GREATER THAN 1 IF SUCCESS OTHERWISE 0
            int resultOfInsertStatement = productTypePreparedStatement.executeUpdate();

            // CLOSE CONNECTION TO DB
            connection.close();

            // RETURN THE RESULT
            if (resultOfInsertStatement > 0) {
                return true;
            }
        }

        return false;
    }

    public List<ProductType> obtainAllProductType() throws ClassNotFoundException, SQLException{
        List<ProductType> productTypeList = new ArrayList<ProductType>();
        Connection connection = DBConnection.getConnection();


        // GET PREPARED STATEMENT TO CHECK IF A BRAND IS IN DB OR NOT
        PreparedStatement productTypePreparedStatement = GetPreparedStatement(connection, PRODUCT_TYPE_GET_ALL_BRANDS_SQL);

        // GET THE RESULT OF BRAND INSPECTION OPERATION
        // IF RESULT IS GREATER THAN 1 THE BRAND ALREADY EXISTS
        ResultSet resultSet = productTypePreparedStatement.executeQuery();


        // RETURN THE RESULT
        while (resultSet.next()){
            ProductType productTypeObject = new ProductType();
            productTypeObject.setId(resultSet.getLong("id"));
            productTypeObject.setName(resultSet.getString("name"));
            productTypeObject.setDescription(resultSet.getString("description"));
            productTypeList.add(productTypeObject);
        }

        connection.close();
        return productTypeList;
    }
    
    public ProductType obtainProductTypeById(Long productTypeId) throws ClassNotFoundException, SQLException{
        ProductType productTypeObject = null;
        Connection connection = DBConnection.getConnection();


        // GET PREPARED STATEMENT TO CHECK IF A BRAND IS IN DB OR NOT
        PreparedStatement productTypePreparedStatement = GetPreparedStatement(connection, PRODUCT_TYPE_GET_BRANDS_FROM_DB_USING_ID_SQL);

        // REPLACE THE ACTUAL VALUE FOR BRAND NAME IN PLACE OF ?
        productTypePreparedStatement.setLong(1,productTypeId);

        // GET THE RESULT OF BRAND INSPECTION OPERATION
        // IF RESULT IS GREATER THAN 1 THE BRAND ALREADY EXISTS
        ResultSet resultSet = productTypePreparedStatement.executeQuery();

        // RETURN THE RESULT
        while (resultSet.next()){
            productTypeObject.setId(resultSet.getLong("id"));
            productTypeObject.setName(resultSet.getString("name"));
            productTypeObject.setDescription(resultSet.getString("description"));
        }

        // CLOSE CONNECTION TO DB
        connection.close();
        return productTypeObject;
    }

    public Boolean checkIfProductTypePresent(String productTypeName) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getConnection();

        // GET PREPARED STATEMENT TO CHECK IF A BRAND IS IN DB OR NOT
        PreparedStatement productTypePreparedStatement = GetPreparedStatement(connection, PRODUCT_TYPE_GET_BRANDS_FROM_DB_USING_PRODUCT_TYPE_NAME_SQL);

        // REPLACE THE ACTUAL VALUE FOR BRAND NAME IN PLACE OF ?
        productTypePreparedStatement.setString(1,productTypeName);

        // GET THE RESULT OF BRAND INSPECTION OPERATION
        // IF RESULT IS GREATER THAN 1 THE BRAND ALREADY EXISTS
        ResultSet resultSet = productTypePreparedStatement.executeQuery();

        // RETURN THE RESULT
        if (resultSet.next()){

            // CLOSE CONNECTION TO DB
            connection.close();
            return true;
        }

        // CLOSE CONNECTION TO DB
        connection.close();
        return false;
    }
}
