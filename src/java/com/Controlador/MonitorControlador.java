package com.Controlador;

import com.monitorMongo.Coleccion;
import com.monitorMongo.MonitorMongo;
import java.io.Serializable;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "monitorControlador")
@ViewScoped
public class MonitorControlador
      implements Serializable {

    private List<Coleccion> listaColeccionesProduccion = new ArrayList();
    private List<Coleccion> listaColeccionesPrimario = new ArrayList();
    private List<Coleccion> listaColeccionesSecundario = new ArrayList();

    private Integer totalMaestro;

    private Integer totalPrimario;
    public float porcPrimario;
    private Integer totalSecundario;
    public float porcSecundario;
    private List<Integer> listaPorcentajes = new ArrayList();

    public Integer getTotalMaestro() {
        return this.totalMaestro;
    }

    public void setTotalMaestro(Integer totalMaestro) {
        this.totalMaestro = totalMaestro;
    }

    public Integer getTotalPrimario() {
        return this.totalPrimario;
    }

    public void setTotalPrimario(Integer totalPrimario) {
        this.totalPrimario = totalPrimario;
    }

    public float getPorcPrimario() {
        return this.porcPrimario;
    }

    public void setPorcPrimario(Integer porcPrimario) {
        this.porcPrimario = porcPrimario;
    }

    public Integer getTotalSecundario() {
        return this.totalSecundario;
    }

    public void setTotalSecundario(Integer totalSecundario) {
        this.totalSecundario = totalSecundario;
    }

    public float getPorcSecundario() {
        return this.porcSecundario;
    }

    public void setPorcSecundario(float porcSecundario) {
        this.porcSecundario = porcSecundario;
    }

    public List<Integer> getListaPorcentajes() {
        return this.listaPorcentajes;
    }

    public void setListaPorcentajes(List<Integer> listaPorcentajes) {
        this.listaPorcentajes = listaPorcentajes;
    }

    public List<Coleccion> getListaColeccionesProduccion() {
        return this.listaColeccionesProduccion;
    }

    public void setListaColeccionesProduccion(List<Coleccion> listaColeccionesProduccion) {
        this.listaColeccionesProduccion = listaColeccionesProduccion;
    }

    public List<Coleccion> getListaColeccionesPrimario() {
        return this.listaColeccionesPrimario;
    }

    public void setListaColeccionesPrimario(List<Coleccion> listaColeccionesPrimario) {
        this.listaColeccionesPrimario = listaColeccionesPrimario;
    }

    public List<Coleccion> getListaColeccionesSecundario() {
        return this.listaColeccionesSecundario;
    }

    public void setListaColeccionesSecundario(List<Coleccion> listaColeccionesSecundario) {
        this.listaColeccionesSecundario = listaColeccionesSecundario;
    }

    public void ObtenerDatosMongo()
          throws UnknownHostException {
        MonitorMongo mm = new MonitorMongo();
        MonitorControlador mc = new MonitorControlador();

        if (ping("192.168.56.100", 27017)) {
//            this.listaColeccionesProduccion = mm.monitoreoBaseMongo("192.168.70.78", 27017, "Restitucion");
            this.listaColeccionesProduccion = mm.monitoreoBaseMongo("192.168.56.100", 27017, "Restitucion");
            this.totalMaestro = mc.calcularTotal(this.listaColeccionesProduccion);
        } else {
            this.listaColeccionesProduccion = null;
            this.totalMaestro = 0;
        }

//        if (ping("192.168.70.219", 27017)) {
        if (ping("192.168.56.1", 27017)) {
//            this.listaColeccionesPrimario = mm.monitoreoBaseMongo("192.168.70.219", 27017, "Restitucion");
            this.listaColeccionesPrimario = mm.monitoreoBaseMongo("192.168.56.1", 27017, "Restitucion");
            this.totalPrimario = mc.calcularTotal(this.listaColeccionesPrimario);
        } else {
            this.listaColeccionesPrimario = null;
            this.totalPrimario = 0;
        }

        if (ping("192.168.70.220", 27017)) {
            this.listaColeccionesSecundario = mm.monitoreoBaseMongo("192.168.70.220", 27017, "Restitucion");
            this.totalSecundario = mc.calcularTotal(this.listaColeccionesSecundario);
        } else {
            this.listaColeccionesSecundario = null;
            this.totalSecundario = 0;
        }
        
        

        if (this.totalMaestro == 0) {
            System.out.println("Sin  coneccion  al  servidor  de produccion");
        } else {
            if (this.totalPrimario == 0) {
                this.porcPrimario = 0.0F;
            } else {
                this.porcPrimario = (this.totalPrimario * 100 / this.totalMaestro);
                System.out.println("---------------" + this.porcPrimario);
            }

            if (this.totalSecundario == 0) {
                this.porcSecundario = 0.0F;
            } else {
                this.porcSecundario = (this.totalSecundario * 100 / this.totalMaestro);
                System.out.println("---------------" + this.porcSecundario);
            }
        }
    }

    public Boolean ping(String dirWeb, int puerto) {
        Boolean estado = false;
        try {
            Socket s = new Socket(dirWeb, puerto);

            if (s.isConnected()) {
                System.out.println("Conexión establecida con la dirección: " + dirWeb + " a travéz del puerto: " + puerto);
            }

            estado = true;
        } catch (Exception e) {
            System.err.println("No se pudo establecer conexión con: " + dirWeb + " a travez del puerto: " + puerto);
            estado = false;
        }
        return estado;
    }

    public int calcularTotal(List<Coleccion> lista) {
        Integer total = 0;
        for (Coleccion lista1 : lista) {
            total = total + ((Coleccion) lista1).getNumeroDocumentos();
        }
        return total;
    }
}
