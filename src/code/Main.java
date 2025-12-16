package code;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        KasseApparat kasse = new KasseApparat();
        kasse.loadData();

        Robot robot = new Robot();
        Collection<Vare> robotKurv = robot.fyldIKurv(kasse.getAlleVarer());

        List<String> basket = new ArrayList<>();
        for (Vare vare : robotKurv) {
            basket.add(vare.getEan());
        }

        kasse.scanBasket(basket);
    }
}

