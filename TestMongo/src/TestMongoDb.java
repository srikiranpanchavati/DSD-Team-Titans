import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class TestMongoDb {

	public static void main(String arg[])
	{
		@SuppressWarnings("resource")
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		@SuppressWarnings("deprecation")
		DB db = mongoClient.getDB("testDatabase");
		DBCollection dbColl = db.getCollection("Employee");
		BasicDBObject basicdbObject = new BasicDBObject();
		basicdbObject.put("name", "kiran");
		basicdbObject.put("age", 23);
		dbColl.insert(basicdbObject);

		//retrieve
		basicdbObject.remove("name");
		basicdbObject.put("name", "help");
		
		DBCursor cursor1 = dbColl.find();
		while(cursor1.hasNext())
			System.out.println(cursor1.next());		
	}
}



