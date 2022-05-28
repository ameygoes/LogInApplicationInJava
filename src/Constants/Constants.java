package Constants;

public class Constants {
     public static String USER_TABLE = "user";
     public static String ROLE_TABLE = "role";
     public static String PRODUCT_CATEGORY_TABLE = "product_category";
     public static String PRODUCT_TYPE_TABLE = "product_type";
     public static String PURCHASE_ORDER_TABLE = "purchase_order";
     public static String PRODUCT_TABLE = "product";
     public static String BRAND_TABLE = "brand";
     public static String PURCHASE_ORDER_ITEM_TABLE = "purchase_order_item";
     public static String SALES_ORDER_TABLE = "sales_order";
     public static String SALES_ORDER_ITEM_TABLE = "sales_order_item";
     public static String SUPPLIER_TABLE = "supplier";


     public static String USER_GET_USER_FROM_USERNAME_PASSWORD_SQL = "SELECT * FROM %s WHERE username = ? and password = ?;".formatted(USER_TABLE);
     public static String ROLE_GET_ROLE_NAME_FROM_ROLE_ID_SQL = "SELECT * FROM %s WHERE id = ?;".formatted(ROLE_TABLE);
}
