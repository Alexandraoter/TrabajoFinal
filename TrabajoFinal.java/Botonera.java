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

    //Este método busca un botón en la lista botones que corresponda a un piso específico.
    public Boton getBotonPorPiso(int piso) {
        for (Boton boton : botones) {
            if (boton instanceof BotonAscensor) {
                BotonAscensor botonAscensor = (BotonAscensor) boton;
                if (botonAscensor.getPisoDestino() == piso) {
                    return botonAscensor;  // Retorna el botón encontrado
                }
            }
        }
        return null;  // Si no se encuentra el botón, retorna null
    }
    

    //Este método busca un botón en la lista botones basándose en el ID del botón.
    public Boton getBotonPorId(int id) {
        for (Boton boton : botones) {
            if (boton.getId() == id) {
                return boton;
            }
        }
        return null;
        
    }

}
