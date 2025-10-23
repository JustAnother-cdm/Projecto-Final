import java.time.LocalDate;
import java.util.ArrayList;

public class Estudiante extends Persona {

    private String matricula;
    public String [][] horario = new String [7][4];
    public ArrayList<Boolean> Asistencia;
    public String progreso;



    public Estudiante(String nombre, String cedula, LocalDate fechaNacimiento, String matricula, String[][] horario, ArrayList<Boolean> Asistencia, String progreso) {
        super(nombre, cedula, fechaNacimiento);
        this.Asistencia = Asistencia;
        this.horario = horario;
        this.matricula = matricula;
        this.progreso = progreso;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String[][] getHorario() {
        return horario;
    }

    public void setHorario(String[][] horario) {
        this.horario = horario;
    }

    public ArrayList<Boolean> getAsistencia() {
        return Asistencia;
    }

    public void setAsistencia(ArrayList<Boolean> asistencia) {
        Asistencia = asistencia;
    }

    public String getProgreso() {
        return progreso;
    }

    public void setProgreso(String progreso) {
        this.progreso = progreso;
    }

    public void actualizarDatos(String nombre, String cedula, LocalDate fechaNacimiento, String matricula, String[][] horario, ArrayList<Boolean> Asistencia, String progreso) {
        setNombre(nombre);
        setCedula(cedula);
        setFechaNacimiento(fechaNacimiento);
        setAsistencia(Asistencia);
        setMatricula(matricula);
        setHorario(horario);
        setProgreso(progreso);
    }

    public String [][] consultarHorario() {
        return getHorario();
    }

}
