package Controller;

import Model.Admin;
import Model.Product;
import Model.Supplier;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class ProductController {
    public Product product;
    public DBConnection dbConnection;
    public DBCollection collection;
    public DBObject query;



    public ProductController()
    {
        dbConnection = new DBConnection();
        dbConnection.connection();
        collection=dbConnection.database.getCollection("Products");
        this.product=new Product();

    }
    public ProductController(Product product)
    {
        dbConnection=new DBConnection();
        dbConnection.connection();
        collection=dbConnection.database.getCollection("Products");
        this.product =product;
    }

    public void addProduct()
    {
        //dbConnection.collection=dbConnection.database.getCollection("Admins");
        // dbConnection.collection.insert(convert(this.admin));
        collection.insert(convert(this.product));
    }
    public void deleteProduct(int productID)
    {
        // dbConnection.collection=dbConnection.database.getCollection("Admins");
        query=new BasicDBObject("ID", productID);
        collection.findAndRemove(query);
        //  dbConnection.collection.findAndRemove(convert(this.admin));

    }
    public void updateProduct(int ID, String name, String description, float price, int qty)
    {
        this.product.setID(ID);
        this.product.setName(name);
        this.product.setPrice(price);
        this.product.setDescription(description);
        this.product.setQty(qty);
        query=new BasicDBObject("ID", ID);
        DBCursor cursor=collection.find(query);
        this.product.setCategoryID((Integer) cursor.one().get("CategoryID"));
        //this.admin.setFullName(collection.find(new BasicDBObject("FullName", this.admin.getFullName())).getCollection().find().one().getFullName());
        collection.findAndModify(query, convert(this.product));

    }
    public static DBObject convert(Product product){
        return new BasicDBObject("ID",product.getID()).append("Name",product.getName()).append("Price",product.getPrice()).append("Description",product.getDescription()).append("CategoryID",product.getCategoryID()).append("Qty",product.getQty());
    }

}