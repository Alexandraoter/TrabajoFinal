import java.util.ArrayList;
import java.util.List;

public class Ascensor {
    private int pisoActual;
    private boolean subiendo;
    private Puerta puerta;
    private Botonera botonera;
    private EstadoAscensor estado;

    public Ascensor(int pisoInicial, Puerta puerta, int cantidadPisos) {
        this.pisoActual = pisoInicial;
        this.puerta = puerta;
        this.botonera = new Botonera(); // Inicializa la botonera del ascensor
        this.estado = EstadoAscensor.PARADO;

        // Crear botones de piso en la botonera del ascensor usando la clase BotonAscensor
        for (int i = 1; i <= cantidadPisos; i++) {
            Boton botonPiso = new BotonAscensor(i, i); // Usar la clase correcta BotonAscensor
            botonera.agregarBoton(botonPiso);
        }
    }

    public int getPisoActual() {
        return pisoActual;
    }

    public Puerta getPuerta() {
        return puerta;
    }

    public void moverAlPiso(int pisoDestino) {
        subiendo = pisoDestino > pisoActual;
        estado = EstadoAscensor.MOVIENDO;
        System.out.println("Ascensor en movimiento al piso " + pisoDestino);
        pisoActual = pisoDestino;
        estado = EstadoAscensor.PARADO;
    }

    public void abrirPuerta() {
        puerta.abrir();
    }

    public void cerrarPuerta() {
        puerta.cerrar();
    }

    public void procesarSolicitud(int pisoDestino) {
        moverAlPiso(pisoDestino);
        abrirPuerta();
    }

    public void parar() {
        estado = EstadoAscensor.PARADO;
    }
}
