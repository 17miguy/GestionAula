
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionaula;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author dam1
 */
public class Ficheros {

    public static void grabarListaAlumnos(TreeSet lista) {

        File ficher = new File("listaAlumnos.dat");
        try {
            FileOutputStream flujosalida = new FileOutputStream(ficher);
            ObjectOutputStream ous = new ObjectOutputStream(flujosalida);
            Iterator it = lista.iterator();
            for (int i = 0; i < lista.size(); i++) {
                if (it.hasNext()) {
                    ous.writeObject(it.next());
                }
            }
            ous.close();

        } catch (IOException ex) {
            System.out.println("Fichero no encontrado");
        }
    }

    public static GestionAlumno cargarListaAlumnos() {
        File ficher = new File("listaAlumnos.dat");
        GestionAlumno gestora = new GestionAlumno();
        boolean salir = false;
        try {
            FileInputStream flujosalida = new FileInputStream(ficher);
            ObjectInputStream ois = new ObjectInputStream(flujosalida);
           
            while (salir == false) {
                try{
                Object aux = ois.readObject();
                if (aux != null) {
                   gestora.AñadirAlumno((Alumno) aux);
                }
                }catch (EOFException ex) {
                    salir=true;
                    System.out.println("Se ha alcanzado el final de fichero");
                }    
            }
            ois.close();

        }  catch (IOException ex) {
            System.out.println("Error de E/S");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException");
        }

        return gestora;
    }
    public static void grabarListaNotas(ArrayList lista) {

        File ficher = new File("listaNotas.dat");
        try {
            FileOutputStream flujosalida = new FileOutputStream(ficher);
            ObjectOutputStream ous = new ObjectOutputStream(flujosalida);
            Iterator it = lista.iterator();
            for (int i = 0; i < lista.size(); i++) {
                if (it.hasNext()) {
                    ous.writeObject(it.next());
                }

            }
            ous.close();

        } catch (IOException ex) {
            System.out.println("Fichero no encontrado");
        }
    }

    public static GestionNotas cargarListaNotas() {
        File ficher = new File("listaNotas.dat");
        GestionNotas gestora = new GestionNotas();

        try {
            FileInputStream flujosalida = new FileInputStream(ficher);
            ObjectInputStream ois = new ObjectInputStream(flujosalida);
            boolean salir = false;
           while (salir == false) {
                try{
                Object aux = ois.readObject();
                if (aux != null) {
                   gestora.AñadirNotas((Notas) aux);
                }
                }catch (EOFException ex) {
                    salir=true;
                    System.out.println("Se ha alcanzado el final de fichero");
                }    
            }        
            ois.close();

        } catch (IOException ex) {
            System.out.println("Error de lectura");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException");
        }
        return gestora;
    }
     public static void grabarListaProfesores(ArrayList lista) {
        File ficher = new File("listaProfesores.dat");
        try {
            FileOutputStream flujosalida = new FileOutputStream(ficher);
            ObjectOutputStream ous = new ObjectOutputStream(flujosalida);
            Iterator it = lista.iterator();
            for (int i = 0; i < lista.size(); i++) {
                if (it.hasNext()) {
                    ous.writeObject(it.next());
                }
            }
            ous.close();

        } catch (IOException ex) {
            System.out.println("Fichero no encontrado");
        }
    }

    public static GestionProfesores cargarListaProfesores() {
        File ficher = new File("listaProfesores.dat");
        GestionProfesores gestora = new GestionProfesores();

        try {
            FileInputStream flujosalida = new FileInputStream(ficher);
            ObjectInputStream ois = new ObjectInputStream(flujosalida);
            boolean salir = false;
            while (salir == false) {
                try{
                Object aux = ois.readObject();
                if (aux != null) {
                   gestora.AñadirProfesor((Profesor) aux);
                }
                }catch (EOFException ex) {
                    salir=true;
                    System.out.println("Se ha alcanzado el final de fichero");
                }    
            }
            ois.close();
        } catch (IOException ex) {
            System.out.println("Error de lectura");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException");
        }
        return gestora;
    }
         public static void grabarListaAsignaturas(HashMap lista) {

        File ficher = new File("listaAsignaturas.dat");
        try {
            FileOutputStream flujosalida = new FileOutputStream(ficher);
            PrintWriter pw = new PrintWriter(flujosalida);
            Set listaux = lista.keySet();
            Iterator it = listaux.iterator();
            for (int i = 0; i < lista.size(); i++) {
                if (it.hasNext()) {
                    String aux = (String)it.next();
                    pw.write(aux);
                    pw.write(";");
                    pw.write((String)lista.get(aux));
                    pw.write(";");
                }
            }
            pw.close();
        } catch (IOException ex) {
            System.out.println("Fichero no encontrado");
        }
    }

        public static GestionAsignaturas cargarListaAsignaturas() {
        File ficher = new File("listaAsignaturas.dat");
        GestionAsignaturas gestora = new GestionAsignaturas();

        try {
            
            FileReader fr = new FileReader(ficher);
            BufferedReader br = new BufferedReader (fr);
            boolean salir = false;
            String x = br.readLine();
            
            String[]list = x.split(";");
           
            
            for(int i = 0;i < list.length;i++ ){
                
                gestora.añadirAsignatura(list[i],list[i+1]);
                i++;
                          
            }
           
           

        } catch (IOException ex) {
            System.out.println("Error de lectura");
        }

        return gestora;
    }
}
