package org.example;

public class Main {

    public static void main(String[] args) {
        IntegerList intList1 = new IntegerListImpl(100000,"R");
        IntegerList intList2 = new IntegerListImpl(100000,"R");
        IntegerList intList3 = new IntegerListImpl(100000,"R");
/*
        long start = System.currentTimeMillis();
        intList1.sortInsertion();
        System.out.println("InsertionTime: "+ (System.currentTimeMillis() - start));

        intList2.sortInsertion();
        System.out.println("InsertionTime: "+ (System.currentTimeMillis() - start));

        intList3.sortInsertion();
        System.out.println("InsertionTime: "+ (System.currentTimeMillis() - start));
*/

    }
}