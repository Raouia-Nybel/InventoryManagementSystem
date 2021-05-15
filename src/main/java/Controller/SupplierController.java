package Controller;

import Model.Admin;
import Model.Supplier;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class SupplierController {
    public Supplier supplier;
    public DBConnection dbConnection;
    public DBCollection collection;
    public DBObject query;

public SupplierController()
{
    dbConnection = new DBConnection();
    dbConnection.connection();
    collection=dbConnection.database.getCollection("Suppliers");
    this.supplier=new Supplier();

}
public SupplierController(Supplier supplier)
{
    dbConnection=new DBConnection();
    dbConnection.connection();
    collection=dbConnection.database.getCollection("Suppliers");
    this.supplier =supplier;
}

    public boolean login(String username, String password)
    {
        query=new BasicDBObject("Username",username);
        DBCursor cursor= collection.find(query);
        // System.out.println(cursor.one());
        if(cursor.one() == null)
        {
            return false;

        }else{
            if(username.equals((cursor.one()).get("Username"))) {
                query = new BasicDBObject("Password", password);
                cursor = collection.find(query);
                if (cursor.one() == null) {
                    return false;
                } else {
                    if (password.equals(cursor.one().get("Password").toString())) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }else return false;
        }
    }

    public void addSupplier()
    {
        //dbConnection.collection=dbConnection.database.getCollection("Admins");
        // dbConnection.collection.insert(convert(this.admin));
        collection.insert(convert(this.supplier));
    }
    public void deleteSupplier(int supplierID)
    {
        query=new BasicDBObject("ID", supplierID);
        collection.findAndRemove(query);

    }
    public void updateSupplier(int ID, String username, String password, String email, long phoneNo)
    {
        this.supplier.setEmail(email);
        this.supplier.setUsername(username);
        this.supplier.setPassword(password);
        this.supplier.setPhoneNumber(phoneNo);
        this.supplier.setID(ID);
        query=new BasicDBObject("ID", ID);
        DBCursor cursor=collection.find(query);
        this.supplier.setFullName(cursor.one().get("FullName").toString());
        collection.findAndModify(query, convert(this.supplier));

    }

    public static DBObject convert(Supplier supplier){
        return new BasicDBObject("ID",supplier.getID()).append("Username",supplier.getUsername()).append("Password",supplier.getPassword()).append("FullName",supplier.getFullName()).append("Email",supplier.getEmail()).append("PhoneNumber",supplier.getPhoneNumber());
    }







}
