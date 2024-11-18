public class Main {
    public static void main(String[] args) {
        // Crear un sistema de control con 5 pisos y 3 ascensores
        SistemaControl sistemaControl = new SistemaControl(5, 2);

        // Obtener los primeros dos ascensores del sistema
        Ascensor ascensor1 = sistemaControl.getAscensores().get(0);
        Ascensor ascensor2 = sistemaControl.getAscensores().get(1);

        
        //SIMULACION

        System.out.println("\n Solicitud 1: Ascensor 3, Piso 2 -> Piso 3 ");
        sistemaControl.solicitarAscensor(3, 2, 3);

        System.out.println("\n Solicitud 2: Piso 1 -> Piso 3 ");
        activarIndicadores(ascensor2, 1, 3);
        sistemaControl.solicitarAscensor(1, 1, 3);
        ascensor1.cerrarPuerta();
        ascensor2.cerrarPuerta();
        mantenerPuertasAbiertas(ascensor2);

        System.out.println("\n Solicitud 3: Piso 2 -> Piso 2 ");
        activarIndicadores(ascensor1, 2, 2);
        sistemaControl.solicitarAscensor(2, 2, 2);
        ascensor2.cerrarPuerta();
        mantenerPuertasAbiertas(ascensor1);
        desactivarPuertasAbiertas(ascensor1);

        // Simulando una solicitud con un piso incorrecto
        System.out.println("\n Solicitud 4: Piso -1 -> Piso 4 ");
        sistemaControl.solicitarAscensor(2, -1, 4);

        System.out.println("\n Solicitud 5: Piso 5 -> Piso 8 ");
        sistemaControl.solicitarAscensor(1, 5, 8);

        // Simular un obstáculo durante el cierre de la puerta
        System.out.println("\nSimulación de obstáculo en la puerta ");
        ascensor1.getPuerta().detectarObstaculo();
        ascensor1.cerrarPuerta();
        ascensor1.getPuerta().limpiarObstaculo();
        ascensor1.cerrarPuerta();

        System.out.println("\nSimulación de obstáculo en la puerta ");
        ascensor2.getPuerta().detectarObstaculo();
        ascensor2.cerrarPuerta();
        ascensor2.getPuerta().limpiarObstaculo();
        ascensor2.cerrarPuerta();

        System.out.println("//-----------------------------------------------------------------------------------------------------------------------");

        // Realizar una emergencia
        System.out.println("\nSimulando emergencia...");
        sistemaControl.gestionarEmergencia();
        ascensor1.parar();

        // Mensaje de emergencia
        System.out.println("Mensaje de emergencia");
        sistemaControl.generarAlerta("Ascensor en estado de emergencia");
        ascensor1.parar();

        // Monitorear el sistema
        System.out.println("\n Monitoreo del sistema: ");
        sistemaControl.monitorearSistema();

        // Solicitar el ascensor nuevamente después de la emergencia
        System.out.println("\n Solicitud 6: Piso 2 -> Piso 5 ");
        if (!sistemaControl.estaEnEmergencia()) {
            activarIndicadores(ascensor1, 2, 5);
            sistemaControl.solicitarAscensor(1, 2, 5);  // Cambié el piso de origen para no confundirlo
            ascensor1.moverAlPiso(5);
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
            botonOrigen.cambiarEstadoBoton(true);
        }
        if (botonDestino != null) {
            botonDestino.cambiarEstadoBoton(true);
        }

        // Esperamos a que el ascensor termine su movimiento
        try {
            Thread.sleep(2000); // Simula el tiempo de movimiento del ascensor
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (botonOrigen != null) {
            botonOrigen.cambiarEstadoBoton(false);;
        }
        if (botonDestino != null) {
            botonDestino.cambiarEstadoBoton(false);;
        }
    }

    // Método para mantener las puertas abiertas
    private static void mantenerPuertasAbiertas(Ascensor ascensor) {
        System.out.println("Presionando el botón para mantener las puertas abiertas");
        ascensor.abrirPuerta(); // Mantener las puertas abiertas
        System.out.println("Las puertas permanecerán abiertas.");
    }

    private static void desactivarPuertasAbiertas(Ascensor ascensor) {
        System.out.println("El botón para desactivar las puertas ha sido presionado");
        ascensor.cerrarPuerta();
        System.out.println("Las puertas están cerradas.");
    }
}
