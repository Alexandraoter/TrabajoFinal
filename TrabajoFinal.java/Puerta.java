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
        // Lógica para verificar el estado de la puerta
        return true; // Ejemplo: retornar true si está funcionando correctamente
    }
}

