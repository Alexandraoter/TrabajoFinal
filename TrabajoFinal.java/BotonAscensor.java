public class BotonAscensor extends Boton {
    private int pisoDestino;
    private Ascensor ascensor;

    public BotonAscensor(int id, int pisoDestino, Ascensor ascensor) { 
        super(id, EstadoAscensor.Piso);  // Llamada al constructor de Boton
        this.pisoDestino = pisoDestino;
        this.ascensor = ascensor;
    }

    // Usamos el método cambiarEstadoBoton en lugar de presionar()
    @Override
    public void cambiarEstadoBoton(boolean presionar) {
        super.cambiarEstadoBoton(presionar);  // Llamamos al método de la clase base
        if (presionar) {
            // Solo procesamos la solicitud si el botón fue presionado
            ascensor.procesarSolicitud (pisoDestino);
        }
    }

    public int getPisoDestino() {
        return pisoDestino;
    }
}
