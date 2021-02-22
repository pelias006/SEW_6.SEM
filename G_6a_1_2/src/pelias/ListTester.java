package pelias;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Bietet die Methoden um diverse Listen zu testen.
 * @author Patrick Elias
 * @version 2021-02-09
 */
public class ListTester {
    /**
     * Fügt am Ende zufallszahlen hinzu
     * @param integers die Liste mit integern
     * @param anzahlZufallsZahlen die anzahl an zufallszahlen
     */
    public void addEnd(List<Integer> integers, int anzahlZufallsZahlen) {
        for (int i = 0; i < anzahlZufallsZahlen; i++) integers.add((int) (Math.random() * Integer.MAX_VALUE) + (int) (Math.random() * Integer.MIN_VALUE));
    }

    /**
     * fügt am anfang zahlen hinzu
     * @param integers Die Liste
     * @param anzahlZufallsZahlen die Anzahl an zufallszahlen die addiert werden soll
     */
    public void addFirst(List<Integer> integers, int anzahlZufallsZahlen) {
        for (int i = 0; i < anzahlZufallsZahlen; i++) integers.add(0, (int) (Math.random() * Integer.MAX_VALUE) + (int) (Math.random() * Integer.MIN_VALUE));
    }

    /**
     * löscht die hälfte der Liste
     * @param integers die Liste
     */
    public void deleteHalf(List<Integer> integers) {
        Iterator<Integer> iterator = integers.iterator();
        for (int i = 0; i < integers.size() / 2; i++) {
            if (iterator.hasNext()) integers.remove(i);
        }
    }

    /**
     * Gibt die Summe der iterator aus
     * @param integers die Liste mit Integern
     * @return die summe
     */
    public int summeIterator(List<Integer> integers) {
        AtomicInteger summe = new AtomicInteger();
        integers.iterator().forEachRemaining(summe::addAndGet);
        return summe.get();
    }

    /**
     * Gibt die summe der indexe an
     * @param integers die Liste mit INtegern
     * @return die Summe
     */
    public int summeIndex(List<Integer> integers) {
        int summe = 0;
        //Da sagt mir sogar IntelliJ das foreach besser wäre :o
        for (int i = 0; i < integers.size(); i++) summe += integers.get(i);
        return summe;
    }

    /**
     * Listet alle iterator auf
     * @param integers die Liste mit Integern
     * @return String mit der anzahl
     */
    public String listIterator(List<Integer> integers) {
        StringBuilder listenString = new StringBuilder();
        integers.forEach(integer -> listenString.append(integer).append(", "));
        return listenString.substring(0, listenString.length() - 1);
    }

    /**
     * Listet alle Indexe aus einer Liste
     * @param integers die Liste mit den Integern
     * @return String mit den Integern
     */
    public String listIndex(List<Integer> integers) {
        StringBuilder listenString = new StringBuilder();
        integers.forEach(integer -> listenString.append(integer).append(", "));
        return listenString.substring(0, listenString.length() - 1);
    }
}
