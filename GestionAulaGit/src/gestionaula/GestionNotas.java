/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionaula;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;
import javax.swing.text.html.HTMLDocument;

/**
 *
 * @author Miguy
 */
public class GestionNotas {

    public ArrayList<Notas> listaNotas = new ArrayList<>();

    public void AñadirNotas(Notas nota) {

        listaNotas.add(nota);
    }

    public ArrayList<Notas> getListaNotas() {
        return listaNotas;
    }

    public void ListarNotas() {
        System.out.println("------ Lista de Notas ----");
        for (int i = 0; i < listaNotas.size(); i++) {
            System.out.println(listaNotas.get(i).toString());

        }
    }

    public void BuscarPorAlumno(Alumno alumno) {

        System.out.println("Consulta de notas del alumno " + alumno.getNombre() + "  " + alumno.getApellido());

        for (int i = 0; i < listaNotas.size(); i++) {

            if (listaNotas.get(i).getAlumno().getDni().equals(alumno.getDni())) {
               
                System.out.println(listaNotas.get(i).InformeNotas());
            }

        }
    }

    public Notas BuscarPorId(int id) {
        boolean salir = false;
        Notas nota = null;

        for (int i = 0; i < listaNotas.size() && !salir; i++) {

            if (listaNotas.get(i).getIdnota() == id) {
                nota = listaNotas.get(i);
                salir = true;

            }

        }
        return nota;
    }

    public void RankingNotas(int ranking) {
        System.out.println("------ top  " + ranking + " de notas ------");

        TreeSet<Notas> ordenada = new TreeSet<>(listaNotas);

        Iterator<Notas> it = ordenada.iterator();

        for (int i = 0; i < ranking; i++) {
            if (it.hasNext()) {
                System.out.println(it.next().toString());
            }
        }

    }

    public void BorrarNotas(Notas nota) {
        boolean salir = false;

        for (int i = 0; i < listaNotas.size() && !salir; i++) {

            if (listaNotas.get(i).getIdnota() == nota.getIdnota()) {
                listaNotas.remove(i);
                salir = true;
            }
        }
    }
}
