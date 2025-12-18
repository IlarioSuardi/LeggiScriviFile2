import java.io.*;

class Main {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("tennis.csv");
            BufferedReader br = new BufferedReader(fr);

            Tennista[] tennisti = new Tennista[10];
            String line;
            int i = 0;

            br.readLine();

            while ((line = br.readLine()) != null && i < 10) {
                String[] campi = line.split(",");

                Tennista t = new Tennista(
                        campi[0],
                        campi[1],
                        campi[2],
                        Integer.parseInt(campi[3]),
                        Integer.parseInt(campi[4])
                );

                tennisti[i] = t;
                i++;
            }

            br.close();
            fr.close();

            System.out.println("Oggetti creati:");
            for (int j = 0; j < i; j++) {
                System.out.println(tennisti[j].toString());
            }

        } catch (IOException e) {
            System.out.println("Errore: " + e);
        }
    }
}
