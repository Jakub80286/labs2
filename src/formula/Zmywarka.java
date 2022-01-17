package formula;

import java.util.Random;

public class Zmywarka extends Thread{

    int liczba_zapasowych_kapsulek;
    int numer;
    int stan;
    int kapsulkaa;
    Kapsulka kapsulka;
    Random losuj;
    static int ZMIANA_KAPSULKI = 1;
    static int ZMYWA = 2;
    static int KONIEC = 3;
    static int NIEDOMYCIE = 4;

    public Zmywarka(int liczba_zapasowych_kapsulek, int numer, int kapsulkaa) {
        this.liczba_zapasowych_kapsulek = liczba_zapasowych_kapsulek;
        this.numer = numer;
        this.stan = 2;
        this.kapsulka = new Kapsulka(kapsulkaa);
        this.kapsulkaa = kapsulkaa;
        losuj = new Random();
    }

    public void run() {
        while(this.stan != KONIEC) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            switch(this.stan) {
                case 1: {
                    if(this.liczba_zapasowych_kapsulek > 0) {
                        System.out.println("Dla zmywarki nr " + this.numer + " pozostalo " + this.liczba_zapasowych_kapsulek + " zapasowych kapsulek");
                        this.liczba_zapasowych_kapsulek--;
                        this.stan = this.kapsulka.zmien_kapsulki(this.numer);
                    } else {
                        System.out.println("Brak zapasowych kapsulek dla zmywarki " + this.numer);
                        this.stan = KONIEC;
                    }
                } break;
                case 2: {
                    System.out.println("Teraz pracuje zmywarka o numerze "+ this.numer);
                    try {
                        Thread.sleep(1000 * this.kapsulka.czystosc());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(losuj.nextInt(10) == 4) {
                        this.stan = NIEDOMYCIE;
                    }
                } break;
                case 4: {
                    System.out.println("Zmywarka nr " + this.numer + " niedomyla, zmieniam kapsulke");
                    this.stan = ZMIANA_KAPSULKI;
                } break;
                case 5: {
                    if(losuj.nextInt(3) == 1) {
                        System.out.println("W zmywarce o " + this.numer + " zostala zmieniona kapsulka");
                        this.stan = ZMYWA;
                    } else {
                        System.out.println("Zmywarka nr " + this.numer + " nie jest w stanie domyc");
                        this.stan = KONIEC;
                    }
                } break;
            }
        }
    }

}