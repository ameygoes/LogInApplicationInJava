package model;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class SalesOrder  {
	private Long id;
	private User customer;
	private Integer quantity;
	private Double totalPrice;
	private Double taxAmount;
	private User salesLead;
	private Date saleDate;
	private List<SalesOrderItem> itemList;
	public SalesOrder() {
		super();
	}
	public SalesOrder(Long id, User customer, Integer quantity, Double totalPrice, Double taxAmount, User salesLead,
			Date saleDate, List<SalesOrderItem> itemList) {
		super();
		this.id = id;
		this.customer = customer;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.taxAmount = taxAmount;
		this.salesLead = salesLead;
		this.saleDate = saleDate;
		this.itemList = itemList;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getCustomer() {
		return customer;
	}
	public void setCustomer(User customer) {
		this.customer = customer;
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
	public User getSalesLead() {
		return salesLead;
	}
	public void setSalesLead(User salesLead) {
		this.salesLead = salesLead;
	}
	public Date getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}
	public List<SalesOrderItem> getItemList() {
		return itemList;
	}
	public void setItemList(List<SalesOrderItem> itemList) {
		this.itemList = itemList;
	}
	
	@Override
	public String toString() {
		return String.format("%-20s %-20d %-20.2f %-20.2f %-20s %-20s",  customer.getName(), quantity, totalPrice, taxAmount, salesLead.getName(), new SimpleDateFormat("dd/MM/yyyy").format(saleDate));
	}
}
