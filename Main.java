import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Inizializziamo lo Scanner per leggere l'input dell'utente
        Scanner scanner = new Scanner(System.in);

        // Array semplice con i nomi degli esercizi della scheda
        String[] esercizi = {"Panca Piana", "Squat", "Trazioni", "Stacco da terra", "Curl bilanciere"};

        // Array parallelo di booleani per tracciare lo stato. Di default in Java partono tutti a 'false'
        boolean[] completati = new boolean[esercizi.length];

        // Variabile booleana che tiene in vita il ciclo del menu
        boolean continua = true;

        System.out.println("=== BENVENUTO NEL TRACKER DI ALLENAMENTO ===");

        // Ciclo while: continua a girare finché 'continua' è true
        while (continua) {
            System.out.println("\nCosa vuoi fare?");
            System.out.println("1) Visualizza scheda");
            System.out.println("2) Segna un esercizio come completato");
            System.out.println("3) Esci");
            System.out.print("Scelta: ");

            int scelta = scanner.nextInt();

            if (scelta == 1) {
                // Opzione 1: Scorriamo l'array degli esercizi con un ciclo for
                System.out.println("\n--- LA TUA SCHEDA ---");
                for (int i = 0; i < esercizi.length; i++) {
                    // Controlliamo l'array dei booleani per stampare il simbolo corretto
                    if (completati[i] == true) {
                        System.out.println((i + 1) + ". [X] " + esercizi[i]);
                    } else {
                        System.out.println((i + 1) + ". [ ] " + esercizi[i]);
                    }
                }
            } else if (scelta == 2) {
                // Opzione 2: Aggiorniamo lo stato dell'esercizio
                System.out.print("Inserisci il numero dell'esercizio completato: ");
                int numeroEsercizio = scanner.nextInt();

                // Controlliamo che il numero inserito sia nel range corretto
                if (numeroEsercizio > 0 && numeroEsercizio <= esercizi.length) {
                    // Sottraiamo 1 perché gli array partono sempre dall'indice 0
                    completati[numeroEsercizio - 1] = true;
                    System.out.println("Ottimo! Esercizio aggiornato.");
                } else {
                    System.out.println("Numero non valido. Riprova.");
                }
            } else if (scelta == 3) {
                // Opzione 3: Cambiamo il booleano a false per interrompere il ciclo while
                continua = false;
                System.out.println("Allenamento terminato. Ottimo lavoro!");
            } else {
                System.out.println("Scelta non valida, inserisci 1, 2 o 3.");
            }
        }

        // Chiudiamo lo scanner per liberare le risorse
        scanner.close();
    }
}