import bo.*;
import model.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to Amey E-Mart!");
        int choice = 0;
        UserBO userBO=new UserBO();
        RoleBO roleBO = new RoleBO();
        ProductBO pbo=new ProductBO();
        do {
            System.out.println("Choose from the below Menu! \n1.Login\n2.Exit\n");
            choice = Integer.parseInt(br.readLine());
            switch(choice) {
                case 1:
                    System.out.println("Enter Username");
                    String username = br.readLine();
                    System.out.println("Enter Password");
                    String password = br.readLine();
                    User user = userBO.validateLogin(username,password);
                    if(user == null){
                        System.out.println("Invalid username or password");
                    }
                    else if(user.getRole().getName().equalsIgnoreCase("Store Manager")||user.getRole().getName().equalsIgnoreCase("Product Lead") ||user.getRole().getName().equalsIgnoreCase("Sales Lead")){
                        System.out.println("Hey, "+ user.getName()+ " please choose appropriate Menu options");
                        int ch = 0;
                        do{
                            System.out.println("Menu\n1.Add Product Type\n2.Add Product Category\n3.Add Brand\n4.Add Product\n5.Edit Product\n6.Display Products\n7.Search Product\n8.Create Sales Order\n9.Display Sales Order\n10.Create Purchase Order\n11.Logout");
                            ch=Integer.parseInt(br.readLine());
                            switch(ch){
                                case 1:
                                    ProductType productType = new ProductType();
                                    System.out.println("Enter Name:");
                                    productType.setName(br.readLine());
                                    System.out.println("Enter Description:");
                                    productType.setDescription(br.readLine());
                                    Boolean i = new ProductTypeBO().addProductType(productType);
                                    if(i)
                                        System.out.println("Product Type Added Successfully");
                                    else
                                    	System.out.println("Product type already exists.");
                                    break;
                                case 2:
                                    ProductCategory productCategory=new ProductCategory();
                                    System.out.println("Enter Name:");
                                    productCategory.setName(br.readLine());
                                    System.out.println("Enter Description:");
                                    productCategory.setDescription(br.readLine());
                                    i = new ProductCategoryBO().addProductCategory(productCategory);
                                    if(i)
                                    	System.out.println("Product Category Added Successfully");
                                    else
                                    	System.out.println("Product category already exists.");
                                    break;
                                case 3:
                                    Brand brand=new Brand();
                                    System.out.println("Enter Name:");
                                    brand.setName(br.readLine());
                                    i = new BrandBO().addBrand(brand);
                                    if(i)
                                    	System.out.println("Brand Added Successfully");
                                    else
                                    	System.out.println("Brand already exists.");
                                    break;
                                case 4:
                                    Product product =new Product();
                                    System.out.println("Enter Product Name:");
                                    product.setName(br.readLine());
                                    System.out.println("Enter Product Color:");
                                    product.setColor(br.readLine());
                                    System.out.println("Enter Product Material:");
                                    product.setMaterial(br.readLine());
                                    System.out.println("Enter Product Price:");
                                    product.setPrice(Double.parseDouble(br.readLine()));
                                    System.out.println("Enter Product Quantity:");
                                    product.setQuantity(Integer.parseInt(br.readLine()));
                                    System.out.println("Choose (Id) Brand:");
                                    new BrandBO().displayBrand();
                                    long brandId = Long.parseLong(br.readLine());
                                    product.setBrand(new BrandBO().obtainBrandById(brandId));
                                    System.out.println("Choose (Id) from below product types:");
                                    new ProductTypeBO().displayProductType();
                                    long productTypeId = Long.parseLong(br.readLine());
                                    product.setProductType(new ProductTypeBO().obtainProductTypeById(productTypeId));
                                    System.out.println("Choose (Id) from below product category:");
                                    new ProductCategoryBO().displayProductCategory();
                                    long productCategoryId = Long.parseLong(br.readLine());
                                    product.setProductCategory(new ProductCategoryBO().obtainProductCategoryById(productCategoryId));
                                    product.setActive(true);
                                    Boolean prodadd = new ProductBO().addProduct(product);
                                    if(prodadd)
                                    	System.out.println("Product Added Successfully");
                                    else
                                    	System.out.println("Product with the entered specification already exists. Product could not be added.");
                                    break;
                                case 5:
                                	System.out.println("Enter Product Id:");
                                    product =(pbo.obtainProductById(Long.parseLong(br.readLine())));
                                    if(product!=null) {
                                    	System.out.println("Enter Product Details:");
                    	    			System.out.println("Enter Name:");
                    	    			product.setName(br.readLine());
                    	    			System.out.println("Enter Color:");
                    	    			product.setColor(br.readLine());
                    	    			System.out.println("Enter Material:");
                    	    			product.setMaterial(br.readLine());
                    	    			System.out.println("Enter price:");
                    	    			product.setPrice(Double.parseDouble(br.readLine()));
                    	    			System.out.println("Enter Quantity:");
                    	    			product.setQuantity(Integer.parseInt(br.readLine()));
                    	    			System.out.println("Is the product active?(yes/no)");
                    	    			String ans=br.readLine();
                    	    			if(ans.equalsIgnoreCase("yes"))
                    	    				product.setActive(true);
                    	    			else
                    	    				product.setActive(false);
                                    	if(pbo.updateProduct(product))
                                    		System.out.println("Product details updated successfully.");
                                    }
                                    else {
                                    	System.out.println("Product not found.");
                                    }
                                    break;
                                case 6:
                                	pbo.displayAllProducts();
                                	break;
                                case 7:
                                	System.out.println("Enter Product Name:");
                                    product =(pbo.obtainProductByName(br.readLine()));
                                    if(product!=null) {
                                    	pbo.displayProduct(product);
                                    }
                                    else {
                                    	System.out.println("Product not found.");
                                    }
                                    break;
                                case 8:
                                	System.out.println("Enter Quantity of order:");
                                    Integer quantity=Integer.parseInt(br.readLine());
                                    System.out.println("Available sales order items:");
                                	System.out.format("%-20s %-20s %-20s %-20s\n", "Id", "Product Name", "Quantity", "Unit Price");
                                	for(SalesOrderItem soi:(new SalesOrderItemBO().obtainAllSalesOrderItems())) {
                                		System.out.println(soi);
                                	}
                                	Double taxAmount=0.0;
                                    Double totalPrice=0.0;
                                    List<SalesOrderItem> sList=new ArrayList<SalesOrderItem>();
                                    String ans;
                            		do {
                            			System.out.println("Enter sales Order id:");
                            			Long soiId=Long.parseLong(br.readLine());
                            			SalesOrderItem soi=new SalesOrderItemBO().obtainSalesOrderItemById(soiId);
                            			if(soi!=null) {
                            				sList.add(soi);
                            				taxAmount+=0.18*quantity*soi.getQuantity()*soi.getUnitPrice();
                            				totalPrice+=taxAmount+quantity*soi.getQuantity()*soi.getUnitPrice();
                            			}
                            			else
                            				System.out.println("Invalid Sales Order Item Id.");
                            			System.out.println("Do you want to add another item details?(yes/no)");
                            			ans=br.readLine();
                            		}while(ans.equalsIgnoreCase("yes"));
                                    System.out.println("Available Customer Details:");
                                	System.out.format("%-20s %-20s %-20s %-20s %-20s %-20s\n",  "Id" , "Name", "Username", "Mobile Number", "Email-id", "Address");
                                	for(User u:(new UserBO().obtainUsersByRole("Customer"))) {
                                		System.out.println(u);
                                	}
                                    System.out.println("Choose customer id:");
                                    Long cid=Long.parseLong(br.readLine());
                                    User cust=(new UserBO().obtainUsersById(cid));
                                    if(cust==null) {
                                    	System.out.println("Invalid Customer id.");
                                    	break;
                                    }
                                    User salesLead=null;
                                    if(user.getRole().getName().equalsIgnoreCase("store manager")) {
                                    System.out.println("Available Sales lead Details:");
                                    System.out.format("%-20s %-20s %-20s %-20s %-20s %-20s\n",  "Id" , "Name", "Username", "Mobile Number", "Email-id", "Address");
                                	for(User u:(new UserBO().obtainUsersByRole("Sales Lead"))) {
                                		System.out.println(u);
                                	}
                                    System.out.println("Choose Sales lead id:");
                                    Long sid=Long.parseLong(br.readLine());
                                    salesLead=(new UserBO().obtainUsersById(sid));
                                    }
                                    else
                                    {
                                    	salesLead=user;
                                    }
                                    if(salesLead==null) {
                                    	System.out.println("Invalid Sales lead id.");
                                    	break;
                                    }
                                    System.out.println("Enter Sales Date(dd/MM/yyyy):");
                                    Date salesDate=new SimpleDateFormat("dd/MM/yyyy").parse(br.readLine());
                                   
                                    SalesOrder so=new SalesOrder(null, cust, quantity, totalPrice, taxAmount, salesLead, salesDate, sList);
                                    Boolean b=(new SalesOrderBO().addSalesOrder(so));
                                    if(b)
                                    System.out.println("Sales Order details added successfully.");
                                    break;
                                case 9:
                                	System.out.println("Sales Order Details:");
                                	new SalesOrderBO().displaySalesOrder();
                                    break;
                                case 10:
                                	System.out.println("Enter Quantity of order:");
                                    Integer pquantity=Integer.parseInt(br.readLine());
                                    System.out.println("Available Purchase order items:");
                                	System.out.format("%-20s %-20s %-20s %-20s\n", "Id", "Product Name", "Quantity", "Unit Price");
                                	for(PurchaseOrderItem poi:(new PurchaseOrderItemBO().obtainAllPurchaseOrderItems())) {
                                		System.out.println(poi);
                                	}
                                	Double ptaxAmount=0.0;
                                    Double ptotalPrice=0.0;
                                    List<PurchaseOrderItem> pList=new ArrayList<PurchaseOrderItem>();
                                    
                            		do {
                            			System.out.println("Enter Product Order id:");
                            			Long poiId=Long.parseLong(br.readLine());
                            			PurchaseOrderItem poi=new PurchaseOrderItemBO().obtainPurchaseOrderItemById(poiId);
                            			if(poi!=null) {
                            				pList.add(poi);
                            				ptaxAmount+=0.18*pquantity*poi.getQuantity()*poi.getUnitPrice();
                            				ptotalPrice+=ptaxAmount+pquantity*poi.getQuantity()*poi.getUnitPrice();
                            			}
                            			else
                            				System.out.println("Invalid Product Order Item Id.");
                            			System.out.println("Do you want to add another item details?(yes/no)");
                            			ans=br.readLine();
                            		}while(ans.equalsIgnoreCase("yes"));
                                    System.out.println("Available Supplier Details:");
                                	System.out.format("%-20s %-20s %-20s %-20s %-20s\n",  "Id" , "Name", "Mobile Number", "Email-id", "Address");
                                	for(Supplier s:(new SupplierBO().obtainAllSuppliers())) {
                                		System.out.println(s);
                                	}
                                    System.out.println("Choose Supplier id:");
                                    Long sid=Long.parseLong(br.readLine());
                                    Supplier supplier=(new SupplierBO().obtainSupplierById(sid));
                                    if(supplier==null) {
                                    	System.out.println("Invalid Supplier id.");
                                    	break;
                                    }
                                    System.out.println("Available Product lead Details:");
                                    System.out.format("%-20s %-20s %-20s %-20s %-20s %-20s %-20s\n",  "Id" , "Name", "Username", "Mobile Number", "Email-id", "Address","Role");
                                	for(User u:(new UserBO().obtainUsersByRole("Product Lead"))) {
                                		System.out.println(u);
                                	}
                                    System.out.println("Choose Product lead id:");
                                    Long productLeadid=Long.parseLong(br.readLine());
                                    User prodLead=(new UserBO().obtainUsersById(productLeadid));
                                    if(prodLead==null) {
                                    	System.out.println("Invalid Product lead id.");
                                    	break;
                                    }
                                    System.out.println("Enter Purchase Date(dd/MM/yyyy):");
                                    Date purchaseDate=new SimpleDateFormat("dd/MM/yyyy").parse(br.readLine());
                                    PurchaseOrder po=new PurchaseOrder(sid, supplier, pquantity, ptotalPrice, ptaxAmount, prodLead, purchaseDate, pList);
                                    b=(new PurchaseOrderBO().addPurchaseOrder(po));
                                    if(b)
                                    System.out.println("Purchase Order details added successfully.");
                                    break;                           
                                
                                
                                case 11:
                                    System.out.println("Successfully logged out!");
                                    break;
                                default:
                                    System.out.println("Invalid Choice");
                            }
                        }while(ch!=11);
                    }
                    else{
                        System.out.println("Hey, "+user.getName()+"Sorry. You don't have permission to access.");
                    }
                    break;
                case 2:
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        }while(choice != 2);
    }
}
