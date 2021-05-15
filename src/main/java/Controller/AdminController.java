package Controller;

import Model.*;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class AdminController {
    public Admin admin;
    public DBConnection dbConnection;
    public DBCollection collection;
    public DBObject query;
    public SupplierController supplierController;
    public ProductController productController;
    public CategoryController categoryController;

    public AdminController() {
        dbConnection = new DBConnection();
        dbConnection.connection();
        collection=dbConnection.database.getCollection("Admins");

    }
    public AdminController(Admin admin)
    {
        dbConnection=new DBConnection();
        dbConnection.connection();
        collection=dbConnection.database.getCollection("Admins");
        this.admin =admin;
    }


    public void login(String username, String password)
    {
        collection= collection.getCollection("Admins");
        query=new BasicDBObject("Username",this.admin.getUsername());
        DBCursor cursor= collection.find(query);
        System.out.println(cursor.one());
        /*if(username == cursor.one().get("Username").toString())
        {
            query=new BasicDBObject("Password",this.admin.getPassword());
            cursor=collection.find(query);
            if(password == cursor.one().get("Password").toString())
            {
                return true;
            }else{
                return false;
            }
        }else return false;*/
    }

    public void addAdmin()
    {
        //dbConnection.collection=dbConnection.database.getCollection("Admins");
       // dbConnection.collection.insert(convert(this.admin));
        collection.insert(convert(this.admin));
    }
    public void deleteAdmin(int adminID)
    {
       // dbConnection.collection=dbConnection.database.getCollection("Admins");
        query=new BasicDBObject("ID", adminID);
        collection.findAndRemove(query);
      //  dbConnection.collection.findAndRemove(convert(this.admin));

    }
    public void updateAdmin(int ID, String username, String password, String email, long phoneNo)
    {
        this.admin.setEmail(email);
        this.admin.setUsername(username);
        this.admin.setPassword(password);
        this.admin.setPhoneNumber(phoneNo);
        this.admin.setID(ID);
        query=new BasicDBObject("ID", ID);
        DBCursor cursor=collection.find(query);
        this.admin.setFullName(cursor.one().get("FullName").toString());
        //this.admin.setFullName(collection.find(new BasicDBObject("FullName", this.admin.getFullName())).getCollection().find().one().getFullName());
        collection.findAndModify(query, convert(this.admin));

    }
    public void showUsers()
    {
       // dbConnection.collection=dbConnection.database.getCollection("Admins");
        DBObject query=new BasicDBObject();
        DBCursor cursor=dbConnection.collection.find(query);
        System.out.println(cursor.one());
    }
    public void addSupplier(Supplier supplier)
    {
        supplierController=new SupplierController(supplier);
        supplierController.addSupplier();

    }
    public void deleteSupplier(int supplierID)
    {
        supplierController=new SupplierController();
        supplierController.deleteSupplier(supplierID);

    }
    public void updateSupplier(int ID, String username, String password, String email, long phoneNo)
    {
        supplierController=new SupplierController();
        this.supplierController.updateSupplier(ID, username, password, email, phoneNo);
    }

    public void addProduct(Product product)
    {
        productController=new ProductController(product);
        productController.addProduct();

    }
    public void deleteProduct(int productID)
    {
        productController=new ProductController();
        productController.deleteProduct(productID);

    }
    public void updateProduct(int ID, String name, String description, float price, int qty)
    {
        productController=new ProductController();
        this.productController.updateProduct(ID, name, description, price, qty);
    }

    public void addCategory(Category category)
    {
        categoryController=new CategoryController(category);
        categoryController.addCategory();
    }
    public void deleteCategory(int categoryID)
    {
        categoryController=new CategoryController();
        categoryController.deleteCategory(categoryID);
    }







    public static DBObject convert(Admin admin){
        return new BasicDBObject("ID",admin.getID()).append("Username",admin.getUsername()).append("Password",admin.getPassword()).append("FullName",admin.getFullName()).append("Email",admin.getEmail()).append("PhoneNumber",admin.getPhoneNumber());
    }
}
