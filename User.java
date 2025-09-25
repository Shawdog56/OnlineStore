package OnlineShop;

import java.io.Serializable;

public class User  implements Serializable{
    private String nombre;
    private int edad;

    public User(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "{nombre:" + nombre + ",\nedad:" + edad + "}";
    }
}
