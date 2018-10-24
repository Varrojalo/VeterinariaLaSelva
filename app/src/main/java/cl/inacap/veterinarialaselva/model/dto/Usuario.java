package cl.inacap.veterinarialaselva.model.dto;

public class Usuario {
    private int id;
    private String nombre;
    private String foto;
    private String contracena;
    private String correo;

    public Usuario() {
    }

    public Usuario(int id, String nombre, String foto, String contracena, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.foto = foto;
        this.contracena = contracena;
        this.correo = correo;
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

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getContracena() {
        return contracena;
    }

    public void setContracena(String contracena) {
        this.contracena = contracena;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", foto=" + foto + ", contracena=" + contracena + ", correo=" + correo + '}';
    }
}

