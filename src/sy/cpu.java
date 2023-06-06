package sy;

import org.omg.SendingContext.RunTime;

public class cpu {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        int i = runtime.availableProcessors();
        System.out.println(i);
    }
}
