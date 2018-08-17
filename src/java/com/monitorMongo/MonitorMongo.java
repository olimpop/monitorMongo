package com.monitorMongo;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class MonitorMongo {

    ConexionMongo cm = new ConexionMongo();

    public List<Coleccion> monitoreoBaseMongo(String ipServidor, Integer puertoServidor, String bd) throws UnknownHostException {
        List<Coleccion> listaColecciones = new ArrayList();

        List<String> lista = new ArrayList();

        Mongo mongo = new Mongo(ipServidor, puertoServidor);
        DB baseMongo = mongo.getDB(bd);

        lista.addAll(baseMongo.getCollectionNames());

        lista.stream().forEach((lista1) -> {
            Coleccion col = new Coleccion();
            String nombreColeccion = "";
            DBCollection collection = baseMongo.getCollection((String) lista1);
            Integer totalRegistros = collection.find().count();
            nombreColeccion = (String) lista1;
            if (nombreColeccion != null) {
                col.setNombreColeccion(nombreColeccion);
                col.setNumeroDocumentos(totalRegistros);
                listaColecciones.add(col);
            }
        });
        mongo.close();
        return listaColecciones;
    }
}