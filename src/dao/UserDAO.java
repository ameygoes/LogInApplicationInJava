
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

//        CREATE OBJECTS FOR USER AND ROLE AND INITIALIZE THEM AS NULL
        User user =null;
        RoleBO roleBO = new RoleBO();

//        OPEN UP A DATABASE CONNECTION
        Connection connection = DBConnection.getConnection();

//        PREPARE A STATEMENT TO FETCH USER FROM DATABASE USING USERNAME AND PASSWORD
        PreparedStatement userPreparedStatement = GetPreparedStatement(connection, USER_GET_USER_FROM_USERNAME_PASSWORD_SQL);

//        SET THE ATTRIBUTES IN THE QUERY -> REPLACING QUESTION MARKS(?) IN THE QUERY
        userPreparedStatement.setString(1,username);
        userPreparedStatement.setString(2,password);

//        EXECUTE THE QUERY -> IT WILL RETURN A RESULT SET OF ONE USER!!
        ResultSet userQueryResultSet = userPreparedStatement.executeQuery();

//        CHECK IF USER IS PRESENT OR NOT IF YES THEN PROCEED
        while(userQueryResultSet.next()) {

            // SINCE USER MODEL HAS ROLE OBJECT AS AN ATTRIBUTE WE NEED TO FETCH THE ROLE OF THAT USER
            // TO DETERMINE IF HE/SHE IS THE RIGHT PERSON TO MAKE CHANGES OR NOT
            Role role = roleBO.obtainRoleById(userQueryResultSet.getInt("role_id"));

//            CALL A USER CONSTRUCTOR TO EMBED VALUES FROM DB AND RETURN THIS USER TO BO CLASS
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

//        AFTER GETTING THE DETAILS CLOSE THE CONNECTION
        connection.close();

//        AND RETURN THE USER
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
