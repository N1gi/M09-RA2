
public class PrincipalEstricte {
    public static void main(String[] args) {

        Fil f1 = new Fil("Juan", 3);
        Fil f2 = new Fil("Pepe",3);

        f1.start();
        f2.start();

        System.out.println("Termina thread main");
    }
}
