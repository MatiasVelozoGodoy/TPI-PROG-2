package Veterinaria_Consola;

public class Perros extends Animal implements  Comportamiento, Comparable<Perros>{
    private String tamaño;
    private boolean vacunado;
    private String diagnostico;
    private Clientes duenio;
    

    public Perros(){                
    }
    @Override
    public void comunicarse() {
        System.out.println("Ladra");
        
    }

    @Override
    public void movimiento() {
        System.out.println("");
    }

    @Override
    public void alimentarse() {
        System.out.println("");
    }

    public String getTamaño(){
        return tamaño;
    }
    public void setTamaño(String tamaño){
        this.tamaño = tamaño;
    }

    public boolean getVacunado(){
        return vacunado;
    }
    public void setVacunado(boolean vacunado){
        this.vacunado = vacunado;
    }
    public void setDuenio(Clientes duenio){
        this.duenio = duenio;
    }
    public Clientes getDuenio(){
        return duenio;
    }
    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    @Override
    public String toString(){
        String vacuna = (vacunado == true) ? " estoy vacunado " : " no estoy vacunado ";
        return  "me llamo " + getNombre() + " y" + vacuna; 
    }

    @Override
    public boolean equals(Object perro) {
        if ((perro instanceof Perros) && (((Perros) perro).getNombre().equals(super.getNombre())))
            return true;
        else
            return false;
    }

    @Override
    public int compareTo(Perros o) {

        Perros d = o;

        return this.getNombre().compareTo(d.getNombre());

    }
}
