import java.io.*;

class Main {
    void main() {
        try {
            FileReader fr = new FileReader("tennis.csv");
            BufferedReader br = new BufferedReader(fr);

            String line;
            String[] giocatori = new String[10];
            int i = 0;

            br.readLine();

            while ((line = br.readLine()) != null && i < 10) {
                giocatori[i] = line;
                System.out.println("Lettura: " + line);
                i++;
            }

            br.close();
            fr.close();

            PrintWriter pr = new PrintWriter(new FileWriter("copia.csv"));
            pr.println("Nome,Cognome,Nazione,Ranking_ATP,Titoli_In_Carriera");

            for (int j = 0; j < i; j++) {
                pr.println(giocatori[j]);
            }

            pr.flush();
            pr.close();

            RandomAccessFile raf = new RandomAccessFile("copia.csv", "rw");
            raf.seek(10);
            raf.write('*');
            raf.close();

            System.out.println("File copia.csv creato e modificato con successo!");

        } catch (IOException e) {
            System.out.println("Errore: " + e);
        }
    }

    public static void main(String[] args) {
        new Main().main();
    }
}
