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
public class Notas implements Comparable<Notas>, Serializable {

    
    private int calificacion;
    private Alumno alumno;
    private String asignatura;
    private int idnota;
    private int trimestre;

    public Notas(int calificacion, Alumno alumno, String asignatura, int idnota, int trimestre) {
        this.calificacion = calificacion;
        this.alumno = alumno;
        this.asignatura = asignatura;
        this.idnota = idnota;
        this.trimestre= trimestre;
    }
    

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public int getIdnota() {
        return idnota;
    }

    public void setIdnota(int idnota) {
        this.idnota = idnota;
    }

    public int getTrimestre() {
        return trimestre;
    }

    public void setFecha(int trimestre) {
        this.trimestre = trimestre;
    }
    
    public String InformeNotas(){
    return "  Asignatura : "+asignatura + "; Calificación : "+calificacion +";  Trimestre :  "+ trimestre+" ;";
            
            }

    @Override
    public String toString() {
        return "Notas{" + "calificacion=" + calificacion + ", alumno=" + alumno + ", asignatura=" + asignatura + ", idnota=" + idnota + ", trimestre="+ trimestre + '}';
    }

    @Override
    public int compareTo(Notas o) {
        int co;
        if(o.calificacion== calificacion){
            
            co= o.idnota - idnota;
        
        }
        else
            co = o.calificacion - calificacion;
        
        
        return co;
        
    }
    
    
    
}
