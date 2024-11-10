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
            // Busca el botón correspondiente al piso dado
            return botones.stream()
                    .filter(boton -> boton.getId() == piso)
                    .findFirst()
                    .orElse(null);
        }
    
        public Boton getBotonPorId(int id) {
            // Busca el botón por su ID único
            return botones.stream()
                    .filter(boton -> boton.getId() == id)
                    .findFirst()
                    .orElse(null);
        }
}

