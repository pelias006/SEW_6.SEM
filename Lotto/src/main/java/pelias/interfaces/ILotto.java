package pelias.interfaces;

import java.util.Set;

/**
 * Das Lotto Interface welches definiert wie eine Lotto-Klasse
 * umgesetzt werden soll und die default Methoden angibt.
 *
 * @author Patrick Elias
 * @version 2021-02-22
 */
public interface ILotto {
    /**
     * Diese Methode überprüft wie viele der in Tipp gespeicherten Zahlen mit
     * den tatsächlichen Gewinnzahlen übereinstimmen und gibt die Anzahl zurück.
     * @param list Eine List mit den getippten Zahlen
     * @return Integer die Anzahl der Zahlen die übereinstimmen.
     */
    int check(Set<Integer> list);

    /**
     * Diese Methode übernimmt einen Tipp als Parameter und gibt zurück ob zumindest einer
     * der Elemente mit den tatsächlichen Zahlen übereinstimmt.
     * @param list Eine Liste mit den Tipps
     * @return Boolean überprüft ob eines der Elemente mit den tatsächlichen Zahlen übereinstimmt
     */
    boolean checkZusatz(Set<Integer> list);

    /**
     * Diese Methode liefert die aktuelle Zusatzzahl und gibt diese zurück.
     * @return Integer die aktuelle Zusatzzahl.
     */
    int getZusatzZahl();

    /**
     * Diese Methode zieht neue Zahlen und speichert sie in
     * Lottozahlen und Zusatzzahl.
     */
    void ziehung();

    /**
     * Diese Methode speichert alle Lottozahlen aufsteigend in einem Integer
     * Array und gibt dieses zurück. Zum Durchgehen der Lottozahlen Collection wird
     * ein Iterator verwendet.
     * @return Integer Array mit den Lottozahlen.
     */
    int[] toArray();

    /**
     * Diese Methode formatiert die Lottozahlen aufsteigend in einem String. Zum
     * Durchgehen der Collection und des Strings wird ein Iterator verwendet.
     * @return String mit den formatierten Lotto Zahlen.
     */
    String toString();
}
