public class Asensor {
    private int PisoActual;
    private final int PISO_MAXIMO;
    private final int PISO_MINIMO;
    private final float CargaMaxima;

    public Asensor(int pisoActual, int pISO_MAXIMO, int pISO_MINIMO, float cargaMaxima) {
        PisoActual = pisoActual;
        PISO_MAXIMO = pISO_MAXIMO;
        PISO_MINIMO = pISO_MINIMO;
        CargaMaxima = cargaMaxima;
    }

    public int getPisoActual() {
        return PisoActual;
    }

    public int getPISO_MAXIMO() {
        return PISO_MAXIMO;
    }

    public int getPISO_MINIMO() {
        return PISO_MINIMO;
    }

    public float getCargaMaxima() {
        return CargaMaxima;
    }

    

    
    
}