import java.util.ArrayList;
import java.util.List;

public class Botonera {
    private List<Boton> botones;

    public Botonera() {
        botones = new ArrayList<>();
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

    public List<Boton> getTodosLosBotones() {
        return botones;
    }
}
