package com.example.projectofinal.model;

import javafx.beans.property.*;
import java.time.LocalDate;

public class Profesor {

    private final StringProperty nombre;
    private final StringProperty cedula;
    private final ObjectProperty<LocalDate> fechaNacimiento;
    private final StringProperty especialidad;

    public Profesor(String nombre, String cedula, LocalDate fechaNacimiento, String especialidad) {
        this.nombre = new SimpleStringProperty(nombre);
        this.cedula = new SimpleStringProperty(cedula);
        this.fechaNacimiento = new SimpleObjectProperty<>(fechaNacimiento);
        this.especialidad = new SimpleStringProperty(especialidad);
    }

    public String getNombre() { return nombre.get(); }
    public void setNombre(String n) { nombre.set(n); }
    public StringProperty nombreProperty() { return nombre; }

    public String getCedula() { return cedula.get(); }
    public void setCedula(String c) { cedula.set(c); }
    public StringProperty cedulaProperty() { return cedula; }

    public LocalDate getFechaNacimiento() { return fechaNacimiento.get(); }
    public void setFechaNacimiento(LocalDate f) { fechaNacimiento.set(f); }
    public ObjectProperty<LocalDate> fechaNacimientoProperty() { return fechaNacimiento; }

    public String getEspecialidad() { return especialidad.get(); }
    public void setEspecialidad(String e) { especialidad.set(e); }
    public StringProperty especialidadProperty() { return especialidad; }
}
