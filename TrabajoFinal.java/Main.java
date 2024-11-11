public class Main {
    public static void main(String[] args) {
        // Crear un sistema de control con 5 pisos y 2 ascensores
        SistemaControl sistemaControl = new SistemaControl(5, 2);

        // Simular solicitudes de ascensor
        System.out.println("\n** Solicitud 1: Piso 1 -> Piso 3 **");
        sistemaControl.solicitarAscensor(1, 3);

        System.out.println("\n** Solicitud 2: Piso 2 -> Piso 4 **");
        sistemaControl.solicitarAscensor(2, 4);

        System.out.println("\n** Solicitud 3: Piso 3 -> Piso 1 **");
        sistemaControl.solicitarAscensor(3, 1);

        System.out.println("\n** Solicitud 4: Piso 4 -> Piso 2 **");
        sistemaControl.solicitarAscensor(4, 2);

        // Simular solicitudes adicionales mientras el ascensor ya está en movimiento
        System.out.println("\n** Solicitud 5: Piso 5 -> Piso 3 **");
        sistemaControl.solicitarAscensor(5, 3);

        // Realizar una emergencia
        System.out.println("\n** Simulando emergencia... **");
        sistemaControl.gestionarEmergencia();

        // Monitorear el sistema
        System.out.println("\n** Monitoreo del sistema: **");
        sistemaControl.monitorearSistema();

        // Solicitar el ascensor nuevamente después de la emergencia
        System.out.println("\n** Solicitud 6: Piso 2 -> Piso 5 **");
        sistemaControl.solicitarAscensor(2, 5);
    }
}
