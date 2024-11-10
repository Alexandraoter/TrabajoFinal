public abstract class Boton {
    private boolean sonidoAct;
    private int id;
    private boolean presionado;
    private boolean iluminado;
    private boolean bloqueado;
    private TipoBoton tipo;

    public Boton(int id, TipoBoton tipo) {
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

    public TipoBoton getTipo() {
        return tipo;
    }

    public void presionar() {
        if (!bloqueado) {
            presionado = true;
            iluminado = true;
            System.out.println("Botón " + tipo + " con ID " + id + " presionado.");
        } else {
            System.out.println("Botón bloqueado, no se puede presionar.");
        }
    }

    public void soltar() {
        presionado = false;
        iluminado = false;
    }

    public abstract boolean estaFuncionando(); // Método abstracto para herencia
}
