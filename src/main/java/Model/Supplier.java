package Model;

import Controller.SupplierController;

public class Supplier extends User{
    public static SupplierController supplierController=new SupplierController();


    public Supplier()
    {
        super();
        supplierController=new SupplierController(this);
    }
}
