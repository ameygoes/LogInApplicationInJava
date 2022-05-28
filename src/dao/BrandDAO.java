package dao;

import model.Brand;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utility.DBConnection;

public class BrandDAO {
    public Boolean addBrand(Brand brand) throws ClassNotFoundException, SQLException {
        Connection con = DBConnection.getConnection();
        //Fill your code here
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
}
