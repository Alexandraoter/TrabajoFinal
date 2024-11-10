import java.util.ArrayList;
import java.util.List;

public class SistemaControl {
    private List<Ascensor> ascensores;
    private List<Piso> pisos;
    private final int cantidadPisos;
    private final int cantidadAscensores;

    public SistemaControl(int cantidadPisos, int cantidadAscensores) {
        this.cantidadPisos = cantidadPisos;
        this.cantidadAscensores = cantidadAscensores;
        this.ascensores = new ArrayList<>();
        this.pisos = new ArrayList<>();

        // Crear pisos con sus botones
        for (int i = 1; i <= cantidadPisos; i++) {
            pisos.add(new Piso(i)); // Solo se pasa el número de piso, sin capacidad máxima
        }

        // Crear ascensores y asociarlos con una puerta y botonera
        for (int i = 1; i <= cantidadAscensores; i++) {
            Puerta puerta = new Puerta();
            Ascensor ascensor = new Ascensor(1, puerta, cantidadPisos); // Inicializamos en el piso 1
            ascensores.add(ascensor);
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

    public void solicitarAscensor(int pisoActual, int pisoDestino) {
        if (pisoActual < 1 || pisoActual > cantidadPisos || pisoDestino < 1 || pisoDestino > cantidadPisos) {
            System.out.println("Piso no válido.");
            return;
        }

        // Suponemos que el primer ascensor disponible realiza la solicitud
        Ascensor ascensor = ascensores.get(0);
        System.out.println("Ascensor asignado para solicitud desde piso " + pisoActual + " a piso " + pisoDestino);
        ascensor.procesarSolicitud(pisoDestino);
    }
}
