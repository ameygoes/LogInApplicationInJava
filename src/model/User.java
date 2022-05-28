package model;

public class User {
    Long id;
    String name;
    String username;
    String password;
    String mobilenumber;
    String email;
    String address;
    Role role;

    public User() {
    }

    public User(Long id, String name, String username, String password, String mobilenumber, String email, String address, Role role) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.mobilenumber = mobilenumber;
        this.email = email;
        this.address = address;
        this.role = role;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

	@Override
	public String toString() {
		return String.format("%-20d %-20s %-20s %-20s %-20s %-20s %-20s",  id , name, username, mobilenumber, email, address, role.getName());
	}
    
    
}
