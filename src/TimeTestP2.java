import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class TimeTestP2 {
    public static void main(String[] args){
        Long start = System.currentTimeMillis();//recording the current time at begin by millseconds.
        Long startConstruct = System.currentTimeMillis();//recording the current time at start by millseconds.

        ArrayList<Integer> arrayList = new ArrayList<>();//create a integer ArrayList.

        for (int i = 0; i < 110000000; i++) {// add 110000000 random numbers into arraylist
            double num = Math.random()*10;// create a random number between 0 to 10;
            arrayList.add((int)num);
        }
        Long endConstruct = System.currentTimeMillis();//recording the current time at start by millseconds.

        Iterator<Integer> it = arrayList.iterator();
        int total = 0;


        while (it.hasNext()) {
            int obj = (int) it.next();
            total = total + obj;
        }
        Long end = System.currentTimeMillis();//recording the current time at end by millseconds.

        Long timeForArrayList = TimeUnit.MILLISECONDS.toMillis(endConstruct - startConstruct);// during the time between start and end.
        Long timeForIterator = TimeUnit.MILLISECONDS.toMillis(end - start - endConstruct + startConstruct);// during the time between start and end.

        System.out.println("Time for insert random int into array list is: "+timeForArrayList+"ms");
        System.out.println("Time for Iterator sum the random number in array list is: " + timeForIterator+"ms");
        System.out.println("The sum of the random number for array list is: "+ total);

        //Testing the time for Vector
        start = System.currentTimeMillis();//recording the current time at begin by millseconds.
        startConstruct = System.currentTimeMillis();//recording the current time at start by millseconds.

        Vector<Integer> vector = new Vector<>();
        for (int i = 0; i < 110000000; i++) {// add 110000000 random numbers into vector
            double num = Math.random()*10;// create a random number between 0 to 10;
            vector.add((int)num);
        }

        endConstruct = System.currentTimeMillis();//recording the current time at start by millseconds.

        Iterator<Integer> it2 = vector.iterator();
        int total2 = 0;


        while (it2.hasNext()) {
            int obj = (int) it2.next();
            total2 = total2 + obj;
        }
        end = System.currentTimeMillis();//recording the current time at end by millseconds.

        long  timeForVector = TimeUnit.MILLISECONDS.toMillis(endConstruct - startConstruct);// during the time between start and end.
        timeForIterator = TimeUnit.MILLISECONDS.toMillis(end - start - endConstruct + startConstruct);// during the time between start and end.

        System.out.println();
        System.out.println("Time for insert random int into Vector is: "+timeForVector+"ms");
        System.out.println("Time for Iterator sum the random number in Vector is: " + timeForIterator+"ms");
        System.out.println("The sum of the random number for Vector is: "+ total2);

        int[] intArray = new int[110000000];//create 110000000 array size
        start = System.currentTimeMillis();//recording the current time at begin by millseconds.
        startConstruct = System.currentTimeMillis();//recording the current time at begin Construction by millseconds.

        for (int i = 0; i < 110000000; i++) {
            double num = Math.random()*10;
            intArray[i] = (int)num;
        }
        endConstruct = System.currentTimeMillis();//recording the current time at end Construction by millseconds.
        int total3 = 0;
        for (int i = 0; i < 110000000; i++) {
            total3=total3+intArray[i];
        }

        end = System.currentTimeMillis();//recording the current time at end by millseconds.

        Long timeForArray = TimeUnit.MILLISECONDS.toMillis(endConstruct - startConstruct);// during the time between start and end.
        Long timeForAdding = TimeUnit.MILLISECONDS.toMillis(end - start - endConstruct + startConstruct);// during the time between start and end.

        System.out.println();
        System.out.println("Time for insert random int into array is: "+timeForArray+"ms");
        System.out.println("Time for sum the random number in array is: " + timeForAdding+"ms");
        System.out.println("The sum of the random number for array is: "+ total3);

        boolean largeEnough = timeForArrayList >= 10000;
        if (largeEnough){
            System.out.println();
            System.out.println("Over 10 second OK");
        } else {
            System.out.println();
            System.out.println("Not over 10 second");
        }

    }
}
