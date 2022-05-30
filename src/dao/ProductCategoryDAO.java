package dao;

import model.ProductCategory;
import utility.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static Constants.Constants.*;
import static utility.GetPreparedStatement.GetPreparedStatement;

public class ProductCategoryDAO {
    public Boolean addProductCategory(ProductCategory productCategory) throws ClassNotFoundException, SQLException {
        if(!checkIfProductCategoryPresent(productCategory.getName())) {

            Connection connection = DBConnection.getConnection();

            // GET PREPARED STATEMENT TO INSERT A BRAND IN DB
            PreparedStatement productCategoryPreparedStatement = GetPreparedStatement(connection, PRODUCT_CATEGORY_INSERT_BRANDE_DETAILS_SQL);

            // REPLACE THE ACTUAL VALUE FOR BRAND NAME IN PLACE OF ?
            productCategoryPreparedStatement.setString(1, productCategory.getName());
            productCategoryPreparedStatement.setString(2,productCategory.getDescription());

            // GET THE RESULT OF BRAND INSERTION OPERATION
            // RESULT IS GREATER THAN 1 IF SUCCESS OTHERWISE 0
            int resultOfInsertStatement = productCategoryPreparedStatement.executeUpdate();

            // CLOSE CONNECTION TO DB
            connection.close();

            // RETURN THE RESULT
            if (resultOfInsertStatement > 0) {
                return true;
            }
        }

        return false;
    }
    public ProductCategory obtainProductCategoryById(Long productCategoryId) throws ClassNotFoundException, SQLException{
        ProductCategory productCategoryObject = null;
        Connection connection = DBConnection.getConnection();


        // GET PREPARED STATEMENT TO CHECK IF A BRAND IS IN DB OR NOT
        PreparedStatement productCategoryPreparedStatement = GetPreparedStatement(connection, PRODUCT_CATEGORY_GET_BRANDS_FROM_DB_USING_ID_SQL);

        // REPLACE THE ACTUAL VALUE FOR BRAND NAME IN PLACE OF ?
        productCategoryPreparedStatement.setLong(1,productCategoryId);

        // GET THE RESULT OF BRAND INSPECTION OPERATION
        // IF RESULT IS GREATER THAN 1 THE BRAND ALREADY EXISTS
        ResultSet resultSet = productCategoryPreparedStatement.executeQuery();

        // RETURN THE RESULT
        while (resultSet.next()){
            productCategoryObject.setId(resultSet.getLong("id"));
            productCategoryObject.setName(resultSet.getString("name"));
            productCategoryObject.setDescription(resultSet.getString("description"));
        }

        // CLOSE CONNECTION TO DB
        connection.close();
        return productCategoryObject;
    }
    
    public List<ProductCategory> obtainAllProductCategory() throws ClassNotFoundException, SQLException{
        List<ProductCategory> productCategoryList = new ArrayList<ProductCategory>();
        Connection connection = DBConnection.getConnection();


        // GET PREPARED STATEMENT TO CHECK IF A BRAND IS IN DB OR NOT
        PreparedStatement productCategoryPreparedStatement = GetPreparedStatement(connection, PRODUCT_CATEGORY_GET_ALL_BRANDS_SQL);

        // GET THE RESULT OF BRAND INSPECTION OPERATION
        // IF RESULT IS GREATER THAN 1 THE BRAND ALREADY EXISTS
        ResultSet resultSet = productCategoryPreparedStatement.executeQuery();


        // RETURN THE RESULT
        while (resultSet.next()){
            ProductCategory productCategoryObject = new ProductCategory();
            productCategoryObject.setId(resultSet.getLong("id"));
            productCategoryObject.setName(resultSet.getString("name"));
            productCategoryObject.setDescription(resultSet.getString("description"));
            productCategoryList.add(productCategoryObject);
        }

        connection.close();
        return productCategoryList;
    }

    public Boolean checkIfProductCategoryPresent(String productCategoryName) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getConnection();

        // GET PREPARED STATEMENT TO CHECK IF A BRAND IS IN DB OR NOT
        PreparedStatement productCategoryPreparedStatement = GetPreparedStatement(connection, PRODUCT_CATEGORY_GET_BRANDS_FROM_DB_USING_PRODUCT_CATEGORY_NAME_SQL);

        // REPLACE THE ACTUAL VALUE FOR BRAND NAME IN PLACE OF ?
        productCategoryPreparedStatement.setString(1,productCategoryName);

        // GET THE RESULT OF BRAND INSPECTION OPERATION
        // IF RESULT IS GREATER THAN 1 THE BRAND ALREADY EXISTS
        ResultSet resultSet = productCategoryPreparedStatement.executeQuery();

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
