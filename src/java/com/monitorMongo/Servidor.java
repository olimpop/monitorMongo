package com.monitorMongo;

import java.io.Serializable;

public class Servidor implements Serializable {

    String nombreServidor;
    String ipServidor;
    Integer puertoServidor;
    String nombreBaseDatosServidor;

    public String getNombreServidor() {
        return this.nombreServidor;
    }

    public void setNombreServidor(String nombreServidor) {
        this.nombreServidor = nombreServidor;
    }

    public String getIpServidor() {
        return this.ipServidor;
    }

    public void setIpServidor(String ipServidor) {
        this.ipServidor = ipServidor;
    }

    public Integer getPuertoServidor() {
        return this.puertoServidor;
    }

    public void setPuertoServidor(Integer puertoServidor) {
        this.puertoServidor = puertoServidor;
    }

    public String getNombreBaseDatosServidor() {
        return this.nombreBaseDatosServidor;
    }

    public void setNombreBaseDatosServidor(String nombreBaseDatosServidor) {
        this.nombreBaseDatosServidor = nombreBaseDatosServidor;
    }
}
