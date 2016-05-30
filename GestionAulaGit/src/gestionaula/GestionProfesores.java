/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionaula;

import java.util.ArrayList;

/**
 *
 * @author Miguy
 */
public class GestionProfesores {
    
    

    ArrayList<Profesor> listaProfesores = new ArrayList<>();

    public void AñadirProfesor(Profesor profe) {

        listaProfesores.add(profe);
    }

    public ArrayList<Profesor> getListaProfesores() {
        return listaProfesores;
    }

    public void ListarProfesores() {
        System.out.println("------ Lista de Notas ----");
        for (int i = 0; i < listaProfesores.size(); i++) {
            System.out.println(listaProfesores.get(i).toString());

        }
    }

    public void BuscarPorProfesor(Profesor profe) {

        System.out.println("Busqueda de profesor " + profe.getNombre() + "  " + profe.getApellido());

        for (int i = 0; i < listaProfesores.size(); i++) {

            if (listaProfesores.get(i)== profe) {

                System.out.println(listaProfesores.get(i).toString());
            }

        }
    }

    public Profesor BuscarPorDni(String dni) {
        boolean salir = false;
        Profesor profe = null;

        for (int i = 0; i < listaProfesores.size() && !salir; i++) {

            if (listaProfesores.get(i).getDni().equals(dni)) {
                profe = listaProfesores.get(i);
                salir = true;

            }

        }
        return profe;
    }

    

    public void BorrarProfesor(Profesor profe) {
        boolean salir = false;

        for (int i = 0; i < listaProfesores.size() && !salir; i++) {

            if (listaProfesores.get(i).getDni().equals(profe.getDni())) {
                listaProfesores.remove(i);
                salir = true;
            }
        }
    }

}
