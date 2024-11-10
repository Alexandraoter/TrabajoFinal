public class BotonAscensor extends Boton {
    private int pisoDestino;

    public BotonAscensor(int id, int pisoDestino) {
        super(id, TipoBoton.PISO);
        this.pisoDestino = pisoDestino;
    }

    public int getPisoDestino() {
        return pisoDestino;
    }

    @Override
    public boolean estaFuncionando() {
        return true;
    }

    @Override
    public void presionar() {
        super.presionar();
        System.out.println("Se ha solicitado el piso " + pisoDestino);
    }
}
