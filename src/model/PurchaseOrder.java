package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class PurchaseOrder {
	public Long id;
	public Supplier supplier;
	public Integer quantity;
	private Double totalPrice;
	private Double taxAmount;
	private User productLead;
	private Date purchasedDate;
	List<PurchaseOrderItem> itemList;
	public PurchaseOrder(Long id, Supplier supplier, Integer quantity, Double totalPrice, Double taxAmount, User productLead,
			Date purchasedDate, List<PurchaseOrderItem> itemList) {
		super();
		this.id = id;
		this.supplier = supplier;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.taxAmount = taxAmount;
		this.productLead = productLead;
		this.purchasedDate = purchasedDate;
		this.itemList = itemList;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Double getTaxAmount() {
		return taxAmount;
	}
	public void setTaxAmount(Double taxAmount) {
		this.taxAmount = taxAmount;
	}
	public User getProductLead() {
		return productLead;
	}
	public void setProductLead(User productLead) {
		this.productLead = productLead;
	}
	public Date getPurchasedDate() {
		return purchasedDate;
	}
	public void setPurchasedDate(Date purchasedDate) {
		this.purchasedDate = purchasedDate;
	}
	public List<PurchaseOrderItem> getItemList() {
		return itemList;
	}
	public void setItemList(List<PurchaseOrderItem> itemList) {
		this.itemList = itemList;
	}
	@Override
	public String toString() {
		return String.format("%-20d %-20.2f %-20.2f %-20s %-20s %-20s", quantity, totalPrice, taxAmount, productLead.getName(), new SimpleDateFormat("dd/MM/yyyy").format(purchasedDate), supplier.getName());
	}
	
}
