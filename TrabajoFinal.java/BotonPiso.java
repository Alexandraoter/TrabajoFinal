public class BotonPiso extends Boton {
    private int pisoActual;

    // Constructor de BotonPiso
    public BotonPiso(int id, EstadoAscensor tipo, int pisoActual) {
        super(id, tipo);  // Llamamos al constructor correcto de la clase base
        this.pisoActual = pisoActual;
    }

    // Método para obtener el piso actual
    public int getPisoActual() {
        return pisoActual;
    }

    // Sobrescribir cambiarEstadoBoton en lugar de presionar
    @Override
    public void cambiarEstadoBoton(boolean presionar) {
        super.cambiarEstadoBoton(presionar);  // Llamamos al método de la clase base
        if (presionar) {
            // Solo procesamos la solicitud si el botón fue presionado
            System.out.println("Solicitud en el piso " + pisoActual);
        }
    }
}

