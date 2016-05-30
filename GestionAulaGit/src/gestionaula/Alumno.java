/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionaula;

import java.io.Serializable;

/**
 *
 * @author dam1
 */
public class Alumno implements Comparable<Alumno>, Serializable {
    
    private String nombre;
    private String apellido;
    private String dni;
    private String contraseña;

    public Alumno(String nombre, String apellido, String dni, String contraseña ) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.contraseña = contraseña;

    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "Alumno{" + "nombre=" + nombre + ", apellido=" + apellido +  ", nombremadre=" +  ", DNI=" + dni + '}';
    }    
    @Override
    public boolean equals(Object o) {
        return this.dni.equals(((Alumno)o).dni);
    }
    @Override
    public int compareTo(Alumno t) {
        int aux=0;
        if (!this.equals(t)) 
            aux = this.apellido.compareToIgnoreCase(t.apellido);
            if (aux==0)
                aux = this.nombre.compareToIgnoreCase(t.nombre);
        return aux;
    }
}
