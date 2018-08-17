package com.monitorMongo;

import java.io.Serializable;

public class Coleccion
      implements Serializable {

    String nombreColeccion;
    Integer numeroDocumentos;

    public String getNombreColeccion() {
        return this.nombreColeccion;
    }

    public void setNombreColeccion(String nombreColeccion) {
        this.nombreColeccion = nombreColeccion;
    }

    public Integer getNumeroDocumentos() {
        return this.numeroDocumentos;
    }

    public void setNumeroDocumentos(Integer numeroDocumentos) {
        this.numeroDocumentos = numeroDocumentos;
    }
}
