public class BotonPiso extends Boton {
    private int PisoActual;
    private final int Piso_Maximo;
    private final int Piso_Minimo;
    

    //Constructor
    
    public BotonPiso(boolean estado, boolean sonidoAct, int id, boolean presionado, boolean iluminado,
            boolean bloqueado, TipoBoton tipo, int pisoActual, int piso_Maximo, int piso_Minimo) {
        super(estado, sonidoAct, id, presionado, iluminado, bloqueado, tipo);
        PisoActual = pisoActual;
        Piso_Maximo = piso_Maximo;
        Piso_Minimo = piso_Minimo;
        
    }

    //Getter
    public int getPisoActual() {
        return PisoActual;
    }
    
    public int getPiso_Maximo() {
        return Piso_Maximo;
    }
    public int getPiso_Minimo() {
        return Piso_Minimo;
    }

    //Metodos de funcionamiento
    public void SubirPiso(){
        if(PisoActual<Piso_Maximo){
            PisoActual++;
        }
    }

    public void BajarPiso(){
        if(PisoActual>Piso_Minimo){
        PisoActual--;
        }
    }


    
}
