package model;

public class Brand {
    Long id;
    String name;

    public Brand() {
    }

    
    public Brand(Long id, String name) {
        this.id = id;
        this.name = name;
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
    public Boolean equals(Brand brand) {
		if(brand.getName().equals(this.name)) {
			return true;
		}
		return false;
	}
}
