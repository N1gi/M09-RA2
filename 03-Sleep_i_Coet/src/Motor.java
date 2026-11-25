import java.util.Random;

public class Motor extends Thread {
    private static int siguienteId = 0;
    private int id;
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
    }

    @Override
    public void run() {
        while (true) {
            if (potencia < potenciaObj) {
                potencia++;
                System.out.printf("Motor %d: Incre. Objectiu: %d Actual: %d%n", id, potenciaObj, potencia);
            } else if (potencia > potenciaObj) {
                potencia--;
                System.out.printf("Motor %d: Decre. Objectiu: %d Actual: %d%n", id, potenciaObj, potencia);
            } else {
                System.out.printf("Motor %d: FerRes. Objectiu: %d Actual: %d%n", id, potenciaObj, potencia);
            }
            if (potencia == 0 && potenciaObj == 0) {
                break;
            }

            try {
                sleep(random.nextInt(1001) + 1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
