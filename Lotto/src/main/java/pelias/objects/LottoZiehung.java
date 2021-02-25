package pelias.objects;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Diese Klasse bildet das Lotto Ziehung Objekt, welches die Lotto Ziehungen
 * speichert und darstellt.
 *
 * @author Patrick Elias
 * @version 2021-02-23
 */
public class LottoZiehung {
    private int id;
    private Set<Integer> lottoZahlen;
    private static List<LottoZiehung> benutzerZiehungen;
    private int zusatzZahl;

    public LottoZiehung(Set<Integer> lottoZahlen, int zusatzZahl) {
        this.lottoZahlen = lottoZahlen;
        this.zusatzZahl = zusatzZahl;
        this.id = LottoZiehungen.getNextID();
        benutzerZiehungen = new LinkedList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Integer> getLottoZahlen() {
        return lottoZahlen;
    }

    public void setLottoZahlen(Set<Integer> lottoZahlen) {
        this.lottoZahlen = lottoZahlen;
    }

    public int getZusatzZahl() {
        return zusatzZahl;
    }

    public void setZusatzZahl(int zusatzZahl) {
        this.zusatzZahl = zusatzZahl;
    }

    public static void addBenutzerZiehung(LottoZiehung ziehung) {
        benutzerZiehungen.add(ziehung);
    }

    public static List<LottoZiehung> getBenutzerZiehungen() {
        return benutzerZiehungen;
    }
}
