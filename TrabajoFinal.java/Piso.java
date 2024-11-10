import java.util.ArrayList;
import java.util.List;

public class Piso {
    private int numeroPiso;
    private List<Boton> botones;
    private final float CargaMaxima;
    private int ocupantes;
    private boolean solicitudSubir;
    private boolean solicitudBajar;
    private boolean requiereMantenimiento;
    private boolean enMantenimiento;

    public Piso(int numeroPiso, List<Boton> botones, float cargaMaxima, int ocupantes,
            boolean solicitudSubir, boolean solicitudBajar, boolean requiereMantenimiento, boolean enMantenimiento) {
        this.numeroPiso = numeroPiso;
        this.botones = botones;
        CargaMaxima = 0.0f;
        this.ocupantes = ocupantes;
        this.solicitudSubir = solicitudSubir;
        this.solicitudBajar = solicitudBajar;
        this.requiereMantenimiento = requiereMantenimiento;
        this.enMantenimiento = enMantenimiento;
    }

    public void presionarBotonSubir() {
        if (!enMantenimiento) {
            solicitudSubir = true;
        }
    }

    public void presionarBotonBajar() {
        if (!enMantenimiento) {
            solicitudBajar = true;
        }
    }

    public void agregarOcupante() {
        if (ocupantes < CargaMaxima) {
            ocupantes++;
        }
    }

    public void quitarOcupante() {
        if (ocupantes > 0) {
            ocupantes--;
        }
    }

    public boolean estaLleno() {
        return ocupantes == CargaMaxima;
    }

    public void marcarComoMantenimiento() {
        enMantenimiento = true;
        limpiarSolicitudes();
    }

    public void finalizarMantenimiento() {
        enMantenimiento = false;
    }

    public boolean haySolicitud() {
        return solicitudSubir || solicitudBajar;
    }

    public void limpiarSolicitudes() {
        solicitudSubir = false;
        solicitudBajar = false;
    }
    

}