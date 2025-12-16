package util;

import code.Vare;
import java.util.ArrayList;
import java.util.List;

public class VareLoader {

    private static FileIO io = new FileIO();

    public static List<Vare> loadVarer(String path) {
        List<Vare> varer = new ArrayList<>();
        ArrayList<String> lines = io.readData(path);

        for (String line : lines) {
            String[] parts = line.split(";");
            String ean = parts[0];
            String navn = parts[1];
            double pris = Double.parseDouble(parts[3]);

            varer.add(new Vare(ean, navn, pris, false));
        }

        return varer;
    }

    public static List<Vare> loadTilbud(String path) {
        List<Vare> tilbudVarer = new ArrayList<>();
        ArrayList<String> lines = io.readData(path);

        for (String line : lines) {
            String[] parts = line.split(";");
            String ean = parts[0];
            String navn = parts[1];
            double pris = Double.parseDouble(parts[3]);

            tilbudVarer.add(new Vare(ean, navn, pris, true));
        }

        return tilbudVarer;
    }
}
