package dao;

import model.Role;
import utility.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static Constants.Constants.ROLE_GET_ROLE_NAME_FROM_ROLE_ID_SQL;
import static utility.GetPreparedStatement.GetPreparedStatement;

public class RoleDAO {
    public Role obtainRoleById(Integer roleId) throws ClassNotFoundException, SQLException{
        Role role = null;
        Connection connection = DBConnection.getConnection();

        PreparedStatement rolesPreparedStatement = GetPreparedStatement(connection,ROLE_GET_ROLE_NAME_FROM_ROLE_ID_SQL);

        // PREPARE A STATEMENT TO FETCH ROLE NAME USING ROLE_ID
        rolesPreparedStatement.setLong(1,roleId);

        // EXECUTE QUERY
        ResultSet rolesQueryResultSet = rolesPreparedStatement.executeQuery();

        // IF THE ROLE IS PRESENT CREATE A ROLE OBJECT
        if(rolesQueryResultSet.next()){
            role = new Role(rolesQueryResultSet.getLong("id"),(rolesQueryResultSet.getString("name")));
        }

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
