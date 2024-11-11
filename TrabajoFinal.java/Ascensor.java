public class Ascensor {
    private int pisoActual;
    private boolean subiendo;
    private Puerta puerta;
    private Botonera botonera;
    private EstadoAscensor estado;

    public Ascensor(int pisoActual, Puerta puerta, int cantidadPisos) {
        this.pisoActual = pisoActual;
        this.puerta = puerta;
        this.botonera = new Botonera(cantidadPisos); // Inicializa la botonera del ascensor
        this.estado = EstadoAscensor.PARADO;

        // Crear botones de piso en la botonera del ascensor usando la clase BotonAscensor
        for (int i = 1; i <= cantidadPisos; i++) {
            Boton botonPiso = new BotonAscensor(i, i, this); // Usar la clase correcta BotonAscensor
            botonera.agregarBoton(botonPiso);
        }
    }

    public int getPisoActual() {
        return pisoActual;
    }

    public Puerta getPuerta() {
        return puerta;
    }

    // Método para mover el ascensor hacia el piso destino
    public void moverAlPiso(int pisoDestino) {
        if (pisoDestino < 0 || pisoDestino > botonera.getCantidadPisos()) {
            System.out.println("Error: piso incorrecto");
            return;
        }

        // Si el destino es más alto
        if (pisoDestino > pisoActual) {
            subiendo = true;
            estado = EstadoAscensor.MOVIENDO;
            System.out.println("El ascensor está subiendo al piso " + pisoDestino);
            // Simulamos que el ascensor llega al destino
            pisoActual = pisoDestino;  // Actualizamos el piso actual
            System.out.println("El ascensor ha llegado al piso " + pisoActual);
        }
        // Si el destino es más bajo
        else if (pisoDestino < pisoActual) {
            subiendo = false; // Aseguramos que el ascensor baje
            estado = EstadoAscensor.MOVIENDO;
            System.out.println("El ascensor está bajando al piso " + pisoDestino);
            // Simulamos que el ascensor llega al destino
            pisoActual = pisoDestino;  // Actualizamos el piso actual
            System.out.println("El ascensor ha llegado al piso " + pisoActual);
        }
        // Si ya está en el piso destino
        else {
            System.out.println("El ascensor ya está en el piso " + pisoDestino);
        }

        // Al llegar al destino, abrimos las puertas
        abrirPuerta();
    }

    // Método para abrir las puertas
    public void abrirPuerta() {
        puerta.abrir();
    }

    // Método para cerrar las puertas
    public void cerrarPuerta() {
        puerta.cerrar();
    }

    // Procesar solicitud de un piso destino
    public void procesarSolicitud(int pisoDestino) {
        moverAlPiso(pisoDestino);  // Mueve el ascensor al piso destino
        abrirPuerta();  // Abre las puertas al llegar
    }

    // Detener el ascensor
    public void parar() {
        estado = EstadoAscensor.PARADO;
        System.out.println("El ascensor se ha detenido en el piso " + pisoActual);
    }
}
