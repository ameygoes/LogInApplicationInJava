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

        // CREATE BRAND DAO OBJECT TO CALL FUNCTION WHICH GETS BRAND ADDED TO DB
        BrandDAO brandDAO = new BrandDAO();

        // CALL TO THE FUNCTION
        return brandDAO.obtainAllBrand();
    }

    public Brand obtainBrandById(Long id) throws ClassNotFoundException, SQLException {

        // CREATE BRAND DAO OBJECT TO CALL FUNCTION WHICH GETS BRAND ADDED TO DB
        BrandDAO brandDAO = new BrandDAO();
        return brandDAO.obtainBrandById(id);
    }

    public void displayBrand() throws ClassNotFoundException, SQLException {
        List<Brand> brandList = obtainAllBrand();

        System.out.format("%-5s %-15s\n","Id","Name");
        for (Brand brandObject: brandList) {

            System.out.format("%-5s %-15s\n",brandObject.getId(),brandObject.getName());
        }
    }
}
