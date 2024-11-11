public class Piso {
    private int numeroPiso;
    private Boton botonSubir;
    private Boton botonBajar;

    public Piso(int numeroPiso) {
        this.numeroPiso = numeroPiso;
        this.botonSubir = new BotonPiso(numeroPiso * 2, EstadoAscensor.PISO, numeroPiso);
        this.botonBajar = new BotonPiso(numeroPiso * 2 + 1, EstadoAscensor.PISO, numeroPiso);
    }

    public void presionarBotonSubir() {
        botonSubir.presionar();
    }

    public void presionarBotonBajar() {
        botonBajar.presionar();
    }
}
