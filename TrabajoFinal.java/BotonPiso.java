public class BotonPiso extends Boton {
    private int pisoActual;

    public BotonPiso(int id, TipoBoton tipo, int pisoActual) {
        super(id, tipo);
        this.pisoActual = pisoActual;
    }

    public int getPisoActual() {
        return pisoActual;
    }

    @Override
    public boolean estaFuncionando() {
        // Implementación específica para verificar el estado de funcionamiento del botón
        return true;
    }

    @Override
    public void presionar() {
        super.presionar();
        System.out.println("Solicitud en el piso " + pisoActual);
    }
}
