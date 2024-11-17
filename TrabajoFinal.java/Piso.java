public class Piso {
    private int numeroPiso;
    private Boton botonSubir;
    private Boton botonBajar;

    public Piso(int numeroPiso) {
        this.numeroPiso = numeroPiso;
        this.botonSubir = new BotonPiso(numeroPiso * 2, EstadoAscensor.Piso, numeroPiso);
        this.botonBajar = new BotonPiso(numeroPiso * 2 + 1, EstadoAscensor.Piso, numeroPiso);
    }

    public void presionarBotonSubir() {
        botonSubir.cambiarEstadoBoton(true);  // Llamada al nuevo método
    }

    public void presionarBotonBajar() {
        botonBajar.cambiarEstadoBoton(true);  // Llamada al nuevo método
    }
}
