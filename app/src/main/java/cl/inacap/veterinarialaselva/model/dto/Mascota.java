package cl.inacap.veterinarialaselva.model.dto;

import java.sql.Date;

/**
 *
 * @author marcelo
 */
public class Mascota {
    private Usuario usuario;
    private Animal animal;
    private Date fechaAdopcion;

    public Mascota() {
    }

    public Mascota(Usuario usuario, Animal animal, Date fechaAdopcion) {
        this.usuario = usuario;
        this.animal = animal;
        this.fechaAdopcion = fechaAdopcion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Date getFechaAdopcion() {
        return fechaAdopcion;
    }

    public void setFechaAdopcion(Date fechaAdopcion) {
        this.fechaAdopcion = fechaAdopcion;
    }

    @Override
    public String toString() {
        return "Mascota{" + "usuario=" + usuario.getNombre() + ", animal=" + animal.getRaza() + ", fechaAdopcion=" + fechaAdopcion + '}';
    }
}

