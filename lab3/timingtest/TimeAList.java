package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
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
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();

        int counter=0;
        int[] size={1000,2000,4000,8000,16000,32000,64000,12800};
//        for(counter=0;counter<400;counter++){
//            AList<Integer> L = new AList<>();
//            L.addLast(counter);
//        }

//        Stopwatch middle = new Stopwatch();
        for(int number:size) {
            Stopwatch middle = new Stopwatch();
            AList<Integer> L = new AList<>();
            for (counter = 0; counter < number; counter++) {
//                AList<Integer> L = new AList<>();
                L.addLast(counter);
            }

            Double time = middle.elapsedTime();


            Ns.addLast(counter);
            times.addLast(time);
            opCounts.addLast(counter);
        }
        printTimingTable(Ns, times, opCounts);
    }
}
