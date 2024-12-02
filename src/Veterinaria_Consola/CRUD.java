package Veterinaria_Consola;


public interface CRUD {

    public void cargarPerro();
    public void cargarCliente();
    public void cargarClienteConMascota(Clientes cliente);
    public void cargarGato();

    public void modificarCliente();
    public void modificarGato();
    public void modificarPerro();
    public void modificarVeterinario();

    public void mostrarCliente();
    public void mostrarGato();
    public void mostrarPerro();
    public void mostrarVeterinario();
    public void mostrarTodo();

    public void eliminarCliente();
    public void eliminarGato();
    public void eliminarPerro();
    public void eliminarVeterinario();
    public void eliminarTodo();
}
