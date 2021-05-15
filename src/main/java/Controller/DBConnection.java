package Controller;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class DBConnection {
    public static MongoClient mongoClient;
    public static DB database;
    public static DBCollection collection;

    public DBConnection(){};
    public static void connection(){
        mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        database=mongoClient.getDB("MongoDBTutorial");
    }
}
