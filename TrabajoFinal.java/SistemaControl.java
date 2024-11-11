import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;

public class SistemaControl {
    private List<Ascensor> ascensores;
    private List<Piso> pisos;
    private final int cantidadPisos;
    private final int cantidadAscensores;
    private Queue<Integer> solicitudesSubir;
    private Queue<Integer> solicitudesBajar;

    public SistemaControl(int cantidadPisos, int cantidadAscensores) {
        this.cantidadPisos = cantidadPisos;
        this.cantidadAscensores = cantidadAscensores;
        this.ascensores = new ArrayList<>();
        this.solicitudesSubir = new LinkedList<>();
        this.solicitudesBajar = new LinkedList<>();
        
        // Inicializa los ascensores
        for (int i = 0; i < cantidadAscensores; i++) {
            ascensores.add(new Ascensor(1, new Puerta(), cantidadPisos));
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



    public void solicitarAscensor(int pisoActual, int pisoDestino) {
        if (pisoActual < 1 || pisoActual > cantidadPisos || pisoDestino < 1 || pisoDestino > cantidadPisos) {
            System.out.println("Error: piso incorrecto.");
            return;
        }

        Ascensor ascensor = ascensores.get(0); // Seleccionamos el primer ascensor disponible

        // Primero, almacenamos las solicitudes en las respectivas colas de subida o bajada
        if (pisoDestino > pisoActual) {
            solicitudesSubir.add(pisoDestino);
        } else if (pisoDestino < pisoActual) {
            solicitudesBajar.add(pisoDestino);
        }

        // Priorizar las solicitudes en función de la dirección
        if (ascensor.getPisoActual() != pisoActual) {
            ascensor.procesarSolicitud(pisoActual);
        }
        // Procesamos las solicitudes según la dirección actual
        while (!solicitudesSubir.isEmpty()) {
            int siguientePiso = solicitudesSubir.poll();
            ascensor.procesarSolicitud(siguientePiso);
        }
        while (!solicitudesBajar.isEmpty()) {
            int siguientePiso = solicitudesBajar.poll();
            ascensor.procesarSolicitud(siguientePiso);
        }
    }

    // Cambia la dirección del ascensor si es necesario
    public void cambiarDireccion(Ascensor ascensor) {
        if (solicitudesSubir.isEmpty() && !solicitudesBajar.isEmpty()) {
            ascensor.moverAlPiso(solicitudesBajar.poll());
        } else if (solicitudesBajar.isEmpty() && !solicitudesSubir.isEmpty()) {
            ascensor.moverAlPiso(solicitudesSubir.poll());
        }
    }

    public void gestionarEmergencia() {
        for (Ascensor ascensor : ascensores) {
            ascensor.parar();
            System.out.println("Ascensor detenido en piso " + ascensor.getPisoActual());
        }
    }

    public void monitorearSistema() {
        for (Ascensor ascensor : ascensores) {
            if (!ascensor.getPuerta().estaFuncionando()) {
                generarAlerta("Falla en la puerta del ascensor en piso " + ascensor.getPisoActual());
            }
        }
    }

    public void generarAlerta(String mensaje) {
        System.out.println("Alerta: " + mensaje);
    }
}

