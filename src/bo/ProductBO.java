
package bo;

import model.Product;
import java.sql.SQLException;

public class ProductBO {
    public Boolean addProduct(Product product) throws ClassNotFoundException, SQLException {
    	//Fill your code here
        return false;//To keep template code without errors we have given this dummy return stmt. Change it as per the problem spec
    }
    public Product obtainProductById(Long id) throws ClassNotFoundException, SQLException {
		//Fill your code here
        return null;//To keep template code without errors we have given this dummy return stmt. Change it as per the problem spec
	}
	public Boolean updateProduct(Product product) throws ClassNotFoundException, SQLException {
		//Fill your code here
        return false;//To keep template code without errors we have given this dummy return stmt. Change it as per the problem spec
    }
    public void displayAllProducts() throws ClassNotFoundException, SQLException {
    	//Fill your code here
    }
	public Product obtainProductByName(String name) throws ClassNotFoundException, SQLException {
		//Fill your code here
        return null;//To keep template code without errors we have given this dummy return stmt. Change it as per the problem spec
	}
	public void displayProduct(Product product) throws ClassNotFoundException, SQLException {
    	System.out.println("Product Details:");
    	System.out.format("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s\n","Id", "Product Name","Brand","Color","Material","Price","Available Quantity","Product Type","Product Category");
		System.out.println(product);
    }
}
