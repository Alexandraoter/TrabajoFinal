public class Puerta {
    private boolean abierta;
    private boolean obstaculoPresente;

    public Puerta() {
        this.obstaculoPresente = false;
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

    public void abrir() {
        abierta = true;
    }

    // Método para cerrar la puerta
    public void cerrar() {
        if (obstaculoPresente){
            System.out.println("No se puede cerrar la puerta, obstáculo detectado");

        }else{
            System.out.println("Cerrando puerta");
            System.out.println("Puerta cerrada");
            obstaculoPresente = false;
        }
    }
    
    public boolean estaFuncionando() {
        return true; // Ejemplo de verificación del funcionamiento
    }

    public boolean isAbierta() {
        return abierta;
    }
}
