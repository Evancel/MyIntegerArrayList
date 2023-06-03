package org.example;

public class Main {

    public static void main(String[] args) {
 /*
        IntegerList intList1 = new IntegerListImpl(100000,"R");
        System.out.println(intList1.contains(2));

        long start = System.currentTimeMillis();
        intList1.sortInsertion();
        System.out.println("InsertionTime: "+ (System.currentTimeMillis() - start));
*/

        IntegerList myList = new IntegerListImpl();
        System.out.println(myList);

        myList.add(0,1);
        myList.add(1,15);
        myList.add(23);
        myList.add(23);
        myList.add(23);
        myList.set(1,65);
        myList.remove(1);
        System.out.println(myList);
    }
}