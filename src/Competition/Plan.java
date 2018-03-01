package Competition;

import Framework.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author rozumden
 */
public class Plan {
    Logger log = new Logger(true);
     
    public static List<Integer> make(Data data) {
        Pos p = new Pos(0,0);
        int t = 0;
        List<Integer> plan = new ArrayList<>();
        boolean[] feas = new boolean[data.rides.size()];
        Arrays.fill(feas, true);
        int ibest = Integer.MIN_VALUE;
        while(true) {
            for (Ride r : data.rides) {
               if(!feas[r.index]) continue;
               Integer i = Payoff.compute(r, p, t);
               if(i == null) {
                   feas[r.index] = false;
               } else {
                   
               }
            }
            plan.add(ib);
        }
        
        return plan;
    }
}
