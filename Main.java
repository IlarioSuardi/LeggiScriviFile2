import java.io.*;

class Main {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("tennis.csv");
            BufferedReader br = new BufferedReader(fr);

            Tennista[] tennisti = new Tennista[10];
            String line;
            int i = 0;

            String intestazione = br.readLine();

            while ((line = br.readLine()) != null && i < 10) {
                String[] campi = line.split(",");

                Tennista t = new Tennista(
                        campi[0],
                        campi[1],
                        campi[2],
                        Integer.parseInt(campi[3].trim()),
                        Integer.parseInt(campi[4].trim())
                );

                tennisti[i] = t;
                i++;
            }

            br.close();
            fr.close();

            System.out.println("ORDINE PER CLASSIFICA:");
            for (int j = 0; j < i; j++) {
                System.out.println(tennisti[j].toCSV());
            }

            for (int a = 0; a < i - 1; a++) {
                for (int b = a + 1; b < i; b++) {
                    if (tennisti[a].getTitoli() < tennisti[b].getTitoli()) {
                        Tennista t = tennisti[a];
                        tennisti[a] = tennisti[b];
                        tennisti[b] = t;
                    }
                }
            }

            System.out.println("ORDINE PER TITOLI VINTI:");
            for (int j = 0; j < i; j++) {
                System.out.println(tennisti[j].toCSV());
            }

            FileWriter fw = new FileWriter("copia.csv");
            BufferedWriter bw = new BufferedWriter(fw);

            if (intestazione != null) {
                bw.write(intestazione);
                bw.newLine();
            }

            for (int j = 0; j < i; j++) {
                bw.write(tennisti[j].toCSV());
                bw.newLine();
            }

            bw.close();
            fw.close();

        } catch (IOException e) {
            System.out.println("Errore: " + e);
        }
    }
}