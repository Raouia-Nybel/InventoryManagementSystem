import Controller.AdminController;
import Controller.ProductController;
import Controller.UserController;
import Model.*;

public class MainSystem {


    public static Admin admin;
    public static Supplier supplier;
    public static Product product;
    public static Category category;
    public static Inventory inventory;

    public static void main(String[] args) {
       admin =new Admin();
       supplier=new Supplier();

        admin.login("AdminNouha","NK0050418WRTS");

        inventory=new Inventory();

        inventory.setID(12);
        inventory.setType("Smartphones");
        inventory.setQty(200);
        inventory.setDescription("Smartphones inventory");
        inventory.setCategoryID(2);

        admin.addInventory(inventory);


      /*  category=new Category();

        category.setName("Smartphones");
        category.setID(2);

        admin.addCategory(category);

       product=new Product();

        product.setID(16);
        product.setName("Iphone 12 pro max");
        product.setCategoryID(2);
        product.setQty(30);
        product.setPrice(1400);
        product.setDescription("New Iphone from Apple (The latest)");

        admin.addProduct(product);

        product.setID(20);
        product.setName("OnePlus 8 pro");
        product.setCategoryID(2);
        product.setQty(50);
        product.setPrice(950);
        product.setDescription("New OnePlus 8 pro from OnePlus");

        admin.addProduct(product);

        product.setID(33);
        product.setName("Samsung galaxy note 20 ultra");
        product.setCategoryID(2);
        product.setQty(120);
        product.setPrice(1200);
        product.setDescription("New Galaxy note 20 Ultra from Samsung (The latest)");

        admin.addProduct(product);*/



      /* */


       //category.setID(1);
       //category.setName("Laptop");

//supplier.login("SupplierZayn","SS45HFHZK456IOEFGGHDD");
       /*product.setID(12);
       product.setName("Dell Inspiron 14 7700");
       product.setCategoryID(1);
       product.setQty(100);
       product.setPrice(1375);
       product.setDescription("Notebook Laptop from dell");

       admin.addProduct(product);

        product.setID(14);
        product.setName("Macbook Pro 15");
        product.setCategoryID(1);
        product.setQty(250);
        product.setPrice(1500);
        product.setDescription("New Macbook Pro Laptop from Apple");

       admin.addProduct(product);*/
        //admin.deleteProduct(12);
        //admin.updateProduct(14,"Macbook Pro 20", "New Macbook Pro Laptop from Apple", 2000, 120);





        /*supplier.setID(33);
        supplier.setUsername("Supplier");
        supplier.setPassword("SS45HFHZK456IOEF");
        supplier.setFullName("Zayn Malik");
        supplier.setEmail("ZaynMalik@MUSICPROD.com");
        supplier.setPhoneNumber(12657899);
       admin.addSupplier(supplier);*/
       // admin.updateSupplier(33,"SupplierZayn", "SS45HFHZK456IOEFGGHDD", "ZaynMalik@MUSICPROD.com", 12657899);

      /* admin.setID(9);
       admin.setUsername("AdminNybel");
       admin.setPassword("NN992110KDJJJ");
       admin.setFullName("Nybel Lokbani");
       admin.setEmail("NybelLokbani@NYRAINC.com");
       admin.setPhoneNumber(56487633);
       admin.addAdmin();

       admin.setID(4);
        admin.setUsername("AdminNouha");
        admin.setPassword("NK0050418WRTS");
        admin.setFullName("Nouha Lokbani");
        admin.setEmail("NouhaLokbani@NYRAINC.com");
        admin.setPhoneNumber(56432345);
        admin.addAdmin();*/
     // admin.updateAdmin(4,"AdminNouha","NK0050418WRTS", "NouhaLokbani005@NYRAINC.com", 34564433);




    }


}
