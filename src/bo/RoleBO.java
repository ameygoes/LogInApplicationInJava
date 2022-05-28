package bo;

import dao.RoleDAO;
import model.Role;
import java.sql.SQLException;
import java.util.List;

public class RoleBO {
    public Role obtainRoleById(Integer roleId) throws ClassNotFoundException, SQLException{
        //Fill your code here
        return null;//To keep template code without errors we have given this dummy return stmt. Change it as per the problem spec
    }
    public List<Role> listAllRoles() throws ClassNotFoundException, SQLException {
		return new RoleDAO().listAllRoles();
	}

	public Role getRoleByName(String roleName) throws ClassNotFoundException, SQLException {
		return new RoleDAO().getRoleByName(roleName);
	}
}
