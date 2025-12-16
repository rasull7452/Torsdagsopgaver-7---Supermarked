package code;

import util.VareLoader;
import java.util.*;

public class KasseApparat {

    private Map<String, Vare> alleVarer = new HashMap<>();

    public void loadData() {
        List<Vare> varer = VareLoader.loadVarer("src/data/varer.csv");
        List<Vare> tilbud = VareLoader.loadTilbud("src/data/tilbud.csv");

        for (Vare vare : varer) {
            alleVarer.put(vare.getEan(), vare);
        }

        for (Vare tilbudsVare : tilbud) {
            alleVarer.put(tilbudsVare.getEan(), tilbudsVare);
        }
    }

    public Collection<Vare> getAlleVarer() {
        return alleVarer.values();
    }

    public void scanBasket(List<String> basket) {
        double total = 0;
        double moms = 0;

        Map<String, Integer> counted = new HashMap<>();

        for (String ean : basket) {
            if (counted.containsKey(ean)) {
                counted.put(ean, counted.get(ean) + 1);
            } else {
                counted.put(ean, 1);
            }
        }

        System.out.println("------ KASSEBON ------");

        for (String ean : counted.keySet()) {
            Vare vare = alleVarer.get(ean);

            if (vare == null) {
                System.out.println("Ukendt vare: " + ean);
                continue;
            }

            int antal = counted.get(ean);
            double stykPris = vare.getPris();
            double samletPris = antal * stykPris;

            System.out.println(vare.getNavn());
            System.out.println("  " + antal + " * " + stykPris + " kr");

            if (vare.isTilbud()) {
                double normalPris = stykPris + 5;
                double rabat = normalPris - stykPris;
                System.out.println("  Normalpris: " + normalPris + " kr");
                System.out.println("  Rabat: -" + rabat + " kr");
            }

            System.out.println("  I alt: " + samletPris + " kr");
            System.out.println();

            total += samletPris;
            moms += samletPris * 0.25;
        }

        System.out.println("----------------------");
        System.out.println("Total: " + total + " kr");
        System.out.println("Heraf moms: " + moms + " kr");
        System.out.println("Tak for dit køb");
    }
}

