import java.util.List;

public class Ascensor {
    private int pisoActual;
    private boolean subiendo;
    private List<Boton> botones; // Lista de botones del ascensor
    private Puerta puerta;
    private Botonera botonera;
    private EstadoAscensor estado;

    public Ascensor(int pisoInicial, Puerta puerta, Botonera botonera) {
        this.pisoActual = pisoInicial;
        this.puerta = puerta;
        this.botonera = botonera;
    }

    

    public int getPisoActual() {
        return pisoActual;
    }



    public boolean isSubiendo() {
        return subiendo;
    }



    public Puerta getPuerta() {
        return puerta;
    }



    public Botonera getBotonera() {
        return botonera;
    }



    public EstadoAscensor getEstado() {
        return estado;
    }

    public List<Boton> getBotones() {
        return botones;
    }

    public void moverAlPiso(int pisoDestino) {
        // Lógica para mover el ascensor al piso destino
        subiendo = pisoDestino > pisoActual;
        // ... implementación del movimiento, considerando obstáculos, tiempo, etc.
        pisoActual = pisoDestino;
    }

    public void abrirPuerta() {
        puerta.abrir();
    }

    public void cerrarPuerta() {
        puerta.cerrar();
    }

    public void procesarSolicitud(Boton boton) {
        int pisoDestino = boton.getId();
        moverAlPiso(pisoDestino);
    }

    public boolean sistemaDireccionFunciona() {
        return true; // Ejemplo: retornar true si el sistema funciona correctamente
    }

    public void parar() {
        // Lógica para detener el ascensor, como cambiar el estado a detenido
        estado = EstadoAscensor.PARADO;
    }
}
