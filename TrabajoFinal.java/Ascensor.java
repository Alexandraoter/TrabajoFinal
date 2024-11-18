import java.util.Queue;
import java.util.LinkedList;

public class Ascensor {
    private int id;  // Identificador único del ascensor
    private int pisoActual;
    private boolean subiendo;
    private Puerta puerta;
    private Botonera botonera;
    private EstadoAscensor estado;
    private boolean puertasAbiertas;
    private Queue<Solicitud> solicitudesPendientes;
    private boolean disponible;
    private BotonPuertasAbiertas botonPuertasAbiertas; 
    private int pisoAnterior;

    // Clase interna para manejar las solicitudes del ascensor
    public static class Solicitud {
        int pisoActual;
        int pisoDestino;
        long tiempoSolicitud;

        public Solicitud(int pisoActual, int pisoDestino) {
            this.pisoActual = pisoActual;
            this.pisoDestino = pisoDestino;
            this.tiempoSolicitud = System.currentTimeMillis();
        }

        public int getPisoActual() {
            return pisoActual;
        }

        public int getPisoDestino() {
            return pisoDestino;
        }

        @Override
    public String toString() {
        return "Solicitud [pisoActual=" + pisoActual + ", pisoDestino=" + pisoDestino + "]";
    }

    }

    public Ascensor(int id, int pisoActual, Puerta puerta, int cantidadPisos) {
        this.id = id;
        this.pisoActual = pisoActual;
        this.puerta = puerta;
        this.botonera = new Botonera(cantidadPisos);
        this.estado = EstadoAscensor.Piso;
        this.puertasAbiertas = false;
        this.solicitudesPendientes = new LinkedList<>();
        this.disponible = true;
        this.pisoAnterior = pisoActual;

        // Inicializar los botones para cada piso
        for (int i = 1; i <= cantidadPisos; i++) {
            Boton botonPiso = new BotonAscensor(i, i, this);
            botonera.agregarBoton(botonPiso);
        }

        // Inicializar el botón para mantener las puertas abiertas
        this.botonPuertasAbiertas = new BotonPuertasAbiertas(999, this);
        botonera.agregarBoton(botonPuertasAbiertas);
    }

    // Métodos para control de puerta
    public void abrirPuerta() {
        if (!puertasAbiertas) {
            puerta.abrir();
            puertasAbiertas = true;
            System.out.println("Ascensor " + id + ": Puerta abierta");
        }
    }

    public void cerrarPuerta() {
        if (!puerta.isObstaculoPresente()) {
            puerta.cerrar();
            puertasAbiertas = false;
            System.out.println("Ascensor " + id + ": Puerta cerrada");
        } else {
            System.out.println("Ascensor " + id + ": No se puede cerrar la puerta, hay un obstáculo");
        }
    }

    
    public int getId() {
        return id;
    }

    public int getPisoActual() {
        return pisoActual;
    }

    public Puerta getPuerta() {
        return puerta;
    }

    public Botonera getBotonera(){
        return botonera;
    }

    public boolean estaDisponible() {
        return disponible && estado == EstadoAscensor.Piso;
    }

    public int getCantidadSolicitudesPendientes() {
        return solicitudesPendientes.size();
    }

    public Queue<Solicitud> getSolicitudesPendientes() {
        return solicitudesPendientes;
    }

    public void agregarSolicitudPendiente(Solicitud solicitud) {
        solicitudesPendientes.add(solicitud);
    }

    public void moverAPisoSeguro() {
        disponible = false;
        estado = EstadoAscensor.Piso;
        abrirPuerta();
    }



    public void addSolicitud(Solicitud solicitud) {
        // Verificar si ya existe una solicitud igual en la cola
        if (!existeSolicitudDuplicada(solicitud)) {
            solicitudesPendientes.add(solicitud);  // Si no es duplicada, la agregamos
        } else {
            System.out.println("Solicitud duplicada, no se añadirá.");
        }
    }

    public boolean existeSolicitudDuplicada(Solicitud nuevSolicitud) {
        // Recorre la cola de solicitudes pendientes del ascensor
        for (Solicitud solicitud : solicitudesPendientes) {
            if (solicitud.getPisoActual() == nuevSolicitud.getPisoActual() &&
            solicitud.getPisoDestino() == nuevSolicitud.getPisoDestino()) {
                return true;  // Si la solicitud ya esta en la cola
            }
        }
        return false;  // Si no hay solicitud duplicada
    }


    // Método mejorado para procesar solicitudes
    public void procesarSolicitud( int pisoDestino) {
        // Si la solicitud es para el mismo piso en el que ya está, no hace nada
        if (pisoDestino == pisoActual) {
            System.out.println("El ascensor ya se encuentra en el piso " + pisoDestino);
            return;
        }

        disponible = false;
        moverAlPiso(pisoDestino);

        // Procesar siguiente solicitud pendiente si existe
        if (!solicitudesPendientes.isEmpty()) {
            Solicitud siguienteSolicitud = solicitudesPendientes.poll();
            procesarSolicitud(siguienteSolicitud.getPisoDestino());
        } else {
            disponible = true;
        }
    }
    

    // Método mejorado para mover el ascensor
    public void moverAlPiso(int pisoDestino) {
        if (pisoDestino < 0 || pisoDestino > botonera.getCantidadPisos()) {
            System.out.println("Error: piso incorrecto, intenta nuevamente");
            return;
        }

        // Si ya está en el piso destino, no hace nada
        if (pisoDestino == pisoActual) {
            System.out.println("Ascensor " + id + " ya se encuentra en el piso solicitado.");
            return;
        }

        // Si el destino es más alto
        if (pisoDestino > pisoActual) {
            subiendo = true;
            estado = EstadoAscensor.MOVIENDO;
            cerrarPuerta();
            System.out.println("Ascensor " + id + " está subiendo al piso " + pisoDestino);
            pisoActual = pisoDestino;
            System.out.println("Ascensor " + id + " ha llegado al piso " + pisoActual);
            abrirPuerta();
        }
        // Si el destino es más bajo
        else if (pisoDestino < pisoActual) {
            subiendo = false;
            estado = EstadoAscensor.MOVIENDO;
            cerrarPuerta();
            System.out.println("Ascensor " + id + " está bajando al piso " + pisoDestino);
            pisoActual = pisoDestino;
            System.out.println("Ascensor " + id + " ha llegado al piso " + pisoActual);
            abrirPuerta();
        }

        estado = EstadoAscensor.Piso;
    }

    
    public boolean esSolicitudDuplicada(int pisoOrigen, int pisoDestino) {
        // Itera sobre la cola de solicitudes pendientes
        for (Solicitud solicitud : solicitudesPendientes) {
            if (solicitud.getPisoActual() == pisoOrigen && solicitud.getPisoDestino() == pisoDestino) {
                return true;  // Si ya existe una solicitud igual, retorna verdadero
            }
        }
        return false;  // Si no se encuentra ninguna solicitud duplicada, retorna falso
    }
    

    // Método para detener el ascensor
    public void parar() {
        estado = EstadoAscensor.Piso;
        System.out.println("Ascensor " + id + " se ha detenido en el piso " + pisoActual);
    }
}
