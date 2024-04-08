import java.util.*;

public class RelTable implements Iterable{
    private HashMap<Integer, Entry> entries= new HashMap<Integer,Entry>();

    public class Entry {
        private String ProductName;
        private float Price;

        public String getProductName() {
            return ProductName;
        }

        public float getPrice() {
            return Price;
        }

        public Entry(String productName, float price) {
            ProductName = productName;
            Price = price;
        }
    }

    public boolean addEntry(int id, String productName, float price){
        if (entries.containsKey(id)) return false;
        entries.put(id, new Entry(productName, price));
        return true;
    }

    @Override
    public java.util.Iterator<Entry> iterator() {
        return new Iterator(true);
    }

    public java.util.Iterator<Entry> backwardIterator(){
        return new Iterator(false);
    }

    public java.util.Iterator<Entry> filterIterator(int maxPrice) {
        return new FilterIterator(maxPrice);
    }

    private class Iterator implements java.util.Iterator<Entry> {
        List<Integer> ids;

        public Iterator(boolean ascending){
            ids = new ArrayList<>(entries.keySet());
            if (ascending) Collections.sort(ids);
            else Collections.sort(ids, Collections.reverseOrder());
        }

        @Override
        public boolean hasNext() {
            return !ids.isEmpty();
        }

        @Override
        public Entry next() {
            Entry entry = entries.get(ids.get(0));
            ids.remove(0);
            return entry;
        }
    }


    private class FilterIterator implements java.util.Iterator<Entry> {
        List<Integer> ids;
        List<Integer> filteredIds = new ArrayList<>();
        int maxPrice;

        public FilterIterator(int maxPrice){
            this.maxPrice = maxPrice;
            ids = new ArrayList<>(entries.keySet());
            Collections.sort(ids);
            for (int i: ids){
                if (entries.get(i).getPrice() <= maxPrice) filteredIds.add(i);
            }
        }

        @Override
        public boolean hasNext() {
            return !filteredIds.isEmpty();
        }

        @Override
        public Entry next() {
            Entry entry = entries.get(filteredIds.get(0));
            filteredIds.remove(0);
            return entry;
        }
    }

//    private class FilterIterator implements java.util.Iterator<Entry> {
//
//        @Override
//        public boolean hasNext() {
//            return false;
//        }
//
//        @Override
//        public Entry next() {
//            return null;
//        }
//    }

}
