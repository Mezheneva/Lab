import java.util.ArrayList;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class Test {
    public void testLab3(){

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> test = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> temp1 = new ArrayList<Integer>(); // added ()

        temp1.add(3);
        temp1.add(5);
        temp1.add(5);
        temp1.add(5);
        temp1.add(3);
        test.add(temp1);
        temp1 = new ArrayList<Integer>(); // added ()

        temp1.add(5);
        temp1.add(8);
        temp1.add(8);
        temp1.add(8);
        temp1.add(5);
        test.add(temp1);
        temp1 = new ArrayList<Integer>(); // added ()

        temp1.add(5);
        temp1.add(8);
        temp1.add(8);
        temp1.add(8);
        temp1.add(5);
        test.add(temp1);
        temp1 = new ArrayList<Integer>(); // added ()

        temp1.add(5);
        temp1.add(8);
        temp1.add(8);
        temp1.add(8);
        temp1.add(5);
        test.add(temp1);
        temp1 = new ArrayList<Integer>(); // added ()

        temp1.add(3);
        temp1.add(5);
        temp1.add(5);
        temp1.add(5);
        temp1.add(3);
        test.add(temp1);


        ArrayList<Integer> temp2 = new ArrayList<Integer>(); // added ()

        for(int i=0; i<5; i++) {
            for (int j = 0; j < 5; j++) {
                temp2.add(1);
            }
            matrix.add(temp2);

        }

        Perform a = new Perform(matrix);

        a.start();
        ArrayList<ArrayList<Integer>> result = a.getResult();

        for(int i=0; i < result.size(); i++){
            for(int j=0; j < result.size(); j++){

                assertEquals(result.get(i).get(j), test.get(i).get(j));
            }
            System.out.println();
        }

    }
}
