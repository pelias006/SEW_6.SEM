package pelias;

import pelias.interfaces.ILotto;
import pelias.objects.LottoZiehung;
import pelias.objects.LottoZiehungen;

import java.util.*;

/**
 * Die Lotte Klasse, welche das ILotto interface implementiert und die
 * Logik für das Lotto Spiel bereitstellt.
 *
 * @author Patrick Elias
 * @version 2021-02-22
 */
public class Lotto implements ILotto

{
    private Set<Integer> lottoZahlen;
    private int zusatzZahl;

    public Lotto() {
        ziehung();
    }

    @Override
    public int check(Set<Integer> list) {
        int correct = 0;
        for (Integer integer :
                list) {
            if (lottoZahlen.contains(integer)) correct++;
        }
        return correct;
    }

    @Override
    public boolean checkZusatz(Set<Integer> list) {
        return list.contains(zusatzZahl);
    }

    @Override
    public int getZusatzZahl() {
        return zusatzZahl;
    }

    @Override
    public void ziehung() {
        lottoZahlen = new TreeSet<>();
        for (int i = 0; i < 6; i++) {
            int randomZahl;
            do {
                randomZahl = (int) (Math.random() * 44) + 1; //erstellt eine Zahl zwischen 0 und 44 und addiert dann 1 dazu, sodass sie immer zumindest 1 und maximal 45 ist.
            } while (!lottoZahlen.add(randomZahl));

            do {
                zusatzZahl = (int) (Math.random() * 44) + 1;
            } while (!lottoZahlen.contains(zusatzZahl));
        }
        LottoZiehung ziehung = new LottoZiehung(lottoZahlen, zusatzZahl);
        LottoZiehungen.addLottoZiehung(ziehung);
    }

    @Override
    public int[] toArray() {
        int[] array = new int[6];
        Iterator<Integer> iter = lottoZahlen.iterator();
        for (int i = 0; i < 6 && iter.hasNext(); i++) array[i] = iter.next();
        Arrays.sort(array);
        return array;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i :
                this.lottoZahlen) {
            stringBuilder.append("| ").append(i).append(" |").append("\n");
        }
        stringBuilder.append("\n");
        stringBuilder.append("| ").append(zusatzZahl).append(" |").append("\n");
        return stringBuilder.toString();
    }
}
