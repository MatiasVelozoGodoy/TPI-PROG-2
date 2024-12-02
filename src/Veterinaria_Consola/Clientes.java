package Veterinaria_Consola;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Clientes extends Persona implements Serializable, Comportamiento, Comparable<Clientes>{

    private String codigoCliente;
    private String direccion;
    private List<Animal> mascota;

    public Clientes(){

    }

    public String Get_codigoCliente() {
        return codigoCliente;
    }

    public void Set_codigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }
        public List<Animal> getMascotas() {
        return mascota;
    }

    @Override
    public void comunicarse(){
        System.out.println("Se comunica menos técnica");
    }


    @Override
    public void movimiento(){
        System.out.println("");
    }

    @Override
    public void alimentarse() {
        System.out.println("");
    }

    @Override
    public  String toString(){
        return Get_nombre() + " " + Get_dni();
    }

    @Override
    public boolean equals(Object  cliente){
        if((cliente instanceof Clientes) && (((Clientes)cliente).Get_dni() == super.Get_dni()))
            return true;
        else
            return false;        
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = hash *  17 * Get_dni();
        hash = hash *  31 * codigoCliente.hashCode();
        return hash;
    }

    @Override
    public int compareTo(Clientes o) {

        Clientes d = o;

        return this.Get_nombre().compareTo(d.Get_nombre());

    }

    public void setMascota(ArrayList<Animal> mascota) {
        this.mascota = mascota;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}
