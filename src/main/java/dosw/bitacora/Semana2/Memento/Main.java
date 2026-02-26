package dosw.bitacora.Semana2.Memento;

public class Main {

    public static void main(String[] args) {

        EditorTexto editor = new EditorTexto();
        Historial historial = new Historial();

        editor.escribir("Hola");
        historial.guardar(editor.guardar());

        editor.escribir("Hola Mundo");
        historial.guardar(editor.guardar());

        editor.escribir("Hola Mundo!!!");

        System.out.println("Texto actual: " + editor.getContenido());


        editor.restaurar(historial.deshacer());
        System.out.println("Despues de deshacer: " + editor.getContenido());

        editor.restaurar(historial.deshacer());
        System.out.println("Despues de deshacer otra vez: " + editor.getContenido());
    }
}