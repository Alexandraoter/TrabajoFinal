public class Puerta {
    private boolean abierta;


    public void abrir() {
        abierta = true;
        System.out.println("Puerta abierta");
    }

    public void cerrar() {
        abierta = false;
        System.out.println("Puerta cerrada");
    }

    public boolean estaFuncionando() {
        return true; // Ejemplo de verificación del funcionamiento
    }

    public boolean isAbierta() {
        return abierta;
    }
}
