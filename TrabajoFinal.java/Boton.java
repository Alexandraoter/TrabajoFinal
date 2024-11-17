public abstract class Boton {
    private boolean sonidoAct;
    private int id;
    private boolean presionado;
    private boolean iluminado;
    private boolean bloqueado;
    private EstadoAscensor tipo;

    public Boton(int id, EstadoAscensor tipo) {
        this.sonidoAct = false;
        this.id = id;
        this.presionado = false;
        this.iluminado = false;
        this.bloqueado = false;
        this.tipo = tipo;
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

    public EstadoAscensor getTipo() {
        return tipo;
    }


        public void cambiarEstadoBoton(boolean presionar) {
            if (presionar) {
                if (!bloqueado) {
                    this.presionado = true;
                    this.iluminado = true;   // Encendemos el indicador luminoso
                    this.sonidoAct = true;   // Activamos el sonido
                    System.out.println("Botón del " + tipo + " - " + id + " ha sido presionado. El indicador luminoso está activo y el sonido se ha activado.");
                }
            } else {
                if (this.presionado) {
                    this.presionado = false;
                    this.iluminado = false;  // Apagamos el indicador luminoso
                    this.sonidoAct = false;  // Desactivamos el sonido
                    System.out.println("El botón con ID " + id + " ha sido soltado. El indicador luminoso se ha desactivado y el sonido también.");
                }
            }
        }
}
