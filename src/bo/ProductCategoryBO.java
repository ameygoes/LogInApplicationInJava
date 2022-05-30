package bo;

import dao.ProductCategoryDAO;
import model.ProductCategory;

import java.sql.SQLException;
import java.util.List;

public class ProductCategoryBO {
    public Boolean addProductCategory(ProductCategory productCategory) throws ClassNotFoundException, SQLException {

        // CREATE PRODUCT TYPE DAO OBJECT TO CALL FUNCTION WHICH GETS PRODUCT TYPE ADDED TO DB
        ProductCategoryDAO ProductCategoryDAO = new ProductCategoryDAO();

        // CALL TO THE FUNCTION
        return ProductCategoryDAO.addProductCategory(productCategory);

    }
    public List<ProductCategory> obtainAllProductCategory() throws ClassNotFoundException, SQLException{
        // CREATE PRODUCT TYPE DAO OBJECT TO CALL FUNCTION WHICH GETS PRODUCT TYPE LIST
        ProductCategoryDAO ProductCategoryDAO = new ProductCategoryDAO();

        return ProductCategoryDAO.obtainAllProductCategory();
    }
    
    public ProductCategory obtainProductCategoryById(Long id) throws ClassNotFoundException, SQLException{
        // CREATE PRODUCT TYPE DAO OBJECT TO CALL FUNCTION WHICH GETS PRODUCT TYPE ADDED TO DB
        ProductCategoryDAO ProductCategoryDAO = new ProductCategoryDAO();

        return ProductCategoryDAO.obtainProductCategoryById(id);
    }
    
    public void displayProductCategory() throws ClassNotFoundException, SQLException{
        // GET ALL PRODUCT TYPES FROM DB
        List<ProductCategory> ProductCategoryList = obtainAllProductCategory();

        System.out.format("%-5s %-30s %-15s\n","Id","Name","Description");
        for (ProductCategory ProductCategoryObject: ProductCategoryList) {
            System.out.format("%-5s %-30s %-15s\n",ProductCategoryObject.getId(),ProductCategoryObject.getName(),ProductCategoryObject.getDescription());
        }
    }
}
