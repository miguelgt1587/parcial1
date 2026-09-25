package Hotel;

import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class StayPlus {

    public String nombre;
    public int nit;
    public String direccion;
    public int telefono;
    public String paginaWeb;

    public StayPlus (String nombre, int nit, String direccion, int telefono, String paginaWeb) {
        this.nombre = nombre;
        this.nit = nit;
        this.direccion = direccion;
        this.telefono = telefono;
        this.paginaWeb = paginaWeb;
    }

    static ArrayList<Huesped> huespedes = new ArrayList<>();
    static ArrayList<Habitacion> habitaciones = new ArrayList<>();
    static ArrayList<Reserva> reservas = new ArrayList<>();
    static ArrayList<Servicio> servicios = new ArrayList<>();


    public static void main(String[] args) {

        crearDatos();

        int opcion;

        do {

            String menu = """
                    
                    ========================================
                              HOTEL STAY PLUS
                    ========================================
                    
                    1. Registrar huésped
                    2. Hacer reserva
                    3. Calcular total de la reserva
                    4. Actualizar estado de reserva
                    5. Agregar habitación a una reserva
                    6. Validar disponibilidad de habitación
                    7. Actualizar estado de habitación
                    8. Registrar servicio adicional
                    9. Asociar servicio a reserva
                    10. Agregar costo al valor total
                    11. Determinar número perfecto
                    12. Registrar habitación
                    
                    ------------- CONSULTAS --------------
                    
                    13. Consultar huésped
                    14. Consultar ingresos
                    15. Mostrar habitaciones
                    16. Mostrar reservas
                    17. Mostrar servicios
                    
                    18. Salir
                    
                    Seleccione una opción:
                    """;

            String entrada = JOptionPane.showInputDialog(menu);

            if (entrada == null) {
                opcion = 19;
            } else {
                try {
                    opcion = Integer.parseInt(entrada);
                } catch (Exception e) {
                    opcion = 0;
                }
            }

            switch (opcion) {

                case 1:
                    registrarHuesped();
                    break;

                case 2:
                    hacerReserva();
                    break;

                case 3:
                    calcularTotalReserva();
                    break;

                case 4:
                    actualizarEstadoReserva();
                    break;

                case 5:
                    agregarHabitacionReserva();
                    break;

                case 6:
                    validarDisponibilidadHabitacion();
                    break;

                case 7:
                    actualizarEstadoHabitacion();
                    break;

                case 8:
                    registrarServicio();
                    break;

                case 9:
                    asociarServicioReserva();
                    break;

                case 10:
                    agregarCostoValorTotal();
                    break;

                case 11:
                    determinarNumeroPerfecto();
                    break;

                case 12:
                    registrarHabitacion();
                    break;

                case 13:
                    consultarHuesped();
                    break;

                case 14:
                    consultarIngresos();
                    break;

                case 15:
                    mostrarHabitaciones();
                    break;

                case 16:
                    mostrarReservas();
                    break;

                case 17:
                    mostrarServicios();
                    break;

                case 18:
                    JOptionPane.showMessageDialog(null,
                            "Gracias por utilizar Hotel Stay Plus.");
                    break;

                default:
                    JOptionPane.showMessageDialog(null,
                            "Opción no válida.");

            }

        } while (opcion != 18);
    }


    public static void crearDatos() {

        Huesped h1 = new Huesped(
                "Juan Perez",
                "123456",
                "3001234567",
                "juan@gmail.com",
                "Colombia",
                null
        );

        Huesped h2 = new Huesped(
                "Carlos Lopez",
                "456789",
                "3006543210",
                "carlos@gmail.com",
                "Colombia",
                null
        );

        huespedes.add(h1);
        huespedes.add(h2);


        Habitacion hab1 = new Habitacion(
                101,
                1,
                "Individual",
                1,
                80000,
                true,
                null
        );

        Habitacion hab2 = new Habitacion(
                102,
                1,
                "Doble",
                2,
                120000,
                true,
                null
        );

        Habitacion hab3 = new Habitacion(
                201,
                2,
                "Suite",
                4,
                250000,
                true,
                null
        );

        habitaciones.add(hab1);
        habitaciones.add(hab2);
        habitaciones.add(hab3);


        Reserva r1 = new Reserva(
                "R001",
                LocalDate.of(2026, 9, 20),
                LocalDate.of(2026, 9, 25),
                "Confirmada",
                "Efectivo",
                400000,
                "3001234567",
                null,
                null,
                null
        );

        Reserva r2 = new Reserva(
                "R002",
                LocalDate.of(2026, 9, 20),
                LocalDate.of(2026, 9, 28),
                "Pendiente",
                "Tarjeta",
                300000,
                "3006543210",
                null,
                null,
                null
        );

        reservas.add(r1);
        reservas.add(r2);
    }


    public static void registrarHuesped() {

        String nombre = JOptionPane.showInputDialog("Ingrese el nombre:");
        String documento = JOptionPane.showInputDialog("Ingrese el documento:");
        String telefono = JOptionPane.showInputDialog("Ingrese el teléfono:");
        String correo = JOptionPane.showInputDialog("Ingrese el correo:");
        String pais = JOptionPane.showInputDialog("Ingrese el país:");

        Huesped huesped = new Huesped(
                nombre,
                documento,
                telefono,
                correo,
                pais,
                null
        );

        huespedes.add(huesped);

        JOptionPane.showMessageDialog(null,
                "Huésped registrado correctamente.");
    }



    public static void hacerReserva() {

        String codigo = JOptionPane.showInputDialog(
                "Ingrese el código de la reserva:"
        );

        String telefono = JOptionPane.showInputDialog(
                "Ingrese el teléfono del huésped:"
        );

        Huesped huesped = buscarHuespedPorTelefono(telefono);

        if (huesped == null) {
            JOptionPane.showMessageDialog(null,
                    "No se encontró el huésped.");
            return;
        }

        String fecha = JOptionPane.showInputDialog(
                "Ingrese la fecha de entrada (AAAA-MM-DD):"
        );

        LocalDate fechaEntrada;

        try {
            fechaEntrada = LocalDate.parse(fecha);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Fecha no válida.");
            return;
        }

        String pago = JOptionPane.showInputDialog(
                "Ingrese el método de pago:"
        );

        String numeroHabitacion = JOptionPane.showInputDialog(
                "Ingrese el número de habitación:"
        );

        int numero;

        try {
            numero = Integer.parseInt(numeroHabitacion);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Número de habitación no válido.");
            return;
        }

        Habitacion habitacion = buscarHabitacion(numero);

        if (habitacion == null) {
            JOptionPane.showMessageDialog(null,
                    "La habitación no existe.");
            return;
        }

        if (!habitacion.isDisponible()) {
            JOptionPane.showMessageDialog(null,
                    "La habitación no está disponible.");
            return;
        }

        Reserva reserva = new Reserva(
                codigo,
                LocalDate.now(),
                fechaEntrada,
                "Pendiente",
                pago,
                0,
                telefono,
                new ArrayList<Servicio>(),
                huesped,
                new ArrayList<Habitacion>()
        );

        reserva.getHabitaciones().add(habitacion);

        habitacion.setDisponible(false);
        habitacion.setReserva(reserva);

        reservas.add(reserva);

        calcularTotalDeReserva(reserva);

        JOptionPane.showMessageDialog(null,
                "Reserva realizada correctamente.\n"
                        + "Total: $" + reserva.getValorTotal());
    }



    public static void calcularTotalReserva() {

        String codigo = JOptionPane.showInputDialog(
                "Ingrese el código de la reserva:"
        );

        Reserva reserva = buscarReserva(codigo);

        if (reserva == null) {
            JOptionPane.showMessageDialog(null,
                    "No se encontró la reserva.");
            return;
        }

        calcularTotalDeReserva(reserva);

        JOptionPane.showMessageDialog(null,
                "El total de la reserva es: $"
                        + reserva.getValorTotal());
    }


    public static void calcularTotalDeReserva(Reserva reserva) {

        double total = 0;

        if (reserva.getHabitaciones() != null) {

            for (Habitacion habitacion : reserva.getHabitaciones()) {
                total = total + habitacion.getPrecioNoche();
            }
        }

        if (reserva.getServicios() != null) {

            for (Servicio servicio : reserva.getServicios()) {
                total = total + servicio.getPrecio();
            }
        }

        reserva.setValorTotal(total);
    }

    public static void actualizarEstadoReserva() {

        String codigo = JOptionPane.showInputDialog(
                "Ingrese el código de la reserva:"
        );

        Reserva reserva = buscarReserva(codigo);

        if (reserva == null) {
            JOptionPane.showMessageDialog(null,
                    "No se encontró la reserva.");
            return;
        }

        String estado = JOptionPane.showInputDialog(
                "Ingrese el nuevo estado:\n"
                        + "Ejemplo: Pendiente, Confirmada, Cancelada"
        );

        reserva.setEstado(estado);

        JOptionPane.showMessageDialog(null,
                "Estado actualizado correctamente.");
    }


    public static void agregarHabitacionReserva() {

        String codigo = JOptionPane.showInputDialog(
                "Ingrese el código de la reserva:"
        );

        Reserva reserva = buscarReserva(codigo);

        if (reserva == null) {
            JOptionPane.showMessageDialog(null,
                    "No se encontró la reserva.");
            return;
        }

        String entrada = JOptionPane.showInputDialog(
                "Ingrese el número de habitación:"
        );

        int numero;

        try {
            numero = Integer.parseInt(entrada);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Número no válido.");
            return;
        }

        Habitacion habitacion = buscarHabitacion(numero);

        if (habitacion == null) {
            JOptionPane.showMessageDialog(null,
                    "La habitación no existe.");
            return;
        }

        if (!habitacion.isDisponible()) {
            JOptionPane.showMessageDialog(null,
                    "La habitación no está disponible.");
            return;
        }

        if (reserva.getHabitaciones() == null) {
            reserva.setHabitaciones(new ArrayList<Habitacion>());
        }

        reserva.getHabitaciones().add(habitacion);

        habitacion.setDisponible(false);
        habitacion.setReserva(reserva);

        calcularTotalDeReserva(reserva);

        JOptionPane.showMessageDialog(null,
                "Habitación agregada correctamente.");
    }

    public static void validarDisponibilidadHabitacion() {

        String entrada = JOptionPane.showInputDialog(
                "Ingrese el número de habitación:"
        );

        int numero;

        try {
            numero = Integer.parseInt(entrada);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Número no válido.");
            return;
        }

        Habitacion habitacion = buscarHabitacion(numero);

        if (habitacion == null) {
            JOptionPane.showMessageDialog(null,
                    "La habitación no existe.");
            return;
        }

        if (habitacion.isDisponible()) {
            JOptionPane.showMessageDialog(null,
                    "La habitación está disponible.");
        } else {
            JOptionPane.showMessageDialog(null,
                    "La habitación NO está disponible.");
        }
    }

    public static void actualizarEstadoHabitacion() {

        String entrada = JOptionPane.showInputDialog(
                "Ingrese el número de habitación:"
        );

        int numero;

        try {
            numero = Integer.parseInt(entrada);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Número no válido.");
            return;
        }

        Habitacion habitacion = buscarHabitacion(numero);

        if (habitacion == null) {
            JOptionPane.showMessageDialog(null,
                    "La habitación no existe.");
            return;
        }

        String estado = JOptionPane.showInputDialog(
                "Ingrese el nuevo estado:\n"
                        + "1. Disponible\n"
                        + "2. No disponible"
        );

        if (estado.equals("1")) {

            habitacion.setDisponible(true);

        } else if (estado.equals("2")) {

            habitacion.setDisponible(false);

        } else {

            JOptionPane.showMessageDialog(null,
                    "Opción no válida.");
            return;
        }

        JOptionPane.showMessageDialog(null,
                "Estado de habitación actualizado.");
    }


    public static void registrarServicio() {

        String codigo = JOptionPane.showInputDialog(
                "Ingrese el código del servicio:"
        );

        String nombre = JOptionPane.showInputDialog(
                "Ingrese el nombre del servicio:"
        );

        String descripcion = JOptionPane.showInputDialog(
                "Ingrese la descripción:"
        );

        String precioTexto = JOptionPane.showInputDialog(
                "Ingrese el precio:"
        );

        double precio;

        try {
            precio = Double.parseDouble(precioTexto);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Precio no válido.");
            return;
        }

        Servicio servicio = new Servicio(
                codigo,
                nombre,
                descripcion,
                precio,
                true
        );

        servicios.add(servicio);

        JOptionPane.showMessageDialog(null,
                "Servicio registrado correctamente.");
    }


    public static void asociarServicioReserva() {

        String codigoReserva = JOptionPane.showInputDialog(
                "Ingrese el código de la reserva:"
        );

        Reserva reserva = buscarReserva(codigoReserva);

        if (reserva == null) {
            JOptionPane.showMessageDialog(null,
                    "No se encontró la reserva.");
            return;
        }

        String codigoServicio = JOptionPane.showInputDialog(
                "Ingrese el código del servicio:"
        );

        Servicio servicio = buscarServicio(codigoServicio);

        if (servicio == null) {
            JOptionPane.showMessageDialog(null,
                    "No se encontró el servicio.");
            return;
        }

        if (reserva.getServicios() == null) {
            reserva.setServicios(new ArrayList<Servicio>());
        }

        reserva.getServicios().add(servicio);

        reserva.setValorTotal(
                reserva.getValorTotal() + servicio.getPrecio()
        );

        JOptionPane.showMessageDialog(null,
                "Servicio asociado correctamente.\n"
                        + "Nuevo total: $" + reserva.getValorTotal());
    }


    public static void agregarCostoValorTotal() {

        String codigo = JOptionPane.showInputDialog(
                "Ingrese el código de la reserva:"
        );

        Reserva reserva = buscarReserva(codigo);

        if (reserva == null) {
            JOptionPane.showMessageDialog(null,
                    "No se encontró la reserva.");
            return;
        }

        String costoTexto = JOptionPane.showInputDialog(
                "Ingrese el costo adicional:"
        );

        double costo;

        try {
            costo = Double.parseDouble(costoTexto);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Costo no válido.");
            return;
        }

        double nuevoTotal = reserva.getValorTotal() + costo;

        reserva.setValorTotal(nuevoTotal);

        JOptionPane.showMessageDialog(null,
                "Costo agregado correctamente.\n"
                        + "Nuevo total: $" + nuevoTotal);
    }


    public static void determinarNumeroPerfecto() {

        String entrada = JOptionPane.showInputDialog(
                "Ingrese un número:"
        );

        try {

            int numero = Integer.parseInt(entrada);

            if (esNumeroPerfecto(numero)) {

                JOptionPane.showMessageDialog(null,
                        "El número " + numero
                                + " es un número perfecto.");

            } else {

                JOptionPane.showMessageDialog(null,
                        "El número " + numero
                                + " NO es un número perfecto.");
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null,
                    "Número no válido.");
        }
    }


    public static boolean esNumeroPerfecto(int numero) {

        int suma = 0;

        for (int i = 1; i < numero; i++) {

            if (numero % i == 0) {
                suma = suma + i;
            }
        }

        return suma == numero;
    }


    public static void registrarHabitacion() {

        String numeroTexto = JOptionPane.showInputDialog(
                "Ingrese el número de habitación:"
        );

        String pisoTexto = JOptionPane.showInputDialog(
                "Ingrese el piso:"
        );

        String tipo = JOptionPane.showInputDialog(
                "Ingrese el tipo de habitación:"
        );

        String capacidadTexto = JOptionPane.showInputDialog(
                "Ingrese la capacidad:"
        );

        String precioTexto = JOptionPane.showInputDialog(
                "Ingrese el precio por noche:"
        );

        try {

            int numero = Integer.parseInt(numeroTexto);
            int piso = Integer.parseInt(pisoTexto);
            int capacidad = Integer.parseInt(capacidadTexto);
            double precio = Double.parseDouble(precioTexto);

            Habitacion habitacion = new Habitacion(
                    numero,
                    piso,
                    tipo,
                    capacidad,
                    precio,
                    true,
                    null
            );

            habitaciones.add(habitacion);

            JOptionPane.showMessageDialog(null,
                    "Habitación registrada correctamente.");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null,
                    "Datos no válidos.");
        }
    }


    public static void consultarHuesped() {

        String telefono = JOptionPane.showInputDialog(
                "Ingrese el teléfono del huésped:"
        );

        boolean encontrado = false;

        for (Huesped h : huespedes) {

            if (h.getTelefono().equals(telefono)) {

                encontrado = true;

                JOptionPane.showMessageDialog(null,
                        "Huésped encontrado\n\n"
                                + "Nombre: " + h.getNombre() + "\n"
                                + "Documento: " + h.getDocumento() + "\n"
                                + "Teléfono: " + h.getTelefono() + "\n"
                                + "Correo: " + h.getCorreo() + "\n"
                                + "País: " + h.getPais());

                break;
            }
        }

        if (!encontrado) {

            JOptionPane.showMessageDialog(null,
                    "No se encontró el huésped.");
        }

        // Se conserva la funcionalidad original
        if (numeroPerfecto(telefono)) {

            JOptionPane.showMessageDialog(null,
                    "El teléfono es un número perfecto.");
        }
    }


    public static boolean numeroPerfecto(String telefono) {

        try {

            int numero = Integer.parseInt(telefono);

            int suma = 0;

            for (int i = 1; i < numero; i++) {

                if (numero % i == 0) {
                    suma = suma + i;
                }
            }

            return suma == numero;

        } catch (Exception e) {

            return false;
        }
    }


    public static void consultarIngresos() {

        String fechaTexto = JOptionPane.showInputDialog(
                "Ingrese la fecha (AAAA-MM-DD):"
        );

        try {

            LocalDate fecha = LocalDate.parse(fechaTexto);

            double total = 0;

            for (Reserva r : reservas) {

                if (r.getFechaRealizacion().equals(fecha)) {

                    total = total + r.getValorTotal();
                }
            }

            JOptionPane.showMessageDialog(null,
                    "Ingresos de la fecha: $" + total);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null,
                    "Fecha no válida.");
        }
    }


    public static void mostrarHabitaciones() {

        String mensaje = "HABITACIONES\n\n";

        for (Habitacion h : habitaciones) {

            String estado;

            if (h.isDisponible()) {
                estado = "Disponible";
            } else {
                estado = "No disponible";
            }

            mensaje = mensaje
                    + "Número: " + h.getNumero() + "\n"
                    + "Piso: " + h.getPiso() + "\n"
                    + "Tipo: " + h.getTipo() + "\n"
                    + "Capacidad: " + h.getCapacidad() + "\n"
                    + "Precio: $" + h.getPrecioNoche() + "\n"
                    + "Estado: " + estado + "\n"
                    + "------------------------\n";
        }

        JOptionPane.showMessageDialog(null, mensaje);
    }


    public static void mostrarReservas() {

        String mensaje = "RESERVAS\n\n";

        for (Reserva r : reservas) {

            mensaje = mensaje
                    + "Código: " + r.getCodigo() + "\n"
                    + "Fecha entrada: " + r.getFechaEntrada() + "\n"
                    + "Estado: " + r.getEstado() + "\n"
                    + "Método de pago: " + r.getMetodoPago() + "\n"
                    + "Valor total: $" + r.getValorTotal() + "\n"
                    + "Teléfono huésped: "
                    + r.getTelefonoHuesped() + "\n"
                    + "------------------------\n";
        }

        JOptionPane.showMessageDialog(null, mensaje);
    }


    public static void mostrarServicios() {

        String mensaje = "SERVICIOS\n\n";

        for (Servicio s : servicios) {

            mensaje = mensaje
                    + "Código: " + s.getCodigo() + "\n"
                    + "Nombre: " + s.getNombre() + "\n"
                    + "Descripción: " + s.getDescripcion() + "\n"
                    + "Precio: $" + s.getPrecio() + "\n"
                    + "Disponible: " + s.isDisponible() + "\n"
                    + "------------------------\n";
        }

        JOptionPane.showMessageDialog(null, mensaje);
    }


    public static Huesped buscarHuespedPorTelefono(String telefono) {

        for (Huesped h : huespedes) {

            if (h.getTelefono().equals(telefono)) {
                return h;
            }
        }

        return null;
    }


    public static Habitacion buscarHabitacion(int numero) {

        for (Habitacion h : habitaciones) {

            if (h.getNumero() == numero) {
                return h;
            }
        }

        return null;
    }


    public static Reserva buscarReserva(String codigo) {

        for (Reserva r : reservas) {

            if (r.getCodigo().equals(codigo)) {
                return r;
            }
        }

        return null;
    }


    public static Servicio buscarServicio(String codigo) {

        for (Servicio s : servicios) {

            if (s.getCodigo().equals(codigo)) {
                return s;
            }
        }

        return null;
    }
}