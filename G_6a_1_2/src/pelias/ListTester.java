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
    public void addEnd(List<Integer> integers, int anzahlZufallsZahlen) {
        for (int i = 0; i < anzahlZufallsZahlen; i++) integers.add((int) (Math.random() * Integer.MAX_VALUE) + (int) (Math.random() * Integer.MIN_VALUE));
    }

    public void addFirst(List<Integer> integers, int anzahlZufallsZahlen) {
        for (int i = 0; i < anzahlZufallsZahlen; i++) integers.add(0, (int) (Math.random() * Integer.MAX_VALUE) + (int) (Math.random() * Integer.MIN_VALUE));
    }

    public void deleteHalf(List<Integer> integers) {
        Iterator<Integer> iterator = integers.iterator();
        for (int i = 0; i < integers.size() / 2; i++) {
            if (iterator.hasNext()) integers.remove(i);
        }
    }

    public int summeIterator(List<Integer> integers) {
        AtomicInteger summe = new AtomicInteger();
        integers.iterator().forEachRemaining(summe::addAndGet);
        return summe.get();
    }

    public int summeIndex(List<Integer> integers) {
        int summe = 0;
        //Da sagt mir sogar IntelliJ das foreach besser wäre :o
        for (int i = 0; i < integers.size(); i++) summe += integers.get(i);
        return summe;
    }

    public String listIterator(List<Integer> integers) {
        StringBuilder listenString = new StringBuilder();
        integers.forEach(integer -> listenString.append(integer).append(", "));
        return listenString.substring(0, listenString.length() - 1);
    }

    public String listIndex(List<Integer> integers) {
        StringBuilder listenString = new StringBuilder();
        integers.forEach(integer -> listenString.append(integer).append(", "));
        return listenString.substring(0, listenString.length() - 1);
    }
}
