package cl.inacap.veterinarialaselva.model.dto;

import java.sql.Date;
import java.util.Calendar;

/**
 *
 * @author marcelo
 */
public class Animal {
    private int id;
    private String nombre;
    private int foto;
    private String especie;
    private String raza;
    private Date nacimiento;
    private Boolean vacuna;

    public Animal() {
    }
    public Animal(int id, String nombre, int foto, Date nacimiento)
    {
        this.id = id;
        this.nombre = nombre;
        this.foto = foto;
        this.nacimiento = nacimiento;
    }
    public Animal(int id, String nombre, int foto, String especie, String raza, Date nacimiento, Boolean vacuna) {
        this.id = id;
        this.nombre = nombre;
        this.foto = foto;
        this.especie = especie;
        this.raza = raza;
        this.nacimiento = nacimiento;
        this.vacuna = vacuna;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    public Boolean getVacuna() {
        return vacuna;
    }

    public void setVacuna(Boolean vacuna) {
        this.vacuna = vacuna;
    }

    public int getEdad()
    {
        int edad = 0;

        return edad;
    }

    @Override
    public String toString() {
        return "Animal{" + "id=" + id + ", nombre=" + nombre + ", foto=" + foto + ", especie=" + especie + ", raza=" + raza + ", nacimiento=" + nacimiento + ", vacuna=" + vacuna + '}';
    }
}

