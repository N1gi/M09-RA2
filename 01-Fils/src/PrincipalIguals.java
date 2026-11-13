public class PrincipalIguals {
    public static void main(String[] args) {
        Fil f1 = new Fil("Pepe", 1);
        Fil f2 = new Fil("Juan", 1);

        f1.setPriority(Thread.MAX_PRIORITY);
        f2.setPriority(Thread.MAX_PRIORITY);

        f1.start();
        f2.start();

        System.out.println("Acaba thread main");
    }

}
