package model;

public class ProductCategory {
    Long id;
    String name;
    String description;

    public ProductCategory() {
    }
    
    public ProductCategory(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public Boolean equals(ProductCategory productCategory) {
		if(productCategory.getName().equals(this.name) ) {
			return true;
		}
		return false;
	}
    
    
    
}
