import java.util.Scanner;

public class Coet {
    public static Motor[] motors = new Motor[4];
    public static void main(String[] args) {
        for (int i = 0; i < motors.length; i++) {
            motors[i] = new Motor();
        } 
        arranca(motors);
        Scanner sc = new Scanner(System.in);
        int potencia = sc.nextInt();
        passaAPotencia(potencia);
        for (Motor motor : motors) {
                if (motor.getPotencia() == 0) {
                    break;
                }
            }
    }

    public static void arranca(Motor[] motors) {
        for (Motor motor : motors ) {
            motor.start();
        }
    }
    
    public static void passaAPotencia(int potencia) {
        System.out.println("Passant a potencia " + potencia);
        for (Motor motor : motors) {
            motor.setPotencia(potencia);
        }
    }
}
