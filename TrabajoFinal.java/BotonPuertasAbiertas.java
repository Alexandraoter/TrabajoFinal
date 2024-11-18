public class BotonPuertasAbiertas extends Boton {
    private Ascensor ascensor;

    public BotonPuertasAbiertas(int id, Ascensor ascensor) {
        super(id, EstadoAscensor.Piso); // Llamamos al constructor correcto de la clase base Boton
        this.ascensor = ascensor;
    }

    // Sobrescribir el método cambiarEstadoBoton en lugar de presionar
    @Override
    public void cambiarEstadoBoton(boolean presionar) {
        super.cambiarEstadoBoton(presionar);  // Llamamos al método de la clase base

        if (presionar) {
            System.out.println("Botón de puertas abiertas presionado.");
            // Verificar el estado actual de las puertas y actuar en consecuencia
            if (ascensor.getPuerta().estaAbierta()) {
                ascensor.getPuerta().cerrar(); // Cerrar la puerta si está abierta
            } else {
                ascensor.getPuerta().abrir(); // Abrir la puerta si está cerrada
            }
        }
    }
}


