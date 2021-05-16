package Controller;

import Model.Order;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

public class OrderController {
    public DBConnection dbConnection;
    public DBCollection collection;
    public DBObject query;
    public Order order;


    public OrderController()
    {
        dbConnection = new DBConnection();
        dbConnection.connection();
        collection=dbConnection.database.getCollection("Orders");
        this.order=new Order();
    }

    public OrderController(Order order)
    {
        dbConnection = new DBConnection();
        dbConnection.connection();
        collection=dbConnection.database.getCollection("Orders");
        this.order=order;
    }


    public void addOrder()
    {
        collection.insert(convert(this.order));
    }
    public void deleteOrder(int ID)
    {
        query=new BasicDBObject("ID", ID);
        collection.findAndRemove(query);
    }
    public void updateOrder(int ID, float amount, int date, String status, int qty)
    {
        this.order.setID(ID);
        this.order.setQty(qty);
        this.order.setAmount(amount);
        this.order.setDate(date);
        this.order.setStatus(status);

        query=new BasicDBObject("ID", ID);
        DBCursor cursor=collection.find(query);
        this.order.setProductID((Integer) cursor.one().get("ProductID"));
        this.order.setSupplierID((Integer) cursor.one().get("SupplierID"));
        collection.findAndModify(query, convert(this.order));
    }

    public static DBObject convert(Order order){
        return new BasicDBObject("ID",order.getID()).append("ProductID",order.getProductID()).append("SupplierID",order.getSupplierID()).append("Amount",order.getAmount()).append("Date",order.getDate()).append("Status",order.getStatus()).append("Qty", order.getQty());
    }
}
