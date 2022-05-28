package bo;

import java.sql.SQLException;
import java.util.List;

import dao.PurchaseOrderItemDAO;
import model.PurchaseOrderItem;

public class PurchaseOrderItemBO {
	public PurchaseOrderItem obtainPurchaseOrderItemById(Long id) throws ClassNotFoundException, SQLException {
		return (new PurchaseOrderItemDAO().obtainPurchaseOrderItemById(id));
	}
        public List<PurchaseOrderItem> obtainAllPurchaseOrderItems() throws ClassNotFoundException, SQLException{
		return (new PurchaseOrderItemDAO().obtainAllPurchaseOrderItems());
	}
}
