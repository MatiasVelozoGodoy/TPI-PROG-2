package Veterinaria_Consola;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import javax.swing.text.DefaultEditorKit;

public class Menu implements CRUD {
    private Clientes cliente;
    private Veterinarios vete;
    private Perros perro;
    private HashSet<Integer> dnisRegistrados = new HashSet<>();
    private List<Clientes> clientes = new ArrayList<Clientes>();
    private List<Veterinarios> veterinarios = new ArrayList<Veterinarios>();
    private List<Perros> perros = new ArrayList<Perros>();
    private List<Gatos> gatos = new ArrayList<Gatos>();
    private int opcionMenuPrincipal;
    private int opcionMenuSecundario;
    private Scanner lector = new Scanner(System.in);

    public Menu() {
        cargarDnisDesdeArchivo();

    }

    // #region menu
    public void mostrarMenu() {
        do {
            System.out.println("\n--- Menú de Gestión de Mascota ---");
            System.out.println("1. Agregar");
            System.out.println("2. Modificar");
            System.out.println("3. Eliminar");
            System.out.println("4. Mostrar");
            System.out.println("5. Salir");
            System.out.println();
            System.out.print("Seleccione una opción: ");

            try {
                opcionMenuPrincipal = lector.nextInt();

                switch (opcionMenuPrincipal) {
                    case 1: // case para agregar
                        System.out.println("\n1. Agregar Perro");
                        System.out.println("2. Agregar Gato");
                        System.out.println("3. Agregar Cliente");
                        System.out.println("4. Agregar Veterinario");
                        System.out.println("5. Volver");
                        System.out.println();
                        System.out.print("Seleccione una opción: ");
                        opcionMenuSecundario = lector.nextInt();
                        lector.nextLine();

                        switch (opcionMenuSecundario) {
                            case 1:
                                cargarPerro();
                                System.out.println();
                                break;
                            case 2:
                                cargarGato();
                                System.out.println();
                                break;
                            case 3:
                                cargarCliente();
                                System.out.println();
                                break;
                            case 4:
                                cargarVeterinario();
                                System.out.println();
                                break;
                            case 5:
                                break;
                            default:
                                System.out.println("\n============================================");
                                System.out.println("     Opción no válida en el submenú.");
                                System.out.println("============================================\n");
                        }
                        break;

                    case 2: // case para modificar

                        System.out.println("\n1. Modificar Perro");
                        System.out.println("2. Modificar Gato");
                        System.out.println("3. Modificar Dueño");
                        System.out.println("4. Modificar Veterinario");
                        System.out.println("5. Volver");
                        System.out.println();
                        System.out.print("Seleccione una opción: ");
                        opcionMenuSecundario = lector.nextInt();
                        lector.nextLine();

                        switch (opcionMenuSecundario) {
                            case 1:
                                modificarPerro();
                                System.out.println();
                                break;
                            case 2:
                                modificarGato();
                                System.out.println();
                                break;
                            case 3:
                                modificarCliente();
                                System.out.println();
                                break;
                            case 4:
                                modificarVeterinario();
                                System.out.println();
                                break;
                            case 5:
                                break;
                            default:
                                System.out.println("\n============================================");
                                System.out.println("      Opción no válida en el submenú.");
                                System.out.println("============================================\n");
                        }

                        break;

                    case 3: // case para eliminar
                        System.out.println("\n1. Eliminar Perro");
                        System.out.println("2. Eliminar Gato");
                        System.out.println("3. Eliminar Dueño");
                        System.out.println("4. Eliminar Veterinario");
                        System.out.println("5. Eliminar Todo");
                        System.out.println("6. Volver");
                        System.out.println();
                        System.out.print("Seleccione una opción: ");
                        opcionMenuSecundario = lector.nextInt();
                        lector.nextLine();

                        switch (opcionMenuSecundario) {
                            case 1:

                                eliminarPerro();
                                System.out.println();
                                break;
                            case 2:
                                eliminarGato();
                                System.out.println();
                                break;
                            case 3:
                                eliminarCliente();
                                System.out.println();
                                break;
                            case 4:
                                eliminarVeterinario();
                                System.out.println();
                                break;
                            case 5:
                                System.out.println(
                                        "\nEsta opción no tiene vuelta atrás. ¿Está seguro de eliminar todo? S/N");
                                String opcion = lector.nextLine().toUpperCase();
                                switch (opcion) {
                                    case "S":
                                        eliminarTodo();
                                        break;
                                    case "N":
                                        System.out.println("\nVolviendo al menú\n");
                                        break;
                                    default:
                                        System.out.println("\nOpción incorrecta\n");
                                }
                                break;
                            case 6:
                                break;
                            default:
                                System.out.println("\n============================================");
                                System.out.println("Opción no válida en el submenú.");
                                System.out.println("============================================\n");
                                // }
                        }
                        break;

                    case 4: // case para mostrar

                        System.out.println("\n1. Mostrar Perro");
                        System.out.println("2. Mostrar Gato");
                        System.out.println("3. Mostrar Cliente");
                        System.out.println("4. Mostrar Veterinario");
                        System.out.println("5. Mostrar Todo");
                        System.out.println("6. Volver");
                        System.out.println();
                        System.out.print("Seleccione una opción: ");
                        opcionMenuSecundario = lector.nextInt();
                        lector.nextLine();

                        switch (opcionMenuSecundario) {
                            case 1:

                                mostrarPerro();
                                System.out.println();
                                break;
                            case 2:
                                mostrarGato();
                                System.out.println();
                                break;
                            case 3:
                                mostrarCliente();
                                System.out.println();
                                break;
                            case 4:
                                mostrarVeterinario();
                                System.out.println();
                                break;
                            case 5:
                                mostrarTodo();
                                System.out.println();
                                break;
                            case 6:
                                break;
                            default:
                                System.out.println("\n============================================");
                                System.out.println("      Opción no válida en el submenú.");
                                System.out.println("============================================\n");
                        }
                        break;

                    case 5: // case para cerrar el programa
                        System.out.println("\nCerrando el programa...\n");
                        System.out.println("********************************************");
                        System.out.println("                Cerrado con éxito.");
                        System.out.println("********************************************\n");
                        break;

                    default:
                        System.out.println("\n********************************************");
                        System.out.println("     Opción no válida. Intente de nuevo.");
                        System.out.println("********************************************\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("\n********************************************");
                System.out.println("      Entrada inválida. Ingrese un número.");
                System.out.println("********************************************\n");
                lector.nextLine();
            }
        } while (opcionMenuPrincipal != 5);
    }
    // #endregion

    // #region agregar
    @Override
    public void cargarPerro() {
        Perros perro = new Perros();
        System.out.println();

        System.out.println("Dime la edad del perro");
        while (!lector.hasNextInt()) {
            System.out.println("Por favor, ingresa un número entero para la edad:");
            lector.next();
        }
        perro.setEdad(lector.nextInt());

        System.out.println("Dime el peso del perro en kg");
        while (!lector.hasNextDouble()) {
            System.out.println("Por favor, ingresa un número válido (entero o decimal) para el peso:");
            lector.next();
        }
        perro.setPeso(lector.nextDouble());

        lector.nextLine();

        System.out.println("Dime el nombre del perro");
        perro.setNombre(lector.nextLine());

        System.out.println("Dime el diagnostico del perro");
        perro.setDiagnostico(lector.nextLine());

        System.out.println("Dime el DNI del dueño del perro");
        while (!lector.hasNextInt()) {
            System.out.println("Por favor, ingresa un número entero válido para el DNI:");
            lector.next();
        }

        int dni = lector.nextInt();

        Clientes duenio;
        if (dnisRegistrados.contains(dni)) {
            duenio = buscarClientePorDni(dni);
        } else {
            System.out.println();
            System.out.println("No existe dueño de la mascota. Por favor, registre un nuevo cliente.");
            System.out.println();
            duenio = new Clientes();
            cargarClienteConMascota(duenio);
            dnisRegistrados.add(dni);
        }

        perro.setDuenio(duenio);

        if (duenio.getMascotas() == null) {
            duenio.setMascota(new ArrayList<>());
        }

        duenio.getMascotas().add(perro);
        perros.add(perro);

        try (FileWriter escritura = new FileWriter("Veterinaria.txt", true);) {
            escritura.write("Mascota: Perro\n");
            escritura.write("Nombre: " + perro.getNombre() + "\n");
            escritura.write("Edad: " + perro.getEdad() + "\n");
            escritura.write("Peso: " + perro.getPeso() + "\n");
            escritura.write("Diagnostico: " + perro.getDiagnostico() + "\n");
            escritura.write("Dueño: " + perro.getDuenio().toString() + "\n");
            escritura.write("\n");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al guardar los datos del perro: " + e.getMessage());
        }

        System.out.println();
        System.out.println("El perro ha sido registrado exitosamente con su dueño.");
        System.out.println();
    }

    @Override
    public void cargarGato() {
        Gatos gato = new Gatos();
        System.out.println();

        System.out.println("Dime la edad del gato");
        while (!lector.hasNextInt()) {
            System.out.println("Por favor, ingresa un número entero para la edad:");
            lector.next();
        }
        gato.setEdad(lector.nextInt());

        System.out.println("Dime el peso del gato en kg");
        while (!lector.hasNextDouble()) {
            System.out.println("Por favor, ingresa un número válido (entero o decimal) para el peso:");
            lector.next();
        }
        gato.setPeso(lector.nextDouble());

        lector.nextLine();

        System.out.println("Dime el nombre del gato");
        gato.setNombre(lector.nextLine());

        System.out.println("Dime el diagnostico del gato");
        gato.setDiagnostico(lector.nextLine());

        System.out.println("Dime el DNI del dueño del gato");
        while (!lector.hasNextInt()) {
            System.out.println("Por favor, ingresa un número entero válido para el DNI:");
            lector.next();
        }

        int dni = lector.nextInt();

        Clientes duenio;
        if (dnisRegistrados.contains(dni)) {
            duenio = buscarClientePorDni(dni);
        } else {
            System.out.println();
            System.out.println("No existe dueño de la mascota. Por favor, registre un nuevo cliente.");
            System.out.println();
            duenio = new Clientes();
            cargarClienteConMascota(duenio);
            dnisRegistrados.add(dni);
        }

        gato.setDuenio(duenio);

        if (duenio.getMascotas() == null) {
            duenio.setMascota(new ArrayList<>());
        }

        duenio.getMascotas().add(gato);
        gatos.add(gato);

        try (FileWriter escritura = new FileWriter("Veterinaria.txt", true);) {
            escritura.write("Mascota: Gato\n");
            escritura.write("Nombre: " + gato.getNombre() + "\n");
            escritura.write("Edad: " + gato.getEdad() + "\n");
            escritura.write("Peso: " + gato.getPeso() + "\n");
            escritura.write("Diagnostico: " + gato.getDiagnostico() + "\n");
            escritura.write("Dueño: " + gato.getDuenio().toString() + "\n");
            escritura.write("\n");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al guardar los datos del gato: " + e.getMessage());
        }

        System.out.println();
        System.out.println("El gato ha sido registrado exitosamente con su dueño.");
        System.out.println();
    }

    @Override
    public void cargarCliente() {
        cliente = new Clientes();
        System.out.println();

        System.out.println("Dime el DNI del cliente");
        while (!lector.hasNextInt()) {
            System.out.println("Por favor, ingresa un número entero para el DNI:");
            lector.next();
        }

        int dni;
        while (true) {
            while (!lector.hasNextInt()) {
                System.out.println("Por favor, ingresa un número entero para el DNI:");
                lector.next();
            }

            dni = lector.nextInt();

            if (dnisRegistrados.contains(dni)) {
                System.out.println("Ya existe un cliente con este DNI. Por favor, ingresa un DNI diferente:");
            } else {
                break;
            }
        }

        cliente.Set_dni(dni);
        dnisRegistrados.add(dni);

        lector.nextLine();

        System.out.println("Dime el nombre del cliente");
        cliente.Set_Nombre(lector.nextLine());

        System.out.println("Dime el apellido del cliente");
        cliente.Set_apellido(lector.nextLine());

        System.out.println("Dime el código del cliente");
        cliente.Set_codigoCliente(lector.nextLine());

        System.out.println("Dime la dirección del cliente");
        cliente.setDireccion(lector.nextLine());

        clientes.add(cliente);
        try (FileWriter escritura = new FileWriter("Veterinaria.txt", true);) {
            escritura.write("Codigo Cliente: " + cliente.Get_codigoCliente() + "\n");
            escritura.write("DNI: " + cliente.Get_dni() + "\n");
            escritura.write("Nombre: " + cliente.Get_nombre() + "\n");
            escritura.write("Apellido: " + cliente.Get_apellido() + "\n");
            escritura.write("Dirección: " + cliente.getDireccion() + "\n");
            escritura.write("\n");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al guardar los datos del cliente: " + e.getMessage());
        }

        System.out.println();
        System.out.println("Cliente agregado exitosamente.");
        System.out.println();
    }

    private void cargarVeterinario() {
        Veterinarios veterinario = new Veterinarios();
        System.out.println();

        System.out.println("Dime el DNI del veterinario");
        int dni = lector.nextInt();

        if (dnisRegistrados.contains(dni)) {
            System.out.println("Ya existe un cliente con este DNI.");
            return;
        }

        veterinario.Set_dni(dni);
        dnisRegistrados.add(dni);

        lector.nextLine();

        System.out.println("Dime el nombre del veterinario");
        veterinario.Set_Nombre(lector.nextLine());

        System.out.println("Dime el apellido del veterinario");
        veterinario.Set_apellido(lector.nextLine());

        System.out.println("Dime el número de matrícula del veterinario");
        veterinario.Set_nroMatricula(lector.nextLine());

        System.out.println("Dime la dirección del local del veterinario");
        veterinario.setDireccion(lector.nextLine());

        veterinarios.add(veterinario);
        try (FileWriter escritura = new FileWriter("Veterinaria.txt", true);) {
            escritura.write("Numero de matricula del Veterinario: " + veterinario.Get_nroMatricula() + "\n");
            escritura.write("DNI: " + veterinario.Get_dni() + "\n");
            escritura.write("Nombre: " + veterinario.Get_nombre() + "\n");
            escritura.write("Apellido: " + veterinario.Get_apellido() + "\n");
            escritura.write("Dirección del local: " + veterinario.getDireccion() + "\n");
            escritura.write("\n");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al guardar los datos del cliente: " + e.getMessage());
        }

        System.out.println();
        System.out.println("Veterianrio agregado exitosamente.");
        System.out.println();
    }

    // #endregion
    // #region mostrar
    @Override
    public void mostrarPerro() {
        boolean hayPerro = false;
        try (BufferedReader reader = new BufferedReader(new FileReader("Veterinaria.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Mascota: Perro")) {
                    hayPerro = true;
                    System.out.println();
                    System.out.println(line);

                    System.out.println(reader.readLine());
                    System.out.println(reader.readLine());
                    System.out.println(reader.readLine());
                    System.out.println(reader.readLine());
                    System.out.println(reader.readLine());
                    System.out.println(reader.readLine());
                }
            }
            if (!hayPerro) {
                System.out.println();
                System.out.println("==========================================");
                System.out.println("      No hay perros para mostrar");
                System.out.println("==========================================");
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo: " + e.getMessage());
        }
    }

    @Override
    public void mostrarGato() {
        boolean hayGato = false;
        try (BufferedReader reader = new BufferedReader(new FileReader("Veterinaria.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Mascota: Gato")) {
                    hayGato = true;
                    System.out.println();
                    System.out.println(line);

                    System.out.println(reader.readLine());
                    System.out.println(reader.readLine());
                    System.out.println(reader.readLine());
                    System.out.println(reader.readLine());
                    System.out.println(reader.readLine());
                    System.out.println(reader.readLine());
                }
            }
            if (!hayGato) {
                System.out.println();
                System.out.println("==========================================");
                System.out.println("      No hay gatos para mostrar");
                System.out.println("==========================================");
            }

        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo: " + e.getMessage());
        }
    }

    @Override
    public void mostrarVeterinario() {
        boolean hayVeterinarios = false;
        try (BufferedReader reader = new BufferedReader(new FileReader("Veterinaria.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Numero de matricula del Veterinario:")) {
                    hayVeterinarios = true;
                    System.out.println();
                    System.out.println(line);

                    System.out.println(reader.readLine());
                    System.out.println(reader.readLine());
                    System.out.println(reader.readLine());
                    System.out.println(reader.readLine());

                    System.out.println();
                }
            }
            if (!hayVeterinarios) {
                System.out.println();
                System.out.println("==========================================");
                System.out.println("   No hay veterinarios para mostrar");
                System.out.println("==========================================");
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo: " + e.getMessage());
        }
    }

    @Override
    public void mostrarCliente() {
        boolean hayCliente = false;
        try (BufferedReader reader = new BufferedReader(new FileReader("Veterinaria.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Codigo Cliente: ")) {
                    hayCliente = true;
                    System.out.println();
                    System.out.println(line);
                    System.out.println(reader.readLine());
                    System.out.println(reader.readLine());
                    System.out.println(reader.readLine());
                    System.out.println(reader.readLine());
                }
            }
            if (!hayCliente) {
                System.out.println();
                System.out.println("==========================================");
                System.out.println("    No hay clientes para mostrar");
                System.out.println("==========================================");
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo: " + e.getMessage());
        }
    }

    @Override
    public void mostrarTodo() {

        mostrarPerro();

        mostrarGato();

        mostrarVeterinario();

        mostrarCliente();

    }

    // #endregion
    // #region modificar
    @Override
    public void modificarPerro() {
        System.out.print("Ingrese el nombre actual del perro a modificar: ");

        String rutaArchivo = "Veterinaria.txt";
        String auxFilePath = "Copia.txt";
        String nombrePerro = lector.nextLine();
        boolean registroModificado = false;

        try (
                BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo));
                BufferedWriter writer = new BufferedWriter(new FileWriter(auxFilePath))) {
            String lineaActual;
            boolean esRegistroPerro = false;
            String nombreActual = "";
            String edadActual = "";
            String pesoActual = "";
            String diagnosticoActual = "";

            while ((lineaActual = reader.readLine()) != null) {
                if (lineaActual.startsWith("Mascota:")) {
                    esRegistroPerro = lineaActual.contains("Perro");
                }

                // Si estamos dentro de un registro de perro y encontramos el nombre correcto
                if (esRegistroPerro && lineaActual.startsWith("Nombre:") && lineaActual.contains(nombrePerro)) {
                    System.out.println("Perro encontrado. Puede modificar los siguientes datos:");

                    // Modificar nombre
                    System.out.print("Nuevo nombre (o presione Enter para mantener el actual): ");
                    String nuevoNombre = lector.nextLine();
                    if (nuevoNombre.isEmpty()) {
                        nuevoNombre = lineaActual.split(": ")[1]; // Mantener el nombre actual si se presiona Enter
                    }
                    writer.write("Nombre: " + nuevoNombre + "\n");
                    nombreActual = nuevoNombre; // Actualizar el nombre

                    // Modificar edad
                    System.out.print("Nueva edad (o presione Enter para mantener el actual): ");
                    String nuevaEdad = lector.nextLine();
                    if (nuevaEdad.isEmpty()) {
                        nuevaEdad = lineaActual.split(": ")[1]; // Mantener la edad actual
                    }
                    writer.write("Edad: " + nuevaEdad + "\n");
                    edadActual = nuevaEdad;

                    // Modificar peso
                    System.out.print("Nuevo peso (o presione Enter para mantener el actual): ");
                    String nuevoPeso = lector.nextLine();
                    if (nuevoPeso.isEmpty()) {
                        nuevoPeso = lineaActual.split(": ")[1]; // Mantener el peso actual
                    }
                    writer.write("Peso: " + nuevoPeso + "\n");
                    pesoActual = nuevoPeso;

                    // Modificar diagnóstico
                    System.out.print("Nuevo diagnóstico (o presione Enter para mantener el actual): ");
                    String nuevoDiagnostico = lector.nextLine();
                    if (nuevoDiagnostico.isEmpty()) {
                        nuevoDiagnostico = lineaActual.split(": ")[1]; // Mantener el diagnóstico actual
                    }
                    writer.write("Diagnóstico: " + nuevoDiagnostico + "\n");
                    diagnosticoActual = nuevoDiagnostico;

                    // Saltar el resto del bloque (hasta "Dueño:"), ya que hemos actualizado los
                    // valores
                    while ((lineaActual = reader.readLine()) != null && !lineaActual.startsWith("Dueño:")) {
                        // No escribir el resto de las líneas del registro de este perro
                    }

                    // Escribir "Dueño:" y sus detalles, que no necesitan modificación
                    if (lineaActual != null) {
                        writer.write(lineaActual + "\n");
                    }

                    registroModificado = true;
                    esRegistroPerro = false; // Finalizamos el bloque del perro
                } else {
                    // Si no es el perro que estamos buscando, solo lo escribimos normalmente
                    writer.write(lineaActual + "\n");
                }
            }

            // Informar si no se encontró el perro para modificar
            if (!registroModificado) {
                System.out.println("No se encontró un perro con el nombre especificado.");
            }

        } catch (IOException e) {
            System.err.println("Error durante la modificación: " + e.getMessage());
        }

        // Reemplazar el archivo original con el archivo modificado
        try {
            Files.deleteIfExists(Paths.get(rutaArchivo));
            Files.move(Paths.get(auxFilePath), Paths.get(rutaArchivo));
            System.out.println("El archivo se ha modificado exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al reemplazar el archivo principal: " + e.getMessage());
        }
    }

    @Override
    public void modificarGato() {
        System.out.print("Ingrese el nombre actual del perro a modificar: ");

        String rutaArchivo = "Veterinaria.txt";
        String auxFilePath = "Copia.txt";
        String nombrePerro = lector.nextLine();
        boolean registroModificado = false;

        try (
                BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo));
                BufferedWriter writer = new BufferedWriter(new FileWriter(auxFilePath))) {
            String lineaActual;
            boolean esRegistroPerro = false;
            String nombreActual = "";
            String edadActual = "";
            String pesoActual = "";
            String diagnosticoActual = "";

            while ((lineaActual = reader.readLine()) != null) {
                if (lineaActual.startsWith("Mascota:")) {
                    esRegistroPerro = lineaActual.contains("Gato");
                }

                // Si estamos dentro de un registro de perro y encontramos el nombre correcto
                if (esRegistroPerro && lineaActual.startsWith("Nombre:") && lineaActual.contains(nombrePerro)) {
                    System.out.println("Gato encontrado. Puede modificar los siguientes datos:");

                    // Modificar nombre
                    System.out.print("Nuevo nombre (o presione Enter para mantener el actual): ");
                    String nuevoNombre = lector.nextLine();
                    if (nuevoNombre.isEmpty()) {
                        nuevoNombre = lineaActual.split(": ")[1]; // Mantener el nombre actual si se presiona Enter
                    }
                    writer.write("Nombre: " + nuevoNombre + "\n");
                    nombreActual = nuevoNombre; // Actualizar el nombre

                    // Modificar edad
                    System.out.print("Nueva edad (o presione Enter para mantener el actual): ");
                    String nuevaEdad = lector.nextLine();
                    if (nuevaEdad.isEmpty()) {
                        nuevaEdad = lineaActual.split(": ")[1]; // Mantener la edad actual
                    }
                    writer.write("Edad: " + nuevaEdad + "\n");
                    edadActual = nuevaEdad;

                    // Modificar peso
                    System.out.print("Nuevo peso (o presione Enter para mantener el actual): ");
                    String nuevoPeso = lector.nextLine();
                    if (nuevoPeso.isEmpty()) {
                        nuevoPeso = lineaActual.split(": ")[1]; // Mantener el peso actual
                    }
                    writer.write("Peso: " + nuevoPeso + "\n");
                    pesoActual = nuevoPeso;

                    // Modificar diagnóstico
                    System.out.print("Nuevo diagnóstico (o presione Enter para mantener el actual): ");
                    String nuevoDiagnostico = lector.nextLine();
                    if (nuevoDiagnostico.isEmpty()) {
                        nuevoDiagnostico = lineaActual.split(": ")[1]; // Mantener el diagnóstico actual
                    }
                    writer.write("Diagnóstico: " + nuevoDiagnostico + "\n");
                    diagnosticoActual = nuevoDiagnostico;

                    // Saltar el resto del bloque (hasta "Dueño:"), ya que hemos actualizado los
                    // valores
                    while ((lineaActual = reader.readLine()) != null && !lineaActual.startsWith("Dueño:")) {
                        // No escribir el resto de las líneas del registro de este perro
                    }

                    // Escribir "Dueño:" y sus detalles, que no necesitan modificación
                    if (lineaActual != null) {
                        writer.write(lineaActual + "\n");
                    }

                    registroModificado = true;
                    esRegistroPerro = false; // Finalizamos el bloque del perro
                } else {
                    // Si no es el perro que estamos buscando, solo lo escribimos normalmente
                    writer.write(lineaActual + "\n");
                }
            }

            // Informar si no se encontró el perro para modificar
            if (!registroModificado) {
                System.out.println("No se encontró un gato con el nombre especificado.");
            }

        } catch (IOException e) {
            System.err.println("Error durante la modificación: " + e.getMessage());
        }

        // Reemplazar el archivo original con el archivo modificado
        try {
            Files.deleteIfExists(Paths.get(rutaArchivo));
            Files.move(Paths.get(auxFilePath), Paths.get(rutaArchivo));
            System.out.println("El archivo se ha modificado exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al reemplazar el archivo principal: " + e.getMessage());
        }
    }

    @Override
    public void modificarVeterinario() {
        System.out.print("Ingrese el DNI del veterinario a modificar: ");

        String rutaArchivo = "Veterinaria.txt";
        String auxFilePath = "Copia.txt";
        String dniCliente = lector.nextLine().trim();
        boolean clienteModificado = false;

        try (
                BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo));
                BufferedWriter writer = new BufferedWriter(new FileWriter(auxFilePath))) {
            String lineaActual;
            boolean esRegistroCliente = false;

            while ((lineaActual = reader.readLine()) != null) {
                if (lineaActual.startsWith("DNI:")) {
                    esRegistroCliente = lineaActual.contains(dniCliente);
                }

                if (esRegistroCliente) {
                    if (lineaActual.startsWith("Dirección del local")) {
                        System.out.print("Nueva Dirección del local (o presione Enter para mantener el actual): ");
                        String nuevoCodigoCliente = lector.nextLine().trim();
                        if (nuevoCodigoCliente.isEmpty()) {
                            nuevoCodigoCliente = lineaActual.split(": ")[1];
                        }
                        writer.write("Nueva Dirección del local: " + nuevoCodigoCliente + "\n");

                        esRegistroCliente = false;
                        clienteModificado = true;
                    } else {
                        writer.write(lineaActual + "\n");
                    }
                } else {
                    writer.write(lineaActual + "\n");
                }
            }

            if (!clienteModificado) {
                System.out.println("No se encontró un cliente con el DNI especificado.");
            }

        } catch (IOException e) {
            System.err.println("Error durante la modificación: " + e.getMessage());
        }

        try {
            Files.deleteIfExists(Paths.get(rutaArchivo));
            Files.move(Paths.get(auxFilePath), Paths.get(rutaArchivo));
            System.out.println("El archivo se ha modificado exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al reemplazar el archivo principal: " + e.getMessage());
        }
    }

    @Override
    public void modificarCliente() {
        System.out.print("Ingrese el DNI del cliente a modificar: ");

        String rutaArchivo = "Veterinaria.txt";
        String auxFilePath = "Copia.txt";
        String dniCliente = lector.nextLine().trim();
        boolean clienteModificado = false;

        try (
                BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo));
                BufferedWriter writer = new BufferedWriter(new FileWriter(auxFilePath))) {
            String lineaActual;
            boolean esRegistroCliente = false;

            while ((lineaActual = reader.readLine()) != null) {
                if (lineaActual.startsWith("DNI:")) {
                    esRegistroCliente = lineaActual.contains(dniCliente);
                }

                if (esRegistroCliente) {
                    if (lineaActual.startsWith("Codigo Cliente:")) {
                        System.out.print("Nuevo código cliente (o presione Enter para mantener el actual): ");
                        String nuevoCodigoCliente = lector.nextLine().trim();
                        if (nuevoCodigoCliente.isEmpty()) {
                            nuevoCodigoCliente = lineaActual.split(": ")[1];
                        }
                        writer.write("Codigo Cliente: " + nuevoCodigoCliente + "\n");
                    }
                    if (lineaActual.startsWith("Dirección:")) {
                        System.out.print("Nueva dirección (o presione Enter para mantener el actual): ");
                        String nuevaDireccion = lector.nextLine().trim();
                        if (nuevaDireccion.isEmpty()) {
                            nuevaDireccion = lineaActual.split(": ")[1];
                        }
                        writer.write("Dirección: " + nuevaDireccion + "\n");

                        esRegistroCliente = false;
                        clienteModificado = true;
                    } else {
                        writer.write(lineaActual + "\n");
                    }
                } else {
                    writer.write(lineaActual + "\n");
                }
            }

            if (!clienteModificado) {
                System.out.println("No se encontró un cliente con el DNI especificado.");
            }

        } catch (IOException e) {
            System.err.println("Error durante la modificación: " + e.getMessage());
        }

        try {
            Files.deleteIfExists(Paths.get(rutaArchivo));
            Files.move(Paths.get(auxFilePath), Paths.get(rutaArchivo));
            System.out.println("El archivo se ha modificado exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al reemplazar el archivo principal: " + e.getMessage());
        }
    }

    // #endregion
    // #region elimnar

    @Override
    public void eliminarPerro() {
        System.out.print("Ingrese el nombre del perro a eliminar: ");

        String rutaArchivo = "Veterinaria.txt";
        String auxFilePath = "Copia.txt";
        String nombrePerro = lector.nextLine().trim();
        boolean perroEliminado = false;

        try (
                BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo));
                BufferedWriter writer = new BufferedWriter(new FileWriter(auxFilePath))) {
            String lineaActual;
            boolean esRegistroPerro = false;
            boolean eliminarRegistro = false;

            while ((lineaActual = reader.readLine()) != null) {

                if (lineaActual.startsWith("Mascota: Perro")) {
                    esRegistroPerro = true;
                    eliminarRegistro = false;
                }

                if (esRegistroPerro && lineaActual.startsWith("Nombre:") && lineaActual.contains(nombrePerro)) {
                    eliminarRegistro = true;
                }

                if (esRegistroPerro && eliminarRegistro) {

                    if (lineaActual.startsWith("Dueño:")) {

                        esRegistroPerro = false;
                        eliminarRegistro = false;
                        continue;
                    }

                    continue;
                }

                writer.write(lineaActual + "\n");
            }

            if (perroEliminado) {
                System.out.println("No se encontró un perro con el nombre especificado.");
            } else {
                System.out.println("El perro fue eliminado exitosamente.");

            }

        } catch (IOException e) {
            System.err.println("Error durante la eliminación: " + e.getMessage());
        }

        try {
            Files.deleteIfExists(Paths.get(rutaArchivo));
            Files.move(Paths.get(auxFilePath), Paths.get(rutaArchivo));
            eliminarMascotaPerroSiSiguienteVacia();
        } catch (IOException e) {
            System.err.println("Error al reemplazar el archivo principal: " + e.getMessage());
        }
    }

    @Override
    public void eliminarGato() {
        System.out.print("Ingrese el nombre del gato a eliminar: ");

        String rutaArchivo = "Veterinaria.txt";
        String auxFilePath = "Copia.txt";
        String nombrePerro = lector.nextLine().trim();
        boolean perroEliminado = false;

        try (
                BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo));
                BufferedWriter writer = new BufferedWriter(new FileWriter(auxFilePath))) {
            String lineaActual;
            boolean esRegistroPerro = false;
            boolean eliminarRegistro = false;

            while ((lineaActual = reader.readLine()) != null) {

                if (lineaActual.startsWith("Mascota: Gato")) {
                    esRegistroPerro = true;
                    eliminarRegistro = false;
                }

                if (esRegistroPerro && lineaActual.startsWith("Nombre:") && lineaActual.contains(nombrePerro)) {
                    eliminarRegistro = true;
                }

                if (esRegistroPerro && eliminarRegistro) {

                    if (lineaActual.startsWith("Dueño:")) {

                        esRegistroPerro = false;
                        eliminarRegistro = false;
                        continue;
                    }

                    continue;
                }

                writer.write(lineaActual + "\n");
            }

            if (perroEliminado) {
                System.out.println("No se encontró un gato con el nombre especificado.");
            } else {
                System.out.println("El gato fue eliminado exitosamente.");

            }

        } catch (IOException e) {
            System.err.println("Error durante la eliminación: " + e.getMessage());
        }

        try {
            Files.deleteIfExists(Paths.get(rutaArchivo));
            Files.move(Paths.get(auxFilePath), Paths.get(rutaArchivo));
            eliminarMascotaPerroSiSiguienteVacia();
        } catch (IOException e) {
            System.err.println("Error al reemplazar el archivo principal: " + e.getMessage());
        }

    }

    @Override
    public void eliminarVeterinario() {
        System.out.print("Ingrese el DNI del veterinario a eliminar: ");

        String rutaArchivo = "Veterinaria.txt";
        String auxFilePath = "Copia.txt";
        String nombrePerro = lector.nextLine().trim();
        boolean perroEliminado = false;

        try (
                BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo));
                BufferedWriter writer = new BufferedWriter(new FileWriter(auxFilePath))) {
            String lineaActual;
            boolean esRegistroPerro = false;
            boolean eliminarRegistro = false;

            while ((lineaActual = reader.readLine()) != null) {

                if (lineaActual.startsWith("Numero de matricula del Veterinario:")) {
                    esRegistroPerro = true;
                    eliminarRegistro = false;
                }

                if (esRegistroPerro && lineaActual.startsWith("DNI:") && lineaActual.contains(nombrePerro)) {
                    eliminarRegistro = true;
                }

                if (esRegistroPerro && eliminarRegistro) {

                    if (lineaActual.startsWith("Dirección del local:")) {

                        esRegistroPerro = false;
                        eliminarRegistro = false;
                        continue;
                    }

                    continue;
                }

                writer.write(lineaActual + "\n");
            }

            if (perroEliminado) {
                System.out.println("No se encontró un veterinario con el nombre especificado.");
            } else {
                System.out.println("El veterinario fue eliminado exitosamente.");

            }

        } catch (IOException e) {
            System.err.println("Error durante la eliminación: " + e.getMessage());
        }

        try {
            Files.deleteIfExists(Paths.get(rutaArchivo));
            Files.move(Paths.get(auxFilePath), Paths.get(rutaArchivo));
            eliminarMascotaPerroSiSiguienteVacia();
        } catch (IOException e) {
            System.err.println("Error al reemplazar el archivo principal: " + e.getMessage());
        }
    }

    @Override
    public void eliminarCliente() {
        System.out.print("Ingrese el DNI del cliente a eliminar: ");

        String rutaArchivo = "Veterinaria.txt";
        String auxFilePath = "Copia.txt";
        String nombrePerro = lector.nextLine().trim();
        boolean perroEliminado = false;

        try (
                BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo));
                BufferedWriter writer = new BufferedWriter(new FileWriter(auxFilePath))) {
            String lineaActual;
            boolean esRegistroPerro = false;
            boolean eliminarRegistro = false;

            while ((lineaActual = reader.readLine()) != null) {

                if (lineaActual.startsWith("Codigo Cliente:")) {
                    esRegistroPerro = true;
                    eliminarRegistro = false;
                }

                if (esRegistroPerro && lineaActual.startsWith("DNI:") && lineaActual.contains(nombrePerro)) {
                    eliminarRegistro = true;
                }

                if (esRegistroPerro && eliminarRegistro) {

                    if (lineaActual.startsWith("Dirección:")) {

                        esRegistroPerro = false;
                        eliminarRegistro = false;
                        continue;
                    }

                    continue;
                }

                writer.write(lineaActual + "\n");
            }

            if (perroEliminado) {
                System.out.println("No se encontró un cliente con el nombre especificado.");
            } else {
                System.out.println("El cliente fue eliminado exitosamente.");

            }

        } catch (IOException e) {
            System.err.println("Error durante la eliminación: " + e.getMessage());
        }

        try {
            Files.deleteIfExists(Paths.get(rutaArchivo));
            Files.move(Paths.get(auxFilePath), Paths.get(rutaArchivo));
            eliminarMascotaPerroSiSiguienteVacia();
        } catch (IOException e) {
            System.err.println("Error al reemplazar el archivo principal: " + e.getMessage());
        }
    }

    @Override
    public void eliminarTodo() {
        try {
            FileWriter escritura = new FileWriter("Veterinaria.txt", false);
            escritura.write("");
            escritura.close();

        } catch (IOException e) {
            System.out.println("Error");
        }
        System.out.println("Eliminado todo con exito");
    }

    // #endregion
    // #region otros

    private Clientes buscarClientePorDni(int dni) {
        File archivo = new File("Veterinaria.txt");

        if (!archivo.exists()) {
            System.out.println("El archivo Veterinaria.txt no existe.");
            return null;
        }

        try (BufferedReader lectorArchivo = new BufferedReader(new FileReader(archivo))) {
            String linea;
            Clientes clienteActual = null;

            while ((linea = lectorArchivo.readLine()) != null) {
                if (linea.startsWith("Codigo Cliente:")) {
                    clienteActual = new Clientes();
                }

                if (linea.startsWith("DNI:")) {
                    int dniCliente = Integer.parseInt(linea.split(":")[1].trim());
                    if (dniCliente == dni) {
                        clienteActual.Set_dni(dniCliente);
                    }
                }

                if (linea.startsWith("Nombre:") && clienteActual != null) {
                    clienteActual.Set_Nombre(linea.split(":")[1].trim());
                }

                if (linea.isEmpty() && clienteActual != null) {
                    // Cuando encontramos un cliente completo y el DNI coincide, retornamos el
                    // cliente
                    if (clienteActual.Get_dni() == dni) {
                        return clienteActual;
                    }
                    clienteActual = null; // Reiniciar para buscar el siguiente cliente
                }
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo: " + e.getMessage());
        }

        return null; // Si no se encuentra un cliente con el DNI, se retorna null
    }

    @Override
    public void cargarClienteConMascota(Clientes cliente) {
        if (cliente == null) {
            cliente = new Clientes();
        }

        System.out.println("Dime el DNI del cliente");
        while (!lector.hasNextInt()) {
            System.out.println("Por favor, ingresa un número entero para la edad:");
            lector.next();
        }
        int dni;
        while (true) {
            while (!lector.hasNextInt()) {
                System.out.println("Por favor, ingresa un número entero para el DNI:");
            }
            dni = lector.nextInt();

            if (dnisRegistrados.contains(dni)) {
                System.out.println("Ya existe un cliente con este DNI. Por favor, ingresa un DNI diferente:");
            } else
                break;
        }

        cliente.Set_dni(dni);
        dnisRegistrados.add(dni);

        lector.nextLine();

        System.out.println("Dime el nombre del cliente");
        cliente.Set_Nombre(lector.nextLine());
        System.out.println("Dime el apellido del cliente");
        cliente.Set_apellido(lector.nextLine());
        System.out.println("Dime el código del cliente");
        cliente.Set_codigoCliente(lector.nextLine());
        System.out.println("Dime la dirección del cliente");
        cliente.setDireccion(lector.nextLine());

        System.out.println();
        clientes.add(cliente);
        try (FileWriter escritura = new FileWriter("Veterinaria.txt", true);) {
            escritura.write("Codigo Cliente: " + cliente.Get_codigoCliente() + "\n");
            escritura.write("DNI: " + cliente.Get_dni() + "\n");
            escritura.write("Nombre: " + cliente.Get_nombre() + "\n");
            escritura.write("Apellido: " + cliente.Get_apellido() + "\n");
            escritura.write("Dirección: " + cliente.getDireccion() + "\n");
            escritura.write("\n");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al guardar los datos del cliente: " + e.getMessage());
        }

        System.out.println();
        System.out.println("Cliente agregado exitosamente.");
        System.out.println();
    }

    private void cargarDnisDesdeArchivo() {
        try (BufferedReader reader = new BufferedReader(new FileReader("Veterinaria.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("DNI:")) {
                    int dni = Integer.parseInt(line.split(":")[1].trim());
                    dnisRegistrados.add(dni);
                }
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo: " + e.getMessage());
        }
    }

    public void eliminarMascotaPerroSiSiguienteVacia() {
        String rutaArchivo = "Veterinaria.txt";
        String auxFilePath = "Copia.txt";

        try (
                BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo));
                BufferedWriter writer = new BufferedWriter(new FileWriter(auxFilePath))) {
            String lineaActual;
            String siguienteLinea;
            boolean esMascotaPerro = false;

            while ((lineaActual = reader.readLine()) != null) {
                if (lineaActual.startsWith("Mascota: Perro")
                        || (lineaActual.startsWith("Mascota: Gato") || (lineaActual.startsWith("Codigo Cliente:")))
                        || (lineaActual.startsWith("Numero de matricula del Veterinario:"))) {
                    siguienteLinea = reader.readLine();

                    if (siguienteLinea == null || siguienteLinea.trim().isEmpty()) {
                        continue;
                    } else {
                        writer.write(lineaActual + "\n");
                        writer.write(siguienteLinea + "\n");
                    }
                    continue;
                }

                writer.write(lineaActual + "\n");
            }

        } catch (IOException e) {
            System.err.println("Error durante la eliminación: " + e.getMessage());
        }

        try {
            Files.deleteIfExists(Paths.get(rutaArchivo));
            Files.move(Paths.get(auxFilePath), Paths.get(rutaArchivo));
        } catch (IOException e) {
            System.err.println("Error al reemplazar el archivo principal: " + e.getMessage());
        }
    }

    // #endregion

}
