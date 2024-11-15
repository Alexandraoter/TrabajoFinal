public class Main {
    public static void main(String[] args) {
        // Crear un sistema de control con 5 pisos y 2 ascensores
        SistemaControl sistemaControl = new SistemaControl(5, 2);

        // Obtener el primer ascensor del sistema
        Ascensor ascensor1 = sistemaControl.getAscensores().get(0);

        // Simular solicitudes de ascensor
        System.out.println("\n** Solicitud 1: Piso 1 -> Piso 3 **");
        sistemaControl.solicitarAscensor(1, 3);
        activarIndicadores(ascensor1, 1, 3);
        mantenerPuertasAbiertas(ascensor1);

        System.out.println("\n** Solicitud 2: Piso 2 -> Piso 4 **");
        sistemaControl.solicitarAscensor(2, 4);
        activarIndicadores(ascensor1, 2, 4);
        mantenerPuertasAbiertas(ascensor1);

        System.out.println("\n** Solicitud 3: Piso 3 -> Piso 1 **");
        sistemaControl.solicitarAscensor(3, 1);
        activarIndicadores(ascensor1, 3, 1);
        mantenerPuertasAbiertas(ascensor1);

        System.out.println("\n** Solicitud 4: Piso 4 -> Piso 2 **");
        sistemaControl.solicitarAscensor(4, 2);
        activarIndicadores(ascensor1, 4, 2);
        mantenerPuertasAbiertas(ascensor1);

        System.out.println("\n** Solicitud 5: Piso 5 -> Piso 3 **");
        sistemaControl.solicitarAscensor(5, 3);
        activarIndicadores(ascensor1, 5, 3);
        mantenerPuertasAbiertas(ascensor1);

        // Realizar una emergencia
        System.out.println("\n** Simulando emergencia... **");
        sistemaControl.gestionarEmergencia();
        ascensor1.parar();

        // Monitorear el sistema
        System.out.println("\n** Monitoreo del sistema: **");
        sistemaControl.monitorearSistema();

        // Solicitar el ascensor nuevamente después de la emergencia
        System.out.println("\n** Solicitud 6: Piso 2 -> Piso 5 **");
        if (!sistemaControl.estaEnEmergencia()) {
            sistemaControl.solicitarAscensor(2, 5);
            activarIndicadores(ascensor1, 2, 5);
            mantenerPuertasAbiertas(ascensor1);
        } else {
            System.out.println("El sistema está en emergencia. No se puede procesar más solicitudes.");
        }
    }

    // Método para activar los indicadores luminosos y sonoros en los botones
    private static void activarIndicadores(Ascensor ascensor, int pisoOrigen, int pisoDestino) {
        Boton botonOrigen = ascensor.getBotonera().getBotonPorPiso(pisoOrigen);
        Boton botonDestino = ascensor.getBotonera().getBotonPorPiso(pisoDestino);

        if (botonOrigen != null) {
            botonOrigen.presionar();
        }
        if (botonDestino != null) {
            botonDestino.presionar();
        }

        // Esperamos a que el ascensor termine su movimiento
        try {
            Thread.sleep(2000); // Simula el tiempo de movimiento del ascensor
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (botonOrigen != null) {
            botonOrigen.soltar();
        }
        if (botonDestino != null) {
            botonDestino.soltar();
        }
    }

    // Método para mantener las puertas abiertas
    private static void mantenerPuertasAbiertas(Ascensor ascensor) {
        System.out.println("Presionando el botón para mantener las puertas abiertas");
        ascensor.abrirPuerta(); // Mantener las puertas abiertas
        System.out.println("Las puertas permanecerán abiertas.");
    }
}
