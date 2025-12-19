class Tennista {
    private String nome;
    private String cognome;
    private String nazione;
    private int rankingATP;
    private int titoli;

    public Tennista(String nome, String cognome, String nazione, int rankingATP, int titoli) {
        this.nome = nome;
        this.cognome = cognome;
        this.nazione = nazione;
        this.rankingATP = rankingATP;
        this.titoli = titoli;
    }

    public int getTitoli() {
        return titoli;
    }

    public String toCSV() {
        return nome + "," + cognome + "," + nazione + "," + rankingATP + "," + titoli;
    }
}