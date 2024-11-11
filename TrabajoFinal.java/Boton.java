public abstract class Boton {
    private boolean sonidoAct;
    private int id;
    private boolean presionado;
    private boolean iluminado;
    private boolean bloqueado;
    private EstadoAscensor tipo;

    public Boton(boolean sonidoAct, int id, boolean presionado, boolean iluminado, boolean bloqueado, EstadoAscensor tipo) {
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

    public void presionar() {
        if (!bloqueado) {
            presionado = true;
            iluminado = true;
            System.out.println("Botón " + tipo + " con ID " + id + " ha sido presionado y esta iluminado");
        } else {
            System.out.println("Botón bloqueado, no se puede presionar.");
        }
    }

    public void soltar() {
        if (presionado){
            presionado=false;
            iluminado=false;
            System.out.println("El botón con ID: " + id + " ha sido soltado y ya no está iluminado.");
        }else{
            System.out.println("El botón ya no estaba presionado");
        }
    }
}
