package Controller;

import Model.Admin;
import Model.User;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class UserController {
    public User user;
    public DBConnection dbConnection;

    public UserController() {
        dbConnection = new DBConnection();
        dbConnection.connection();
    }
    public UserController(User user)
    {
        dbConnection=new DBConnection();
        dbConnection.connection();
        this.user=user;
    }
    public UserController(Admin admin)
    {
        dbConnection=new DBConnection();
        dbConnection.connection();
        this.user=user;

    }

    public void login()
    {



    }
    public void addUser()
    {
        dbConnection.collection=dbConnection.database.getCollection("Users");
        dbConnection.collection.insert(convert(this.user));
    }
    public void addAdmin()
    {
        dbConnection.collection=dbConnection.database.getCollection("Admins");
        dbConnection.collection.insert(convert(this.user));
    }
    public void showUsers()
    {
        dbConnection.collection=dbConnection.database.getCollection("Users");
        DBObject query=new BasicDBObject();
        DBCursor cursor=dbConnection.collection.find(query);
        System.out.println(cursor.one());
    }
    public static DBObject convert(User user){
        return new BasicDBObject("ID",user.getID()).append("Username",user.getUsername()).append("Password",user.getPassword()).append("FullName",user.getFullName()).append("Email",user.getEmail()).append("PhoneNumber",user.getPhoneNumber());
    }
}
