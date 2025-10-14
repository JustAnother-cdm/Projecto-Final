import java.time.LocalDate;

abstract class Persona {
    protected String nombre;
    protected String cedula;
    protected LocalDate fechaNacimiento;

    protected Persona(String nombre, String cedula, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.fechaNacimiento = fechaNacimiento;
    }

    protected String getNombre() {
        return nombre;
    }
    protected String getCedula() {
        return cedula;
    }
    protected LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    protected void setNombre(String nombre) {
        this.nombre = nombre;
    }
    protected void setCedula(String cedula) {
        this.cedula = cedula;
    }
    protected void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
