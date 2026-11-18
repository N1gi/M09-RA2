
public class Main {
    public static void main(String[] args) {
        String[] names = {
            "Piqué", "Vinicius", "Torres", "Ramos",
            "Ronaldo", "Lewan", "Belli", "Arnau",
            "Aspas", "Messi", "Mbappé"
        };

        Futbolista[] futbolistas = new Futbolista[Futbolista.NUM_JUGADORS];

        for (int i = 0; i < futbolistas.length; i++) {
            futbolistas[i] = new Futbolista(names[i]);
        }

        for (int i = 0; i < futbolistas.length; i++) {
            futbolistas[i].start();
        }

        for (int i = 0; i < futbolistas.length; i++) {
            try {
                futbolistas[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < futbolistas.length; i++) {
            System.out.printf("%-10s -> %2d gols%n",
                futbolistas[i].getName(),
                futbolistas[i].getGols());
        }
    }
}
