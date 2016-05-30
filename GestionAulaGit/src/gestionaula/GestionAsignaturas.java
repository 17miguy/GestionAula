/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionaula;

import java.util.HashMap;

/**
 *
 * @author dam1
 */

public class GestionAsignaturas {

    protected HashMap<String, String> listaAsignaturas = new HashMap<>();

    public GestionAsignaturas() {
        
    }

    public HashMap<String, String> getListaAsignaturas() {
        return listaAsignaturas;
    }

    public void setListaAsignaturas(HashMap<String, String> listaAsignaturas) {
        this.listaAsignaturas = listaAsignaturas;
    }

    public void añadirAsignatura(String clave, String asignatura) {
        listaAsignaturas.put(clave, asignatura);
    }

    public void borrarAsignatura(String asignatura) {

        if (listaAsignaturas.containsValue(asignatura)) {
            listaAsignaturas.remove(asignatura);

        }

    }

}


