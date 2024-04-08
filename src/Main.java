import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        RelTable relTable = new RelTable();
        relTable.addEntry(0,"Cola", 2);
        relTable.addEntry(2,"Chips", 3);
        relTable.addEntry(100,"ExtraCrispy", 5);
        relTable.addEntry(5,"Chocolate Bar", 1.5f);
        relTable.addEntry(10,"Protein Bar", 2);


        for (Iterator<RelTable.Entry> iterator = relTable.iterator(); iterator.hasNext();) {
            var cur = iterator.next();
            System.out.printf("%-15s : %.2f \n", cur.getProductName(), cur.getPrice());
        }

        System.out.println("----------");

        for (Iterator<RelTable.Entry> iterator = relTable.backwardIterator(); iterator.hasNext();) {
            var cur = iterator.next();
            System.out.printf("%-15s : %.2f \n", cur.getProductName(), cur.getPrice());
        }

        System.out.println("----------");

        for (Iterator<RelTable.Entry> iterator = relTable.filterIterator(3); iterator.hasNext();) {
            var cur = iterator.next();
            System.out.printf("%-15s : %.2f \n", cur.getProductName(), cur.getPrice());
        }

    }
}