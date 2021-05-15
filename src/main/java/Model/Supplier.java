package Model;

import Controller.SupplierController;

public class Supplier extends User{
    public static SupplierController supplierController=new SupplierController();


    public Supplier()
    {
        super();
        supplierController=new SupplierController(this);
    }
    public void login(String username, String password)
    {
        boolean status=supplierController.login(username, password);
        if(status)
        {
            System.out.println("Successful Log In");
        }else{
            System.out.println("Failed Log In");
        }


    }
}
