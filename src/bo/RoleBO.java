package bo;

import dao.RoleDAO;
import model.Role;
import java.sql.SQLException;
import java.util.List;

public class RoleBO {
    public Role obtainRoleById(Integer roleId) throws ClassNotFoundException, SQLException{
		RoleDAO roleDAO = new RoleDAO();
		Role role = roleDAO.obtainRoleById(roleId);
		return role;
    }
    public List<Role> listAllRoles() throws ClassNotFoundException, SQLException {
		return new RoleDAO().listAllRoles();
	}

	public Role getRoleByName(String roleName) throws ClassNotFoundException, SQLException {
		return new RoleDAO().getRoleByName(roleName);
	}
}
