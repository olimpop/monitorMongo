package com.monitorMongo;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import java.io.IOException;

public class GetDocumentos {

    public void consultaMongo()
          throws IOException {
        Mongo mongo = new Mongo("192.168.70.78", 27017);
        DB db = mongo.getDB("Restitucion");
        DBCollection collection = db.getCollection("documento_microzona_anexo.files");

        DBObject query = new BasicDBObject("filename", "1765735");

        DBCursor cursor = collection.find(query);
        while (cursor.hasNext()) {
            System.out.println(cursor.next().get("_id"));
        }
    }
}
