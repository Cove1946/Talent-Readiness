package dosw.bitacora.Semana1.streams.ejercicio5;


public class user {

    int id;
    String name;
    int age;
    boolean active;

    public user(int id, String name, int age, boolean active) {
        this.active = active;
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public boolean isActive() {
        return active;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}