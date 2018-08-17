package com.monitorMongo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args)
          throws IOException {
        MonitorMongo mm = new MonitorMongo();

        List<Coleccion> listaColeccionesProduccion = new ArrayList();
        List<Coleccion> listaColeccionesPrimario = new ArrayList();
        List<Coleccion> listaColeccionesSecundario = new ArrayList();

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<");
        listaColeccionesProduccion = mm.monitoreoBaseMongo("192.168.70.78", 27017, "Restitucion");
        for (Coleccion listaColeccionesProduccion1 : listaColeccionesProduccion) {
            if (((Coleccion) listaColeccionesProduccion1).getNumeroDocumentos() != null) {
                System.out.println("Coleccion " + ((Coleccion) listaColeccionesProduccion1).getNombreColeccion() + " ::::: " + ((Coleccion) listaColeccionesProduccion1).getNumeroDocumentos());
            }
        }

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<");

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<");
        listaColeccionesPrimario = mm.monitoreoBaseMongo("192.168.70.219", 27017, "Restitucion");
        for (Coleccion listaColeccionesPrimario1 : listaColeccionesPrimario) {
            if (((Coleccion) listaColeccionesPrimario1).getNumeroDocumentos() != null) {
                System.out.println("Coleccion " + ((Coleccion) listaColeccionesPrimario1).getNombreColeccion() + " ::::: " + ((Coleccion) listaColeccionesPrimario1).getNumeroDocumentos());
            }
        }

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<");

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<");
        listaColeccionesSecundario = mm.monitoreoBaseMongo("192.168.70.220", 27017, "Restitucion");
        for (Coleccion listaColeccionesSecundario1 : listaColeccionesSecundario) {
            if (((Coleccion) listaColeccionesSecundario1).getNumeroDocumentos() != null) {
                System.out.println("Coleccion " + ((Coleccion) listaColeccionesSecundario1).getNombreColeccion() + " ::::: " + ((Coleccion) listaColeccionesSecundario1).getNumeroDocumentos());
            }
        }

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<");
    }
}
