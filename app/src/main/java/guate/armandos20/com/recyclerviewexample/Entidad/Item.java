package guate.armandos20.com.recyclerviewexample.Entidad;

public class Item {
    public String titulo;
    public String descripcion;
    public boolean activo;

    public Item() {
    }

    public Item(String titulo, String descripcion, boolean activo) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.activo = activo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isActivo(){
        return activo;
    }

    @Override
    public String toString() {
        return "Item{" +
                "titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
