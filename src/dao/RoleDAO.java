package dao;

import model.Role;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import utility.DBConnection;

public class RoleDAO {
    public Role obtainRoleById(Integer roleId) throws ClassNotFoundException, SQLException{
        Role role = null;
        Connection connection = DBConnection.getConnection();
        //Fill your code here
        connection.close();
        return role;
    }
    public List<Role> listAllRoles() throws ClassNotFoundException, SQLException {
        Connection con = DBConnection.getConnection();
        Statement s = con.createStatement();
        
        List<Role> roleList= new ArrayList<Role>();

        ResultSet r = s.executeQuery("select * from role");
        while(r.next())
        {
            Long id=r.getLong("id");
            String name = r.getString("name");
            Role role=new Role(id, name);
            roleList.add(role);
        }
        return roleList;
    }

    public Role getRoleByName(String name) throws ClassNotFoundException, SQLException {
		Connection con = DBConnection.getConnection();
        Statement s = con.createStatement();

        ResultSet r = s.executeQuery("select * from role where name='"+name+"';");
        while(r.next())
        {
            Role role=new Role(r.getLong("id"),r.getString("name"));
            return role;
        }
    	return null;
	}
}
