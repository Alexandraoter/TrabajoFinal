public class BotonPuertasAbiertas extends Boton {

    private Ascensor ascensor;

    // Constructor con parámetros simplificados
    public BotonPuertasAbiertas(int id, Ascensor ascensor) {
        // Llamada al constructor de la clase base Boton (con valores predeterminados o adecuados)
        super(false,id, false, false, false, EstadoAscensor.Piso);
        this.ascensor = ascensor;
    }

    @Override
    public void presionar() {
        super.presionar(); // Llamada al método presionar de la clase base Boton
        System.out.println("Botón de puertas abiertas presionado.");
        ascensor.alternarPuertas();  // Llamada al método que alterna entre abrir y cerrar las puertas
    }
}

