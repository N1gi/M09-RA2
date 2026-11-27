public class Administracio {
    private static final int num_poblacio_activa = 50;
    private static final Treballador[] poblacio_activa = new Treballador[num_poblacio_activa];

    public Administracio() {
        for (int i = 0; i < num_poblacio_activa; i++) {
            poblacio_activa[i] = new Treballador("Ciutadà-" + (i), 25000, 20, 65);
        }
    }

    public static void inici() {
        for (Treballador ciutada : poblacio_activa) {
            ciutada.start();
        }

        for (Treballador ciutada : poblacio_activa) {
            try {
                ciutada.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for (Treballador ciutada : poblacio_activa) {
            System.out.printf("%-10s -> edat: %d / total: %.2f%n", ciutada.getName(), ciutada.getEdat(), ciutada.getCobrat());
        }        
    }

    public static void main(String[] args) {
        Administracio ad = new Administracio();
        inici();
    }
}
