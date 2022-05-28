package bo;

import dao.UserDAO;
import model.User;
import java.sql.SQLException;
import java.util.List;

public class UserBO {
    public User validateLogin(String username,String password) throws ClassNotFoundException, SQLException{
        //Fill your code here
        UserDAO userDAO = new UserDAO();
        return userDAO.validateLogin(username,password);
//        return null; //To keep template code without errors we have given this dummy return stmt. Change it as per the problem spec
    }
    public List<User> obtainUsersByRole(String roleName) throws ClassNotFoundException, SQLException{
        return (new UserDAO().obtainUsersByRole(roleName));
    }
	public User obtainUsersById(Long id) throws ClassNotFoundException, SQLException {
		return (new UserDAO().obtainUsersById(id));
	}
}
