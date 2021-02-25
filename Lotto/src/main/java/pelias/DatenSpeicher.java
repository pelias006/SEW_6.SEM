package pelias;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import pelias.objects.LottoZiehung;
import pelias.objects.LottoZiehungen;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Diese Klasse kümmert sich um das Verwalten des Datenspeichers
 * in Form von JSON.
 *
 * @author Patrick Elias
 * @version 2021-02-23
 */
public class DatenSpeicher {
    private String fileName;
    private static File file;

    public DatenSpeicher(String fileName) {
        fileName = fileName;
        file = new File("", fileName);

        if (!file.exists()) {
            try {
                if (!file.createNewFile()) {
                    throw new IOException("File could not be created.");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void addLottoZiehung(LottoZiehung ziehung) {
        try (FileWriter writer = new FileWriter(file)) {
            LottoZiehungen lz = (getLottoZiehungen());
            lz.addLottoZiehung(ziehung);
            writer.write(new GsonBuilder().setPrettyPrinting().create().toJson(lz));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void removeLottoZiehung(LottoZiehung ziehung) {
        try (FileWriter writer = new FileWriter(file)) {
            LottoZiehungen lz = (getLottoZiehungen());
            lz.removeLottoZiehung(ziehung);
            writer.write(new GsonBuilder().setPrettyPrinting().create().toJson(lz));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static LottoZiehungen getLottoZiehungen() {
        try (FileReader reader = new FileReader(file)) {
            return new Gson().fromJson(reader, LottoZiehungen.class);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
