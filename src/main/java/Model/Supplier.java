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

    public void addOrder(Order order)
    {
        if(supplierController.addOrder(order)){
            System.out.println("Order with ID = "+ order.getID() + " was successfully added");
        }else{
            System.out.println("Order with ID = "+ order.getID() + " was NOT successfully added");
        }
    }
    public void deleteOrder(int ID)
    {
        supplierController.deleteOrder(ID);
        System.out.println("Order with ID = " + ID + " was successfully deleted");

    }
    public void updateOrder(int ID, float amount, int date, String status, int qty)
    {
        supplierController.updateOrder(ID, amount, date, status, qty );
        System.out.println("Order with ID = " + ID + " was successfully updated");
    }
    public void showOrders(){}
    public void showProducts(){}
}
