package bo;

import dao.BrandDAO;
import model.Brand;

import java.sql.SQLException;
import java.util.List;

public class BrandBO {
    public Boolean addBrand(Brand brand) throws ClassNotFoundException, SQLException {

        // CREATE BRAND DAO OBJECT TO CALL FUNCTION WHICH GETS BRAND ADDED TO DB
        BrandDAO brandDAO = new BrandDAO();

        // CALL TO THE FUNCTION
        return brandDAO.addBrand(brand);

    }
    public List<Brand> obtainAllBrand() throws ClassNotFoundException, SQLException{
        //Fill your code here
        return null;//To keep template code without errors we have given this dummy return stmt. Change it as per the problem spec
    }

    public Brand obtainBrandById(Long id) throws ClassNotFoundException, SQLException {
        //Fill your code here
        return null;//To keep template code without errors we have given this dummy return stmt. Change it as per the problem spec
    }

    public void displayBrand() throws ClassNotFoundException, SQLException {
    	//Fill your code here
    }
}
