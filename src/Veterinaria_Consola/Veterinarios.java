package Veterinaria_Consola;

import java.io.Serializable;

public class Veterinarios extends Persona implements Serializable, Comportamiento, Comparable<Veterinarios> {
    private String nroMatricula;
    private String direccion;

    public Veterinarios() {

    }

    public Veterinarios(String nroMatricula) {
        this.nroMatricula = nroMatricula;
    }

    public String Get_nroMatricula() {
        return nroMatricula;
    }

    public void Set_nroMatricula(String nroMatricula) {
        this.nroMatricula = nroMatricula;
    }

    @Override
    public void comunicarse() {
        System.out.println("Se comunica de manera más técnica");

    }

    @Override
    public void movimiento() {
        System.out.println("Camina de manera normal");
    }

    @Override
    public void alimentarse() {
        System.out.println("");
    }

    @Override
    public String toString() {
        return "Me llamo " + Get_nombre(); 
    }

    @Override
    public boolean equals(Object vet) {
        if ((vet instanceof Veterinarios) && (((Veterinarios) vet).Get_dni() == super.Get_dni()))
            return true;
        else
            return false;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = hash * 17 * Get_dni();
        hash = hash * 31 * nroMatricula.hashCode();
        return hash;
    }

    @Override
    public int compareTo(Veterinarios o) {

        Veterinarios d = o;

        return this.Get_nombre().compareTo(d.Get_nombre());

    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
