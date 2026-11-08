package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE

        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();

        int[] sizeList = {1000,2000,4000,8000,16000,32000,64000,128000};
        int opTimes=10000;
        SLList<Integer> SLList = new SLList<>();

        int counter=0;
        for(int i:sizeList){
            // creat SLList have N items
            for(;counter<i;counter++){
                SLList.addFirst(counter);
            }

            Stopwatch timer = new Stopwatch();
            for(int j=0;j<opTimes;j++) {
                SLList.getLast();
            }

            Double time = timer.elapsedTime();
            Ns.addLast(counter);
            times.addLast(time);
            opCounts.addLast(opTimes);
        }
        printTimingTable(Ns,times,opCounts);
    }

}
