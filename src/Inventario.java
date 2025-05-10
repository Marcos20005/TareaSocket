
public class Inventario {
int cantidad;
String nombre;
String descripcion;
String codigo;
public Inventario(int cantidad, String nombre, String descripcion, String codigo) {
    this.cantidad = cantidad;
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.codigo = codigo;
}

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

}
