/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionaula;

/**
 *
 * @author dam1
 */
public class GestionAula {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /*Alumno alumno1 = new Alumno("Alvaro", "Cabello", "0000A", "A");
        Alumno alumno2 = new Alumno("Dan", "Frimu", "0000B", "B");
        Alumno alumno3 = new Alumno("Daniel", "Calle", "0000C", "C");
        Alumno alumno4 = new Alumno("Jorge", "Dorado", "0000D", "D");
        Alumno alumno5 = new Alumno("Alejandro", "fideo", "0000E", "E");
        Profesor profesor1 = new Profesor("Miguel", "Salazar", "0000F", "F");
        Profesor profesor2 = new Profesor("Gema", "Garcia", "0000G", "G");
        Notas nota1 = new Notas(5, alumno5, "01", 0, 1);
        Notas nota2 = new Notas(6, alumno3, "01", 1, 2);
        Notas nota3 = new Notas(7, alumno4, "02", 3, 3);
        Notas nota4 = new Notas(5, alumno2, "03", 4, 2);
        Notas nota5 = new Notas(6, alumno2, "02", 5, 2);

        
        GestionAsignaturas gasignaturas = new GestionAsignaturas();

        gasignaturas.añadirAsignatura("01", "Matematicas");
        gasignaturas.añadirAsignatura("02", "Lengua");
        gasignaturas.añadirAsignatura("03", "Ingles");
        GestionProfesores gprofe = new GestionProfesores();
        GestionAlumno galumno = new GestionAlumno();

        gprofe.AñadirProfesor(profesor1);
        gprofe.AñadirProfesor(profesor2);
        GestionNotas gnotas = new GestionNotas();
        galumno.AñadirAlumno(alumno5);
        galumno.AñadirAlumno(alumno4);
        galumno.AñadirAlumno(alumno3);
        galumno.AñadirAlumno(alumno2);
        galumno.AñadirAlumno(alumno1);

        gnotas.AñadirNotas(nota5);
        gnotas.AñadirNotas(nota4);
        gnotas.AñadirNotas(nota3);
        gnotas.AñadirNotas(nota2);*/
        GestionAsignaturas gasignaturas = Ficheros.cargarListaAsignaturas();
        GestionAlumno galumno = Ficheros.cargarListaAlumnos();
        GestionNotas gnotas = Ficheros.cargarListaNotas();
        GestionProfesores gprofe = Ficheros.cargarListaProfesores();
        
        System.out.println(gnotas.getListaNotas().size());
        System.out.println(gnotas.getListaNotas().get(0));

        gnotas.ListarNotas();
        gnotas.RankingNotas(4);

        galumno.ListarAlumnos();
        galumno.BuscarPorDni("0000B").toString();

        if (!Menu.Usuario()) {

            Menu.MenuAlumno(Menu.IdentificarAlumno(galumno), gnotas, galumno);

        } else {
            Menu.MenuProfesor(gnotas, galumno, gasignaturas);
        }
        Ficheros.grabarListaNotas(gnotas.getListaNotas());
        Ficheros.grabarListaAlumnos(galumno.getListaAlumnos());
        Ficheros.grabarListaProfesores(gprofe.getListaProfesores());
        Ficheros.grabarListaAsignaturas(gasignaturas.getListaAsignaturas());

    
    }

}
