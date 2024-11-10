import java.util.List;

public class SistemControl {
   private List<Ascensor> ascensores;
   private String generarAlerta;

    public void gestionarEmergencia() {
        // Detener todos los ascensores y enviar una alerta
        for (Ascensor ascensor : ascensores) {
            ascensor.parar(); // Método para detener el ascensor
            // ... otras acciones de emergencia
        }
    } 

    public void generarAlerta(String mensaje) {
        // Código para generar la alerta, como imprimir el mensaje, enviar una notificación, etc.
        System.out.println("Alerta: " + mensaje); // Ejemplo básico
    }

    public void monitorearSistema() {
        for (Ascensor ascensor : ascensores) {
            // Monitorear el estado de la puerta
            if (!ascensor.getPuerta().estaFuncionando()) {
                generarAlerta("Falla en la puerta del ascensor " + ascensor.getPisoActual());
            }
    
            // Monitorear el estado de los botones
            for (Boton boton : ascensor.getBotones()) {
                if (!boton.estaFuncionando()) {
                    generarAlerta("Falla en el botón " + boton.getId() + " del ascensor " + ascensor.getPisoActual());
                }
            }
    
            // Monitorear el sistema de dirección (implementar lógica específica)
            if (!ascensor.sistemaDireccionFunciona()) {
                generarAlerta("Falla en el sistema de dirección del ascensor " + ascensor.getPisoActual());
            }
        }
    }
}
