package pelias;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Die Main Klasse des Programmes
 * @author Patrick Elias
 * @version 2021-02-09
 */
public class Main {
    private static List<Integer> arrayTestList = new ArrayList<>();
    private static List<Integer> linkedTestList = new LinkedList<>();

    public static void main(String[] args) {
        ListTester lt = new ListTester();
        int testInt = 20000;
        generateRandomLists(testInt);

        System.out.println("AddEnd for ArrayList: " + benchMark(() -> lt.addEnd(new ArrayList<>(), testInt)) + "ms");
        System.out.println("AddEnd for LinkedList: " + benchMark(() -> lt.addEnd(new LinkedList<>(), testInt)) + "ms");
        System.out.println("AddFirst for ArrayList: " + benchMark(() -> lt.addFirst(new ArrayList<>(), testInt)) + "ms");
        System.out.println("AddFirst for LinkedList: " + benchMark(() -> lt.addFirst(new LinkedList<>(), testInt)) + "ms");
        System.out.println("DeleteHalf for ArrayList: " + benchMark(() -> lt.deleteHalf(arrayTestList)) + "ms");
        System.out.println("DeleteHalf for LinkedList: " + benchMark(() -> lt.deleteHalf(linkedTestList)) + "ms");
        System.out.println("SummeIterator for ArrayList: " + benchMark(() -> lt.summeIterator(arrayTestList)) + "ms");
        System.out.println("SummeIterator for LinkedList: " + benchMark(() -> lt.summeIterator(linkedTestList)) + "ms");
        System.out.println("SummeIndex for ArrayList: " + benchMark(() -> lt.summeIndex(arrayTestList)) + "ms");
        System.out.println("SummeIndex for LinkedList: " + benchMark(() -> lt.summeIndex(linkedTestList)) + "ms");
        System.out.println("ListIterator for ArrayList: " + benchMark(() -> lt.listIterator(arrayTestList)) + "ms");
        System.out.println("ListIterator for LinkedList: " + benchMark(() -> lt.listIterator(linkedTestList)) + "ms");
        System.out.println("ListIndex for ArrayList: " + benchMark(() -> lt.listIndex(arrayTestList)) + "ms");
        System.out.println("ListIndex for LinkedList: " + benchMark(() -> lt.listIndex(linkedTestList)) + "ms");
    }

    public static long benchMark(Runnable runnable) {
        long start = System.currentTimeMillis();
        runnable.run();
        long end = System.currentTimeMillis();
        return end - start;
    }

    private static void generateRandomLists(int anzahlZufallsZahlen) {
        for (int i = 0; i < anzahlZufallsZahlen; i++) {
            int random = (int) (Math.random() * Integer.MAX_VALUE) + (int) (Math.random() * Integer.MIN_VALUE);
           arrayTestList.add(i);
           linkedTestList.add(i);
        }
    }
}
