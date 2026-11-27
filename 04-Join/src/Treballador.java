import java.util.Random;

public class Treballador extends Thread {
    private float sou_anual_brut;
    private int edat_inici;
    private int edat_final;
    private int edat_actual;
    private float cobrat;
    private Random rnd = new Random();

    public Treballador(String name, float sou_anual_brut, int edat_inici, int edat_final) {
        super(name);
        this.sou_anual_brut = sou_anual_brut;
        this.edat_inici = edat_inici;
        this.edat_final = edat_final;
        edat_actual = 0;
        cobrat = 0.0f;
    }

    @Override 
    public void run() {
        edat_actual = edat_inici;
        while (edat_actual < edat_final) {
            for (int i = 0; i < 12; i++) {
                cobra();
                pagaImpostos();
                try {
                    Thread.sleep(rnd.nextInt(100));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            edat_actual++;
        }
    }

    public float getCobrat() {
        return cobrat;
    }

    public int getEdat() {
        return edat_actual;
    }   

    private void cobra() {
        cobrat = cobrat + (sou_anual_brut / 12);
    }

    private void pagaImpostos() {
        cobrat = cobrat - ((sou_anual_brut / 12) * 0.24f);
    }

}
