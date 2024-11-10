public class Boton {
    private boolean sonidoAct; 
    private int id;// identifica cada boton independientemente
    private boolean presionado;
    private boolean iluminado;
    private boolean bloqueado;
    private TipoBoton tipo;

    public Boton(boolean estado, boolean sonidoAct, int id, boolean presionado, boolean iluminado, boolean bloqueado,
            TipoBoton tipo) {
        this.sonidoAct = false;
        this.id = id;
        this.presionado = false;
        this.iluminado = false;
        this.bloqueado = false;
        this.tipo = tipo;
    }

    //esta preguntando sí el metodo esta o no en funcionamiento
    public boolean isSonidoAct() {
        return sonidoAct;
    }

    public int getId() {
        return id;
    }

    public boolean isPresionado() {
        return presionado;
    }

    public boolean isIluminado() {
        return iluminado;
    }

    public boolean isBloqueado() {
        return bloqueado;
    }

    public TipoBoton getTipo() {
        return tipo;
    }

    
    public void presionar() {
        if (!bloqueado) {
            presionado = true;
            iluminado = true;
            // Aquí se realizarían las acciones específicas al presionar el botón,
            // como enviar una señal al sistema de control del ascensor
        }else{
            System.out.println("No precionaste bien el boton, intentalo nuevamente");
        }
    }

    // Método para soltar el botón
    public void soltar() {
        presionado = false;
        iluminado = false;
    }
    
    public boolean estaFuncionando() {
        // Lógica para verificar el estado del botón
        return true; // Ejemplo: retornar true si está funcionando correctamente
    }

    

}  