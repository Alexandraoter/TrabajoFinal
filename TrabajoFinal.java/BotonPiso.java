public class BotonPiso extends Boton {
    private int PisoActual;
    private final int Piso_Maximo;
    private final int Piso_Minimo;
    private final float CargaMaxima;
    private float CargaActual;

    //Constructor
    
    public BotonPiso(boolean estado, boolean sonidoAct, int id, boolean presionado, boolean iluminado,
            boolean bloqueado, TipoBoton tipo, int pisoActual, int piso_Maximo, int piso_Minimo, float cargaMaxima,
            float cargaActual) {
        super(estado, sonidoAct, id, presionado, iluminado, bloqueado, tipo);
        PisoActual = pisoActual;
        Piso_Maximo = piso_Maximo;
        Piso_Minimo = piso_Minimo;
        CargaMaxima = 0.0f;
        CargaActual = cargaActual;
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
    public float getCargaMaxima() {
        return CargaMaxima;
    }

    public float getCargaActual(){
        return CargaActual;
    }

    //Metodos de funcionamiento
    public void SubirPiso(){
        if(PisoActual<Piso_Maximo && CargaActual<=CargaMaxima){
            PisoActual++;
        }else{
            System.out.println("Lo siento, has excedido el peso máximo de carga");
        }
    }

    public void BajarPiso(){
        if(PisoActual>Piso_Minimo && CargaActual<=CargaMaxima){
        PisoActual--;
        }else{
            System.out.println("Lo siento, has excedido el peso máximo de carga");
        }
    }

    /*   
    public void AgregarPeso(float peso){
        if(peso>0){
            CargaActual= CargaActual+peso;
        }else{
            System.out.println("Error en el peso");
        }
        
    }*/

    //en caso que se exceda del peso permitido dentro del ascensor
    public void QuitarPeso(float peso){
        if(peso>0){
            CargaActual=CargaActual-peso;
            if(CargaActual<0){
                CargaActual=0;
            }
        }else{
            System.out.println("Error en el peso disminuido");;
        }
        
    }


    
}
