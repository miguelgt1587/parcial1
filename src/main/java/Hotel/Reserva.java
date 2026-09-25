package Hotel;

import java.time.LocalDate;
import java.util.List;

public class Reserva {

    private String codigo;
    private LocalDate fechaRealizacion;
    private LocalDate fechaEntrada;
    private String estado;
    private String metodoPago;
    private double valorTotal;
    private String telefonoHuesped;
    private List<Servicio> servicios;
    private Huesped huesped;
    private List<Habitacion> habitaciones;

    public Reserva(String codigo, LocalDate fechaRealizacion, LocalDate fechaEntrada, String estado, String metodoPago, double valorTotal, String telefonoHuesped, List<Servicio> servicios, Huesped huesped, List<Habitacion> habitaciones) {

        this.codigo = codigo;
        this.fechaRealizacion = fechaRealizacion;
        this.fechaEntrada = fechaEntrada;
        this.estado = estado;
        this.metodoPago = metodoPago;
        this.valorTotal = valorTotal;
        this.telefonoHuesped = telefonoHuesped;
        this.servicios = servicios;
        this.huesped = huesped;
        this.habitaciones = habitaciones;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(LocalDate fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getTelefonoHuesped() {
        return telefonoHuesped;
    }

    public void setTelefonoHuesped(String telefonoHuesped) {
        this.telefonoHuesped = telefonoHuesped;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(List<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }
}