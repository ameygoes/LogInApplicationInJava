package bo;

import dao.PurchaseOrderDAO;
import model.PurchaseOrder;

import java.sql.SQLException;

public class PurchaseOrderBO {
	public Boolean addPurchaseOrder(PurchaseOrder purchaseOrder) throws ClassNotFoundException, SQLException {

		PurchaseOrderDAO purchaseOrderDAO = new PurchaseOrderDAO();
        return purchaseOrderDAO.addPurchaseOrder(purchaseOrder);
	}
}
