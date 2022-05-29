package bo;

import dao.UserDAO;
import model.User;
import java.sql.SQLException;
import java.util.List;

// BO CLASS IS JUST LIKE A CALLER ENTITY WHICH IS USED TO CALL DAO FUNCTIONS TO GET THE JOB DONE!!
public class UserBO {

    // A PUBLIC METHOD WHICH WILL VALIDATE THE LOGIN CREDENTIALS OF A USER FOR US.
    public User validateLogin(String username,String password) throws ClassNotFoundException, SQLException{


        //CREATE A USER DAO OBJECT - WHICH CALLS THE WORKING FUNCTION TO GET THE JOB DONE!!
        UserDAO userDAO = new UserDAO();
        return userDAO.validateLogin(username,password);
    }
    public List<User> obtainUsersByRole(String roleName) throws ClassNotFoundException, SQLException{
        return (new UserDAO().obtainUsersByRole(roleName));
    }
	public User obtainUsersById(Long id) throws ClassNotFoundException, SQLException {
		return (new UserDAO().obtainUsersById(id));
	}
}
