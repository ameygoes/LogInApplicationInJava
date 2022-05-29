package Constants;

public class Constants {
     private static String USER_TABLE = "user";
     private static String ROLE_TABLE = "role";
     private static String PRODUCT_CATEGORY_TABLE = "product_category";
     private static String PRODUCT_TYPE_TABLE = "product_type";
     private static String PURCHASE_ORDER_TABLE = "purchase_order";
     private static String PRODUCT_TABLE = "product";
     private static String BRAND_TABLE = "brand";
     private static String PURCHASE_ORDER_ITEM_TABLE = "purchase_order_item";
     private static String SALES_ORDER_TABLE = "sales_order";
     private static String SALES_ORDER_ITEM_TABLE = "sales_order_item";
     private static String SUPPLIER_TABLE = "supplier";


     // COLUMN DETAILS OF DATABASE

     //BRAND TABLE
     private static String BRAND_COLUMN_NAMES = "name";
     // USER TABLE QUERIES
     public static String USER_GET_USER_FROM_USERNAME_PASSWORD_SQL = "SELECT * FROM %s WHERE username = ? and password = ?;".formatted(USER_TABLE);

     // ROLE TABLE QUERIES
     public static String ROLE_GET_ROLE_NAME_FROM_ROLE_ID_SQL = "SELECT * FROM %s WHERE id = ?;".formatted(ROLE_TABLE);

     // BRAND TABLE QUERIES
     public static String BRAND_INSERT_BRANDE_DETAILS_SQL = "INSERT INTO %s (%s) VALUES (?);".formatted(BRAND_TABLE,BRAND_COLUMN_NAMES);
     public static String BRAND_GET_BRANDS_FROM_DB_SQL = "SELECT * FROM %s WHERE name = ?;".formatted(BRAND_TABLE);



//
}
