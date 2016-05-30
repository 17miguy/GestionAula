


package gestionaula;

import java.util.Iterator;
import java.util.TreeSet;

/**
 *
 * @author dam1
 */
public class GestionAlumno {

    protected TreeSet<Alumno> listaAlumnos = new TreeSet<>();

    public TreeSet<Alumno> getListaAlumnos() {
        return listaAlumnos;
    }
    protected void AñadirAlumno(Alumno alumno) {
        listaAlumnos.add(alumno);
    }
    protected void BorrarAlumno(Alumno alumno) {
        if (!listaAlumnos.remove(alumno)) {
            System.out.println("El alumno no existe");
        } else {
            System.out.println("Se ha borrado correctamente");
        }
    }
    protected void ListarAlumnos() {
        Iterator it = listaAlumnos.iterator();
        System.out.println("------ Lista de Alumnos ----");
        for (int i = 0; i < listaAlumnos.size(); i++) {
            if (it.hasNext()) {
                System.out.println(it.next());
            }
        }
    }
    public Alumno BuscarPorDni(String dni) {
        Iterator<Alumno> it = listaAlumnos.iterator();
        boolean salir = false;
        int contador = -1;
        Alumno aux = null;
        while (!salir) {
            if (it.hasNext()) {
                aux = it.next();
                if (aux.getDni().equals(dni)) {
                    salir = true;                   
                }
            } else {
                System.out.println("alumno no encontrado");
                salir = true;
            }
        }       
        return aux;
    }
}
