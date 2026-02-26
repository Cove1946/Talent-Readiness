package dosw.bitacora.Semana2.Memento;

public class EditorTexto {

    private String contenido;

    public EditorTexto() {
        this.contenido = "";
    }

    public void escribir(String texto) {
        this.contenido = texto;
    }

    public String getContenido() {
        return contenido;
    }

    public Memento guardar() {
        return new Memento(contenido);
    }

    public void restaurar(Memento memento) {
        this.contenido = memento.getEstado();
    }
}









