
package dao;

import bo.RoleBO;
import model.Role;
import model.User;
import utility.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static Constants.Constants.*;
import static utility.GetPreparedStatement.GetPreparedStatement;


public class UserDAO {
    public User validateLogin(String username,String password) throws ClassNotFoundException, SQLException{
        User user =null;
        Role role =null;
        Connection connection = DBConnection.getConnection();

        //Fill your code here
        PreparedStatement userPreparedStatement = GetPreparedStatement(connection, USER_GET_USER_FROM_USERNAME_PASSWORD_SQL);

        userPreparedStatement.setString(1,username);
        userPreparedStatement.setString(2,password);

        ResultSet userQueryResultSet = userPreparedStatement.executeQuery();

        while(userQueryResultSet.next()) {

            PreparedStatement rolesPreparedStatement = GetPreparedStatement(connection,ROLE_GET_ROLE_NAME_FROM_ROLE_ID_SQL);

            rolesPreparedStatement.setLong(1,userQueryResultSet.getInt("role_id"));

            System.out.println(rolesPreparedStatement);
            ResultSet rolesQueryResultSet = rolesPreparedStatement.executeQuery();
            if(rolesQueryResultSet.next()){
                role = new Role(rolesQueryResultSet.getLong("id"),(rolesQueryResultSet.getString("name")));
            }

            user = new User(userQueryResultSet.getLong("id"),
                    userQueryResultSet.getString("name"),
                    userQueryResultSet.getString("username"),
                    userQueryResultSet.getString("password"),
                    userQueryResultSet.getString("mobile_number"),
                    userQueryResultSet.getString("email"),
                    userQueryResultSet.getString("address"),
                    role
                    );
        }
        connection.close();
        System.out.println(role);
        return user;
    }

    public List<User> obtainUsersByRole(String roleName) throws ClassNotFoundException, SQLException{
        Role role = null;
        Connection con = DBConnection.getConnection();
        PreparedStatement preparedStatement = con.prepareStatement("select * from role where name = '"+roleName+"';");
        ResultSet rs = preparedStatement.executeQuery();
        if(rs.next()) {
            role = new Role(rs.getLong("id"),rs.getString("name"));
        }
        List<User> uList = new ArrayList<User>();
        PreparedStatement ps = con.prepareStatement("select * from user where role_id="+role.getId());
        ResultSet rs1 = ps.executeQuery();
        RoleBO roleBO = new RoleBO();
        while(rs1.next()) {
            role = roleBO.obtainRoleById(rs1.getInt("role_id"));
            uList.add(new User(rs1.getLong("id"), rs1.getString("name"), rs1.getString("username"), rs1.getString("password"), rs1.getString("mobile_number"), rs1.getString("email"), rs1.getString("address"), role));
        }
        con.close();
        return uList;
    }
	public User obtainUsersById(Long id) throws ClassNotFoundException, SQLException {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("select * from user where id="+id);
        ResultSet rs1 = ps.executeQuery();
        RoleBO roleBO = new RoleBO();
        if(rs1.next()) {
            Role role = roleBO.obtainRoleById(rs1.getInt("role_id"));
            User u= (new User(rs1.getLong("id"), rs1.getString("name"), rs1.getString("username"), rs1.getString("password"), rs1.getString("mobile_number"), rs1.getString("email"), rs1.getString("address"), role));
            return u;
        }
        con.close();
        return null;
	}
}
