package formula;

import java.util.Random;

public class Main {
    static int ilosc_zmywarek = 20;
    static Random random = new Random();

    public static void main(String[] args) {
        for(int i = 1; i <= ilosc_zmywarek; i++) {
            new Zmywarka(random.nextInt(5), i, random.nextInt(3) + 1).start();
        }
    }
}