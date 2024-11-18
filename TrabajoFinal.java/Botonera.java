import java.util.ArrayList;
import java.util.List;

public class Botonera {
    private List<Boton> botones;
    private int cantidadPisos;

    public Botonera(int cantidadPisos) { 
        botones = new ArrayList<>();
        this.cantidadPisos = cantidadPisos;
    }

    public int getCantidadPisos() {
        return cantidadPisos;
    }

    public void agregarBoton(Boton boton) {
        botones.add(boton);
    }

    public Boton getBotonPorPiso(int piso) {
        return botones.stream()
                .filter(boton -> boton instanceof BotonAscensor && ((BotonAscensor) boton).getPisoDestino() == piso)
                .findFirst()
                .orElse(null);
    }

    public Boton getBotonPorId(int id) {
        return botones.stream()
                .filter(boton -> boton.getId() == id)
                .findFirst()
                .orElse(null);
    }

}
