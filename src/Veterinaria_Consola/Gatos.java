package Veterinaria_Consola;

public class Gatos extends Animal implements Comportamiento, Comparable<Gatos>{
    private Clientes duenio;
    private String diagnostico;

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
    public void comunicarse() {
        System.out.println("Maulla");
    }

    @Override
    public void movimiento() {
        System.out.println("");
    }

    @Override
    public void alimentarse() {
        System.out.println("");
    }

    @Override
    public String toString(){
        return  "me llamo " + getNombre(); 
    }

    @Override
    public boolean equals(Object gato) {
        if ((gato instanceof Gatos) && (((Gatos) gato).getNombre().equals(super.getNombre())))
            return true;
        else
            return false;
    }

    @Override
    public int compareTo(Gatos o) {

        Gatos d = o;

        return this.getNombre().compareTo(d.getNombre());

    }

}
