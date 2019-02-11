package homeTaskGeneric;

import homeTaskGeneric.firstSecond.Pair;
import homeTaskGeneric.third.Entry;
import homeTaskGeneric.third.Table;

public class GenericApp {

    private static Pair<Integer> pairInt = new Pair<>(15, 12);
    private static Pair<Double> pairDouble = new Pair<>(12.2, 13.7);
    private static Pair<String> pairStr = new Pair<>("2","1s");
    private static Entry<String,String> entryStr = new Entry<>("111","222");
    private static Entry<String,String> entryStr2 = new Entry<>("333","444");
    private static Entry<String,Pair> entryPair = new Entry<>("1",pairInt);
    private static Entry<String,Pair> entryPair2 = new Entry<>("2",pairDouble);

    public static void main(String[] args) {
        System.out.println(pairInt.getMax());
        System.out.println(pairDouble.getMin());
        System.out.println(pairStr.getMax());
        System.out.println("===========================================");
        Table<String,String> strTable = new Table<>();
        strTable.add(entryStr);
        strTable.add(entryStr2);
        Table<String,Pair> strPairTable = new Table<>();
        strPairTable.add(entryPair);
        strPairTable.add(entryPair2);
        System.out.println(strTable.getEntries());
        System.out.println(strTable.getValue("111"));
        strTable.addValue("333","new value");
        System.out.println(strTable.getEntries());
        System.out.println(strPairTable.getEntries());
        strPairTable.remove("1");
        System.out.println(strPairTable.getEntries());
    }
}
