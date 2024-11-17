import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;


public class SistemaControl {
    private List<Ascensor> ascensores;
    private List<Piso> pisos;
    private final int cantidadPisos;
    private final int cantidadAscensores;
    private Queue<Ascensor.Solicitud> solicitudesPendientes;
    private boolean enEmergencia;

    public SistemaControl(int cantidadPisos, int cantidadAscensores) {
        this.cantidadPisos = cantidadPisos;
        this.cantidadAscensores = cantidadAscensores;
        this.ascensores = new ArrayList<>();
        this.solicitudesPendientes = new LinkedList<>();
        this.enEmergencia = false;

        // Inicializa los ascensores
        for (int i = 0; i < cantidadAscensores; i++) {
            ascensores.add(new Ascensor(i + 1, 1, new Puerta(), cantidadPisos));
        }
         
        // Inicializa los pisos
        this.pisos = new ArrayList<>();
        for (int i = 1; i <= cantidadPisos; i++) {
            pisos.add(new Piso(i));
        }
    }

    public List<Ascensor> getAscensores() {
        return ascensores;
    }

    public int getCantidadPisos() {
        return cantidadPisos;
    }


    public void solicitarAscensor(int numeroAscensor, int pisoActual, int pisoDestino) {
        // Validaciones
        if (pisoActual < 1 || pisoActual > cantidadPisos) {
            System.out.println("Error, el piso actual " + pisoActual + " es inválido porque debe estar entre el piso 1 y " + cantidadPisos + ".");
            return;
        }
        if (pisoDestino < 1 || pisoDestino > cantidadPisos) {
            System.out.println("Error, el piso de destino " + pisoDestino + " es inválido porque debe estar entre el piso 1 y " + cantidadPisos + ".");
            return;
        }

        if (numeroAscensor < 1 || numeroAscensor > cantidadAscensores){
            System.out.println("Error, el ascensor " + numeroAscensor + " no existe" );
            return;
        }

        //Para saber el ascensor especifico
        Ascensor ascensorSeleccionado = ascensores.get(numeroAscensor - 1); //sde resta uno por la lista 0 indexada

        // Crear nueva solicitud
        Ascensor.Solicitud solicitud = new Ascensor.Solicitud(pisoActual, pisoDestino);

        // Verificar si la solicitud ya está en la cola
    if (ascensorSeleccionado.existeSolicitudDuplicada(solicitud)) {
        System.out.println("La solicitud de " + pisoActual + " a " + pisoDestino + " ya está en la cola.");
        return;  // No agregar la solicitud duplicada
    }

        if(ascensorSeleccionado.estaDisponible()){
            System.out.println("El ascensor " + numeroAscensor + " está disponible. Procesando solicitud.");
        ascensorSeleccionado.procesarSolicitud(pisoActual);
        ascensorSeleccionado.procesarSolicitud(pisoDestino);
        }else{
            System.out.println("El ascensor " + numeroAscensor + " está ocupado. La solicitud se añadirá a su cola de pendientes.");
        ascensorSeleccionado.addSolicitud(solicitud); // Usamos el método addSolicitud que verifica duplicados
        }

    }



    public void gestionarEmergencia() {
        enEmergencia = true;
        for (Ascensor ascensor : ascensores) {
            ascensor.parar();
            // Mover el ascensor al piso más cercano y abrir las puertas
            ascensor.moverAPisoSeguro();
            System.out.println("Ascensor " + ascensor.getId() + " detenido en piso " + ascensor.getPisoActual());
        }
    }

    public void monitorearSistema() {
        for (Ascensor ascensor : ascensores) {
            if (!ascensor.getPuerta().isFuncionando()) {
                generarAlerta("Falla en la puerta del ascensor " + ascensor.getId() + " en piso " + ascensor.getPisoActual());
            }
            // Verificar si hay solicitudes pendientes que pueden ser procesadas
            if (ascensor.estaDisponible() && !solicitudesPendientes.isEmpty()) {
                Ascensor.Solicitud solicitud = solicitudesPendientes.poll();
                ascensor.procesarSolicitud(solicitud.pisoDestino);
            }
        }
    }

    public boolean estaEnEmergencia() {
        return enEmergencia;
    }

    public void generarAlerta(String mensaje) {
        System.out.println("Alerta: " + mensaje);
    }
}
