package Controller;

import Model.Inventory;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import java.util.Objects;

public class InventoryController {
    public Inventory inventory;
    public DBConnection dbConnection;
    public DBCollection collection;
    public DBObject query;

    public InventoryController() {
        dbConnection = new DBConnection();
        dbConnection.connection();
        collection=dbConnection.database.getCollection("Inventories");
        this.inventory=new Inventory();
    }

    public InventoryController(Inventory inventory)
    {
        dbConnection=new DBConnection();
        dbConnection.connection();
        collection=dbConnection.database.getCollection("Inventories");
        this.inventory =inventory;
    }

    public void addInventory()
    {
        collection.insert(convert(this.inventory));
    }

    public void deleteInventory(int ID)
    {
        query=new BasicDBObject("ID",ID);
        collection.findAndRemove(query);
    }
    public void updateInventory(int ID, String description, int qty)
    {
        this.inventory.setID(ID);
        this.inventory.setDescription(description);
        this.inventory.setQty(qty);
        query=new BasicDBObject("ID",ID);
        DBCursor cursor=collection.find(query);
        this.inventory.setType(cursor.one().get("Type").toString());
        this.inventory.setCategoryID((Integer) cursor.one().get("CategoryID"));
        collection.findAndModify(query,convert(this.inventory));

    }
    public Inventory checkInventory(int categoryID)
    {
        query=new BasicDBObject("CategoryID", categoryID);
        DBCursor cursor=collection.find(query);
       // this.inventory.setQty((Integer) cursor.one().get("Qty"));
        if(cursor.one()==null)
        {
            return null;
        }else{
            this.inventory.setID((Integer) cursor.one().get("ID"));
            inventory.setQty((Integer) cursor.one().get("Qty"));
            inventory.setDescription(cursor.one().get("Description").toString());
            inventory.setCategoryID((Integer) cursor.one().get("CategoryID"));
            inventory.setType(cursor.one().get("Type").toString());
            return this.inventory;

        }



    }

    public static DBObject convert(Inventory inventory){
        return new BasicDBObject("ID",inventory.getID()).append("Type",inventory.getType()).append("Description",inventory.getDescription()).append("CategoryID",inventory.getCategoryID()).append("Qty",inventory.getQty());
    }
    public static Inventory convert(DBObject dbObject)
    {
        Inventory inventory=new Inventory();
        inventory.setID((Integer) dbObject.get("ID"));
        inventory.setQty((Integer) dbObject.get("Qty"));
        inventory.setDescription(dbObject.get("Description").toString());
        inventory.setCategoryID((Integer) dbObject.get("CategoryID"));
        inventory.setType(dbObject.get("Type").toString());
        return inventory;
    }
}
