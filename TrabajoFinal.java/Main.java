public class Main {
    public static void main(String[] args) {
        // Crear sistema de control con 10 pisos y 2 ascensores
        SistemaControl sistemaControl = new SistemaControl(10, 1);

        // Simulación: solicitud de ascensor desde el piso 1 al piso 5
        sistemaControl.solicitarAscensor(5, 3);

        // Monitorear sistema
        sistemaControl.monitorearSistema();

        // Gestionar emergencia (detener todos los ascensores)
        sistemaControl.gestionarEmergencia();
    }
}

