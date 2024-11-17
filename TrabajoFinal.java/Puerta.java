public class Puerta {
    private boolean abierta;
    private boolean obstaculoPresente;

    public Puerta() {
        this.abierta = false;
        this.obstaculoPresente = false;
    }

    public boolean estaAbierta() {
        return abierta;
    }

    public boolean isObstaculoPresente() { 
        return obstaculoPresente; 
    } 
    
    public void detectarObstaculo() { 
        obstaculoPresente = true; 
        System.out.println("Obstáculo detectado en la puerta."); 
    } 
    
    public void limpiarObstaculo() { 
        obstaculoPresente = false; 
        System.out.println("Obstáculo removido de la puerta."); 
    }

    public void abrir(){
            abierta = true;   
    }
    

    // Método para cerrar la puerta
    public void cerrar() {
        if (obstaculoPresente){
            abierta= false;
            System.out.println("Puerta cerrada");

        }else if (obstaculoPresente){
            System.out.println("No se puede cerrar la puerta hay un obstáculo");
        }
    }
    
    public boolean isFuncionando() {
        return true; 
    }

    public boolean isAbierta() {
        return abierta;
    }
}
