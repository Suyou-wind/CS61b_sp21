package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove(){
        AListNoResizing<Integer> correct = new AListNoResizing<>();
        BuggyAList<Integer> broken = new BuggyAList<>();

        correct.addLast(4);
        correct.addLast(5);
        correct.addLast(6);
        broken.addLast(4);
        broken.addLast(5);
        broken.addLast(6);

        assertEquals(correct.removeLast(),broken.removeLast());
        assertEquals(correct.removeLast(),broken.removeLast());
        assertEquals(correct.removeLast(),broken.removeLast());

    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> correct = new AListNoResizing<>();
        BuggyAList<Integer> broken = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);

            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                correct.addLast(randVal);
                broken.addLast(randVal);
//                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = correct.size();
                int size2 = broken.size();
//                System.out.println("correct size: " + size + "  broken size:" +size2);
            } else if ( operationNumber == 2 ) {
                //getLast
                int correctSize=correct.size();
                int brokenSize=broken.size();
                if(correctSize<=0 && brokenSize<=0)
                    continue;

                int correctLast =correct.getLast();
                int brokenLast = broken.getLast();

//                System.out.println("Last of correct:" + correctLast +"Last of broken:"+ brokenLast);
            } else if (operationNumber == 3) {
                int correctSize=correct.size();
                int brokenSize=broken.size();
                if(correctSize<=0 && brokenSize<=0)
                    continue;

                int correctRemoved = correct.removeLast();
                int brokenRemoved = broken.removeLast();
//                System.out.println("correctRemoved:" + correctRemoved+"brokenRemoved:"+brokenRemoved);
            }
        }
    }


}
