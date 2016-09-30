/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.Date;

/**
 *
 * @author haymica
 */
public class Aplic_Web {
    private int id;
      private String titulo;
     private String descripcion;
     private Date fechaHabilitacion;
     private String url;

    public Aplic_Web(int id, String titulo, String descripcion, Date fechaHabilitacion, String url) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaHabilitacion = fechaHabilitacion;
        this.url = url;
    }
      public Aplic_Web() {
        this.id = 0;
        this.titulo = null;
        this.descripcion = null;
        this.fechaHabilitacion = null;
        this.url = null;
    }
     
}
