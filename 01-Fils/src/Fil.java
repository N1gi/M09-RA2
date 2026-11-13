
public class Fil extends Thread {
    private static boolean tornJuan = true;
    private int num = 1;
    private String nom;
    private int mode;

    public Fil(String nom, int mode) {
        this.nom = nom;
        this.mode = mode;
    }

    @Override
    public void run() {
        if (mode == 3) {
            runEstricte();
        } else {
            runNormal();
        }
    }

    private void runNormal() {
        while (num < 10) {
            System.out.println(nom + " " + num);
            num++;
        }

        System.out.println("Acaba el fil " + nom);
    }

    private void runEstricte() {
        while (num < 10) {

            if (nom.equals("Juan") == tornJuan) {
                System.out.println(nom + " " + num);
                num++;
                tornJuan = !tornJuan;
            }

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        System.out.println("Termina el fil " + nom);
    }
}
