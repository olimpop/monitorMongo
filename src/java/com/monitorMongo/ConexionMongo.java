package com.monitorMongo;

import com.mongodb.DB;
import com.mongodb.Mongo;
import java.net.UnknownHostException;

public class ConexionMongo {

    public DB conectarMongo(String ipServidor, Integer puertoServidor, String baseDatos)
          throws UnknownHostException {
        Mongo mongo = new Mongo(ipServidor, puertoServidor);
        DB db = mongo.getDB(baseDatos);
        mongo.close();
        return db;
    }
}
