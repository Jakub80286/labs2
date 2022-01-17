package formula;

import java.util.Random;

public class Kapsulka {
    static int MOCNA = 1;
    static int NORMALNA = 2;
    static int SLABA = 3;

    int rodzaj;
    int czystosc;
    boolean wsadzona;
    public Kapsulka(int rodzaj) {
        this.rodzaj = rodzaj;
        if(this.rodzaj == MOCNA)
            this.czystosc = 3;
        else if(this.rodzaj == NORMALNA)
            this.czystosc = 2;
        else if(this.rodzaj == SLABA)
            this.czystosc = 1;
        else
            this.czystosc = 0;
        Random rand = new Random();
        if(rand.nextInt(20) == 10)
            this.wsadzona = true;
        else
            this.wsadzona = false;
    }

    public int zmien_kapsulki(int numer) {
        if(!this.wsadzona) {
            System.out.println("Zmywarka o numerze " + numer + " nie ma kapsulki");
            return 1;
        } else {
            System.out.println("Zmywarka o numerze " + numer+ " nie domyla wszystkiego i nalezy umyc jeszcze raz");
            return 2;
        }
    }

    public int czystosc() {
        return this.czystosc;
    }
}