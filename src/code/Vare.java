package code;

public class Vare {
    private String ean;
    private String navn;
    private double pris;
    private boolean tilbud;

    public Vare(String ean, String navn, double pris, boolean tilbud) {
        this.ean = ean;
        this.navn = navn;
        this.pris = pris;
        this.tilbud = tilbud;
    }

    public String getEan() {
        return ean;
    }

    public String getNavn() {
        return navn;
    }

    public double getPris() {
        return pris;
    }

    public boolean isTilbud() {
        return tilbud;
    }
}