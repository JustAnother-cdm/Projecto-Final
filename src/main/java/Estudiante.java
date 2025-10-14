import java.time.LocalDate;

public class Estudiante extends Persona {

    public Estudiante(String nombre, String cedula, LocalDate fechaNacimiento) {
        super(nombre, cedula, fechaNacimiento);
    }

    public void actualizarDatos(String nombre, String cedula, LocalDate fechaNacimiento) {
        setNombre(nombre);
        setCedula(cedula);
        setFechaNacimiento(fechaNacimiento);
    }
}
