import java.util.Random;

public class Motor extends Thread {
    private static int siguienteId = 0;
    private int id;
    private boolean aturat = true;
    private int potencia = 0;
    private int potenciaObj = 0;
    Random random = new Random();

    public Motor() {
        this.id = siguienteId++;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potenciaObj) {
        this.potenciaObj = potenciaObj;
        aturat = false;
    }

    @Override
    public void run() {
        while (!aturat) {
            if (potencia < potenciaObj) {
                potencia++;
                System.out.printf("Motor %d: Incre. Objectiu: %d Actual: %d%n", id, potenciaObj, potencia);
            } 
            else if (potencia > potenciaObj) {
                potencia--;
                System.out.printf("Motor %d: Decre. Objectiu: %d Actual: %d%n", id, potenciaObj, potencia);
            } 
            else {
                System.out.printf("Motor %d: FerRes. Objectiu: %d Actual: %d%n", id, potenciaObj, potencia);
            }
            if (potencia == 0 && potenciaObj == 0) {
                aturat = true;
                break;
            }

            try {
                sleep(1000 + random.nextInt(1001));
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
