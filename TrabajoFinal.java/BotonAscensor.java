public class BotonAscensor extends Boton {
    private int pisoDestino;
    private Ascensor ascensor;

    public BotonAscensor(int id, int pisoDestino, Ascensor ascensor) { 
        super(false, id, false, false, false, EstadoAscensor.PISO); // Llamada al constructor de Boton this.pisoDestino = pisoDestino; }
        this.pisoDestino = pisoDestino;
        this.ascensor = ascensor;
    }

    public int getPisoDestino() {
        return pisoDestino;
    }

    
    @Override
    public void presionar() {
        super.presionar();
        System.out.println("Se ha solicitado el piso " + pisoDestino);
    }
}
