import java.util.Scanner;

public class Coet {
    public static Motor[] motors = new Motor[4];
    public static void main(String[] args) {
        for (int i = 0; i < motors.length; i++) {
            motors[i] = new Motor();
        }
        Scanner sc = new Scanner(System.in);
        boolean aturat = true;
        int potencia = -1;
        while (potencia != 0) {
            potencia = sc.nextInt();
            passaAPotencia(potencia);
            if (potencia == 0) {
                return;
            }
            if (aturat) {
                arranca(motors);
                aturat = false;
            }
        }
    }

    public static void arranca(Motor[] motors) {
        for (Motor motor : motors ) {
            motor.start();
        }
    }
    
    public static void passaAPotencia(int potencia) {
        System.out.println("Passant a potència " + potencia);
        for (Motor motor : motors) {
            motor.setPotencia(potencia);
        }
    }
}
