/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionaula;

import java.util.Scanner;

/**
 *
 * @author dam1
 */
public class Menu {

    public static boolean Usuario() {
        Scanner lector = new Scanner(System.in);
        boolean salir = false;
        boolean id = false;
        while (!salir) {
            System.out.println("Introduce 1: si eres profesor, 2: si eres alumno");

            int op = lector.nextInt();

            if (op != 1 && op != 2) {
                System.out.println("Opcion no válida,");
            } else {
                salir = true;
                if (op == 1) {
                    id = true;
                }
            }
        }
        return id;
    }

    public static Sesion IdentificarAlumno(GestionAlumno gestora) {
        Scanner lector = new Scanner(System.in);
        System.out.println("Introduce tu DNI");
        String dni = lector.nextLine();

        System.out.println("Introduce tu contraseña");
        String contraseña = lector.nextLine();
        Sesion sesion = null;
        if (gestora.BuscarPorDni(dni).getDni().equals(dni)) {

            if (gestora.BuscarPorDni(dni).getContraseña().equals(contraseña)) {

                System.out.println("USUARIO CORRECTO");
                sesion = new Sesion(dni);
            } else {
                System.out.println("CONTRASEÑA INCORRECTA");
            }
        } else {
            System.out.println("DNI NO VÁLIDO");
        }
        return sesion;
    }

    public static void MenuAlumno(Sesion usuario, GestionNotas gestorn, GestionAlumno gestora) {
        Scanner lector = new Scanner(System.in);
        System.out.println("Que deseas hacer: ");
        System.out.println("1: Ver tus notas");
        System.out.println("2: Ver horario");
        int op = lector.nextInt();
        if (op == 1) {
            gestorn.BuscarPorAlumno(gestora.BuscarPorDni(usuario.getDni()));

        } else {

        }

    }

    public static void MenuProfesor(GestionNotas gestorn, GestionAlumno gestora, GestionAsignaturas gestasig) {

        Scanner lector = new Scanner(System.in);
        System.out.println("Que deseas hacer: ");
        System.out.println("1: Gestionar Notas");
        System.out.println("2: Gestionar Alumno");
        System.out.println("3: Gestionar Horario");
        int op = lector.nextInt();

        switch (op) {
            case 1:
                Menu.MenuNotas(gestorn, gestora, gestasig);
                break;
            case 2:
                Menu.MenuGestionAlumno(gestorn, gestora, gestasig);
                break;

            default:
                System.out.println("Opción no válida");

        }

    }

    public static void MenuGestionAlumno(GestionNotas gestorn, GestionAlumno gestora, GestionAsignaturas gestasig) {
        Scanner lector = new Scanner(System.in);
        System.out.println("Que deseas hacer: ");
        System.out.println("1: Dar de alta a un alumno ");
        System.out.println("2: Dar de baja a un alumno ");
        System.out.println("3: Modificar un alumno ");
        int op = lector.nextInt();

        switch (op) {
            case 1:
                System.out.println("Introduce el dni del nuevo alumno");
                String dni = lector.next();
                System.out.println("Intoduce el nombre");
                String nombre = lector.next();
                System.out.println("Introduce el apellido");
                String apellido = lector.next();
                System.out.println("Introduce la contraseña");
                String contraseña = lector.next();
                Alumno alumno = new Alumno(nombre, apellido, dni, contraseña);

                gestora.AñadirAlumno(alumno);
                System.out.println("ALumno creado");
            case 2:
                System.out.println("Introduce el dni del alumno que desea dar de baja");
                String dnialumno = lector.next();
                gestora.BorrarAlumno(gestora.BuscarPorDni(dnialumno));
                System.out.println("Alumno borrado");
                break;
            case 3:
                

        }

    }
    
    public static void MenuModificarAlumno(GestionNotas gestorn, GestionAlumno gestora, GestionAsignaturas gasig){
    Scanner lector = new Scanner(System.in);
        System.out.println("Introduce el dni del alumno que desea modificar");
        String dni = lector.next();
        
    
    }

    public static void MenuNotas(GestionNotas gestorn, GestionAlumno gestora, GestionAsignaturas gasig) {

        Scanner lector = new Scanner(System.in);
        System.out.println("Que deseas hacer: ");
        System.out.println("1: Ver Notas de un Alumno ");
        System.out.println("2: Ver Ranking de Notas ");
        System.out.println("3: Modificar Notas ");
        System.out.println("4: Añadir Nota");
        System.out.println("5: Borrar Nota");

        int op = lector.nextInt();

        switch (op) {
            case 1:
                System.out.println("Introduce el DNI del alumno que desea buscar: ");
                gestorn.BuscarPorAlumno(gestora.BuscarPorDni(lector.next()));
                break;
            case 2:
                gestorn.RankingNotas(5);
                break;

            case 3:
                ModificarNota(gestorn, gestora);
                break;

            case 4:
                System.out.println("Introduce el id de la Nota (no debe estar repetido)");
                int id = lector.nextInt();
                if (gestorn.BuscarPorId(id) == null) {
                    System.out.println("Introduce el dni del Alumno");
                    String dni = lector.next();
                    Alumno alumno = gestora.BuscarPorDni(dni);
                    System.out.println("Introduce la asignatura");
                    String asignatura = lector.next();
                    System.out.println("Introduce el trimestre");
                    int trimestre = lector.nextInt();
                    System.out.println("Introduce la calificacion");
                    int calificacion = lector.nextInt();
                    Notas nuevanota = new Notas(calificacion, alumno, asignatura, id, trimestre);
                    gestorn.AñadirNotas(nuevanota);

                }
            case 5:
                System.out.println("Introduce el id de la nota que desea borrar");
                gestorn.BorrarNotas(gestorn.BuscarPorId(lector.nextInt()));
                break;

            default:
                System.out.println("Opción no válida");

        }
    }

    public static void ModificarNota(GestionNotas gestorn, GestionAlumno gestora) {

        Scanner lector = new Scanner(System.in);
        System.out.println("Introduce el id de la Nota que desea Modificar");
        int id = lector.nextInt();

        Notas nota = gestorn.BuscarPorId(id);
        System.out.println(nota.InformeNotas());
        System.out.println("Que campo desea modificar: ");
        System.out.println("1: Cambiar el alumno");
        System.out.println("2: Cambiar asignatura ");
        System.out.println("3: Cambiar trimestre ");
        System.out.println("4: Cambiar la calificación");

        int op2 = lector.nextInt();
        lector.nextLine();
        switch (op2) {
            case 1:

                System.out.println("Introduce el dni del alumno");

                String dni = lector.nextLine();
                System.out.println("El dni es" + dni);

                nota.setAlumno(gestora.BuscarPorDni(dni));
                break;
            case 2:
                System.out.println("Introduce la asignatura");
                String asignatura = lector.nextLine();
                nota.setAsignatura(asignatura);
                break;
            case 3:
                System.out.println("Introduce el trimestre");
                int trimestre = lector.nextInt();
                nota.setFecha(trimestre);
                gestorn.ListarNotas();
                break;
            case 4:
                System.out.println("Introduce la calificacion");
                int calificacion = lector.nextInt();
                nota.setCalificacion(calificacion);
                break;
            default:
                System.out.println("Opción no válida");
        }
    }

    public static void MenuGestionAlumno(GestionNotas gestorn, GestionAlumno gestora) {

        Scanner lector = new Scanner(System.in);
        System.out.println("Que dato desea modificar: ");
        System.out.println("1: Dar de alta; ");
        System.out.println("2: Dar de baja; ");
        System.out.println("3: Modificar alumno; ");
        int op = lector.nextInt();
        switch (op) {
            case 1:
                System.out.println("Introduce el nombre del nuevo alumno");
                String nombre = lector.nextLine();
                System.out.println("Introduce el apellido");
                String apellido = lector.nextLine();
                System.out.println("Introduce el dni");
                String dni = lector.nextLine();
                System.out.println("Por último introduce la contraseña");
                String contraseña = lector.nextLine();

                Alumno nuevo = new Alumno(nombre, apellido, dni, contraseña);
                gestora.AñadirAlumno(nuevo);
                System.out.println("Usuario creado y añadido a la lista de alumnos");
                break;
            case 2:
                System.out.println("Introduce el dni del alumno que desea dar de baja");
                String dnialumno = lector.next();
                gestora.BorrarAlumno(gestora.BuscarPorDni(dnialumno));
                System.out.println("Alumno borrado");
                break;
            case 3:
                System.out.println("");
            default:
                System.out.println("Opción no válida");

        }
    }
}
