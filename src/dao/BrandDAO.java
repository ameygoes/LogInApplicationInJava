package dao;

import model.Brand;
import utility.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static Constants.Constants.BRAND_GET_BRANDS_FROM_DB_SQL;
import static Constants.Constants.BRAND_INSERT_BRANDE_DETAILS_SQL;
import static utility.GetPreparedStatement.GetPreparedStatement;

public class BrandDAO {

    // METHOD IS USED TO ADD A BRAND TO THE DATABASE
    public Boolean addBrand(Brand brand) throws ClassNotFoundException, SQLException {


        if(!checkIfBrandPresent(brand.getName())) {

            Connection connection = DBConnection.getConnection();

            // GET PREPARED STATEMENT TO INSERT A BRAND IN DB
            PreparedStatement brandsPreparedStatement = GetPreparedStatement(connection, BRAND_INSERT_BRANDE_DETAILS_SQL);

            // REPLACE THE ACTUAL VALUE FOR BRAND NAME IN PLACE OF ?
            brandsPreparedStatement.setString(1, brand.getName());

            // GET THE RESULT OF BRAND INSERTION OPERATION
            // RESULT IS GREATER THAN 1 IF SUCCESS OTHERWISE 0
            int resultOfInsertStatement = brandsPreparedStatement.executeUpdate();

            // CLOSE CONNECTION TO DB
            connection.close();

            // RETURN THE RESULT
            if (resultOfInsertStatement > 0) {
                return true;
            }
        }

        return false;
    }

    public List<Brand> obtainAllBrand() throws ClassNotFoundException, SQLException{
        List<Brand> brandList = new ArrayList<Brand>();
        Connection con = DBConnection.getConnection();
        //Fill your code here
        con.close();
        return brandList;
    }
	
    public Brand obtainBrandById(Long id) throws ClassNotFoundException, SQLException {
        Brand brand = null;
        Connection con = DBConnection.getConnection();
        //Fill your code here
        return brand;
    }

    public Boolean checkIfBrandPresent(String brandName) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getConnection();

        // GET PREPARED STATEMENT TO CHECK IF A BRAND IS IN DB OR NOT
        PreparedStatement brandsPreparedStatement = GetPreparedStatement(connection,BRAND_GET_BRANDS_FROM_DB_SQL);

        // REPLACE THE ACTUAL VALUE FOR BRAND NAME IN PLACE OF ?
        brandsPreparedStatement.setString(1,brandName);

        // GET THE RESULT OF BRAND INSPECTION OPERATION
        // IF RESULT IS GREATER THAN 1 THE BRAND ALREADY EXISTS
        ResultSet resultSet = brandsPreparedStatement.executeQuery();

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
