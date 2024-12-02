package Veterinaria_Consola;

public abstract class Animal implements Comportamiento {
    private String nombre;
    private int edad;
    private double peso;
    

    public Animal() {
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

    public double  getPeso(){
        return peso;
    }
    public void setPeso(double peso){
        this.peso = peso;
    }
}
