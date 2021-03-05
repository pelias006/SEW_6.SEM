package pelias;

import pelias.gui.LottoUI;
import pelias.objects.LottoZiehungen;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        LottoZiehungen lottoZiehungen = new LottoZiehungen();
        DatenSpeicher datenSpeicher = new DatenSpeicher(System.currentTimeMillis() + "_lotto.json");
        lottoZiehungen = DatenSpeicher.getLottoZiehungen();
        Lotto lotto = new Lotto();
        LottoUI lottoUI = new LottoUI();
    }
}
