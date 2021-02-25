package pelias.objects;

import java.util.ArrayList;
import java.util.List;

/**
 * Diese Klasse bildet das Objekt für die LottoZiehungen
 * welche eine Liste mit LottoZiehung Objekten speichert.
 *
 * @author Patrick Elias
 * @version 2021-02-23
 */
public class LottoZiehungen {
    private static List<LottoZiehung> lottoZiehungenList;

    public static void addLottoZiehung(LottoZiehung ziehung) {
        lottoZiehungenList.add(ziehung);
    }

    public static void removeLottoZiehung(LottoZiehung ziehung) {
        lottoZiehungenList.remove(ziehung);
    }

    public static int getNextID() {
        return lottoZiehungenList.size();
    }
}
