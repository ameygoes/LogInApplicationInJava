package bo;

import dao.ProductTypeDAO;
import model.ProductType;

import java.sql.SQLException;
import java.util.List;

public class ProductTypeBO {
    public Boolean addProductType(ProductType productType) throws ClassNotFoundException, SQLException {

        // CREATE PRODUCT TYPE DAO OBJECT TO CALL FUNCTION WHICH GETS PRODUCT TYPE ADDED TO DB
        ProductTypeDAO productTypeDAO = new ProductTypeDAO();

        // CALL TO THE FUNCTION
        return productTypeDAO.addProductType(productType);
    }
    public List<ProductType> obtainAllProductType() throws ClassNotFoundException, SQLException{

        // CREATE PRODUCT TYPE DAO OBJECT TO CALL FUNCTION WHICH GETS PRODUCT TYPE LIST
        ProductTypeDAO productTypeDAO = new ProductTypeDAO();

        return productTypeDAO.obtainAllProductType();
	}
	
    public ProductType obtainProductTypeById(Long id) throws ClassNotFoundException, SQLException {

        // CREATE PRODUCT TYPE DAO OBJECT TO CALL FUNCTION WHICH GETS PRODUCT TYPE ADDED TO DB
        ProductTypeDAO productTypeDAO = new ProductTypeDAO();

        return productTypeDAO.obtainProductTypeById(id);
    }
	
    public void displayProductType() throws ClassNotFoundException, SQLException {

        // GET ALL PRODUCT TYPES FROM DB
        List<ProductType> productTypeList = obtainAllProductType();

        System.out.format("%-5s %-30s %-15s\n","Id","Name","Description");
        for (ProductType productTypeObject: productTypeList) {
            System.out.format("%-5s %-30s %-15s\n",productTypeObject.getId(),productTypeObject.getName(),productTypeObject.getDescription());
        }
    }
}
