public class BotonPiso extends Boton {
    private int pisoActual;

    public BotonPiso(int id, EstadoAscensor tipo, int pisoActual) {
        super(false, id, false, false, false, EstadoAscensor.PISO);
        this.pisoActual = pisoActual;
    }

    public int getPisoActual() {
        return pisoActual;
    }

    @Override
    public void presionar() {
        super.presionar();
        System.out.println("Solicitud en el piso " + pisoActual);
    }
}
