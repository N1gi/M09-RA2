import java.util.Random;

public class DormAleatori extends Thread {
    long time;
    Random random = new Random();

    public DormAleatori (String name) {
        super(name);
        time = System.currentTimeMillis();
    }

    @Override 
    public void run() {
            for (int i = 0; i < 10; i++) {
                int randomNum = random.nextInt(1000);
                long total = System.currentTimeMillis() - time;
                
                System.out.printf("%-4s(%d) a dormir  %3dms total  %4dms%n", getName(), i, randomNum, total);

                try {
                    sleep(randomNum);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
    }

    public static void main(String[] args) {
        DormAleatori f1 = new DormAleatori("Joan");
        DormAleatori f2 = new DormAleatori("Pep");

        f1.start();;
        f2.start();;
        System.out.println("-- Fi de main -----------");
    }
}
