public class Futbolista extends Thread {
    public static final int NUM_JUGADORS = 11;
    private final int NUM_TIRADES = 20;
    private final double PROBABILITAT = 0.5;

    private int ngols;
    private int ntirades;

    public Futbolista(String name) {
        super(name);
        ngols = 0;
        ntirades = 0;
    }

    @Override
    public void run() {
        for (int i = ntirades; i < NUM_TIRADES; i++) {
            if (Math.random() > PROBABILITAT) {
                ngols++;
            }
        }
    }

    public int getGols() {
        return ngols;
    }
}
