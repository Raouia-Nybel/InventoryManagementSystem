package Controller;

import Model.Category;
import Model.Supplier;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

public class CategoryController {
    public Category category;
    public DBConnection dbConnection;
    public DBCollection collection;
    public DBObject query;

    public CategoryController()
    {
        dbConnection = new DBConnection();
        dbConnection.connection();
        collection=dbConnection.database.getCollection("Categories");
        this.category =new Category();

    }
    public CategoryController(Category category)
    {
        dbConnection=new DBConnection();
        dbConnection.connection();
        collection=dbConnection.database.getCollection("Categories");
        this.category =category;
    }

    public void addCategory()
    {
        collection.insert(convert(this.category));
    }
    public void deleteCategory(int categoryID)
    {
        query=new BasicDBObject("ID", categoryID);
        collection.findAndRemove(query);
    }

    public static DBObject convert(Category category){
        return new BasicDBObject("ID",category.getID()).append("Name",category.getName());
    }
}
