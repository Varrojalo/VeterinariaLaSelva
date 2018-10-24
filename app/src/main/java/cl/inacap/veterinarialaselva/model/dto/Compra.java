package cl.inacap.veterinarialaselva.model.dto;

import java.sql.Date;

/**
 *
 * @author marcelo
 */
public class Compra {
    private Usuario usuario;
    private Producto producto;
    private Date fecha;

    public Compra() {
    }

    public Compra(Usuario usuario, Producto producto, Date fecha) {
        this.usuario = usuario;
        this.producto = producto;
        this.fecha = fecha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Compra{" + "usuario=" + usuario.getNombre() + ", producto=" + producto.getNombre() + ", fecha=" + fecha + '}';
    }
}

