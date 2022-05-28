package model;

public class PurchaseOrderItem {
	private Long id;
	private Product product;
	private Integer quantity;
	private Double unitPrice;
	private PurchaseOrder purchaseOrder;
	
	public PurchaseOrderItem() {
		super();
	}
	public PurchaseOrderItem(Long id, Product product, Integer quantity, Double unitPrice,
			PurchaseOrder purchaseOrder) {
		super();
		this.id = id;
		this.product = product;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.purchaseOrder = purchaseOrder;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}
	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	@Override
	public String toString() {
		return String.format("%-20d %-20s %-20d %-20.2f", id, product.getName(), quantity, unitPrice);
	}
}
