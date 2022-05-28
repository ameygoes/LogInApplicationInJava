package model;

public class SalesOrderItem {
	private Long id;
	private Product product;
	private Integer quantity;
	private Double unitPrice;
	private SalesOrder salesOrder;
	public SalesOrderItem() {
		super();
	}
	
	public SalesOrderItem(Long id, Product product, Integer quantity, Double unitPrice, SalesOrder salesOrder) {
		super();
		this.id = id;
		this.product = product;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.salesOrder = salesOrder;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public SalesOrder getSalesOrder() {
		return salesOrder;
	}

	public void setSalesOrder(SalesOrder salesOrder) {
		this.salesOrder = salesOrder;
	}

	@Override
	public String toString() {
		return String.format("%-20d %-20s %-20d %-20.2f", id, product.getName(), quantity, unitPrice);
	}
	
}
