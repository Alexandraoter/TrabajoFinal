public class BotonAsensor extends Boton {
    // Atributo adicional para el piso destino
    private int pisoDestino;

    public BotonAsensor(boolean estado, boolean sonidoAct, int id, boolean presionado, boolean iluminado,
            boolean bloqueado, TipoBoton tipo, int pisoDestino) {
        super(estado, sonidoAct, id, presionado, iluminado, bloqueado, tipo);
        this.pisoDestino = pisoDestino;
    }

    public int getPisoDestino() {
        return pisoDestino;
    }

    @Override
    public void presionar() {
        super.presionar();
        // Acción específica para el botón de ascensor:
        System.out.println("Se ha solicitado el piso " + pisoDestino);
    }
}