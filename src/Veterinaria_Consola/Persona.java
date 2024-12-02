package Veterinaria_Consola;

public abstract class Persona {
    private int DNI;
    private String Nombre;
    private String Apellido;


    public Persona(){
    }

    public int Get_dni(){
        return DNI;
    }
    public void Set_dni(int DNI){
        this.DNI = DNI;
    }
    public String Get_nombre(){
        return Nombre;
    }
    public void Set_Nombre(String Nombre){
        this.Nombre = Nombre;
    }
    public String Get_apellido(){
        return Apellido;
    }
    public void Set_apellido(String Apellido){
        this.Apellido = Apellido;
    }
}
