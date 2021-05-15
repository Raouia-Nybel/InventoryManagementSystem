package Model;

import Controller.AdminController;
import Controller.UserController;
import com.mongodb.DBCursor;

public class Admin extends User {
    public static AdminController adminController=new AdminController();

    public Admin ()
    {
        super();
        adminController=new AdminController(this);
    }

    public void login(String username, String password)
    {
        /*boolean status=adminController.login(username, password);
        if(status)
        {
            System.out.println("Successful Log In");
        }else{
            System.out.println("Failed Log In");
        }*/
        adminController.login(username, password);

    }

    public void addAdmin()
    {
        adminController.addAdmin();
        System.out.println("Admin with ID = "+ this.getID() +" was successfully added");

    }
    public void deleteAdmin(int adminID)
    {
        adminController.deleteAdmin(adminID);
        System.out.println("Admin with ID = "+ adminID +" was successfully deleted");

    }
    public void updateAdmin(int ID, String username, String password, String email, long phoneNo)
    {
        adminController.updateAdmin(ID,username,password,email,phoneNo);
        System.out.println("Admin with ID = " + ID + " was successfully updated");
    }


    public void addSupplier(Supplier supplier)
    {
        adminController.addSupplier(supplier);
        System.out.println("Supplier with ID = " + supplier.getID() + " was successfully added");
    }
    public void deleteSupplier(int supplierID)
    {
        adminController.deleteSupplier(supplierID);
        System.out.println("Supplier with ID = " + supplierID + " was successfully deleted");
    }
    public void updateSupplier(int ID, String username, String password, String email, long phoneNo)
    {
        adminController.updateSupplier(ID, username, password, email, phoneNo);
        System.out.println("Supplier with ID = " + ID + " was successfully updated");
    }


    public void addProduct(Product product)
    {
        adminController.addProduct(product);
        System.out.println("Product with ID = " + product.getID() + " was successfully added");
    }
    public void deleteProduct(int productID)
    {
        adminController.deleteProduct(productID);
        System.out.println("Supplier with ID = " + productID + " was successfully deleted");
    }
    public void updateProduct(int ID, String name, String description, float price, int qty)
    {
        adminController.updateProduct(ID, name, description, price, qty);
        System.out.println("Product with ID = " + ID + " was successfully updated");
    }

    public void addCategory(Category category)
    {
        adminController.addCategory(category);
        System.out.println("Category with ID = " + category.getID() + " was successfully added");
    }

    public void deleteCategory(int categoryID)
    {
        adminController.deleteCategory(categoryID);
        System.out.println("Category with ID = " + categoryID + " was successfully deleted");

    }
}
