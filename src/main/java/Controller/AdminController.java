package Controller;

import Model.*;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import java.util.Objects;

public class AdminController {
    public Admin admin;
    public DBConnection dbConnection;
    public DBCollection collection;
    public DBObject query;
    public SupplierController supplierController;
    public ProductController productController;
    public CategoryController categoryController;
    public InventoryController inventoryController;

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
    public void showAdmins()
    {
       query=new BasicDBObject();
       DBCursor cursor=collection.find();

    }
    public void showSuppliers()
    {
        collection=dbConnection.database.getCollection("Suppliers");
        query=new BasicDBObject();
        DBCursor cursor=collection.find();
        {
            System.out.println(cursor.one());
        }
    }

    public void showProducts()
    {
        collection=dbConnection.database.getCollection("Products");
        query=new BasicDBObject();
        DBCursor cursor=collection.find();
        {
            System.out.println(cursor.one());
        }
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


    public void addInventory(Inventory inventory)
    {
        inventoryController=new InventoryController(inventory);
        inventoryController.addInventory();
    }
    public void deleteInventory(int inventoryID)
    {
        inventoryController=new InventoryController();
        inventoryController.deleteInventory(inventoryID);
    }
    public void updateInventory(int ID, String description, int qty)
    {
        inventoryController=new InventoryController();
        this.inventoryController.updateInventory(ID, description, qty);
    }
    public Inventory checkInventory(int productID)
    {
        inventoryController=new InventoryController();
        int categoryID;
        Inventory inventory;
        collection=dbConnection.database.getCollection("Products");
        inventoryController.checkInventory(productID);
        query=new BasicDBObject("ID",productID);
        DBCursor cursor=collection.find(query);
        categoryID= (int) cursor.one().get("CategoryID");
        inventory=inventoryController.checkInventory(categoryID);
        System.out.println(inventory);
    return inventory;
    }







    public static DBObject convert(Admin admin){
        return new BasicDBObject("ID",admin.getID()).append("Username",admin.getUsername()).append("Password",admin.getPassword()).append("FullName",admin.getFullName()).append("Email",admin.getEmail()).append("PhoneNumber",admin.getPhoneNumber());
    }
}
