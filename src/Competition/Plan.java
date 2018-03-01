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
        int vbest = Integer.MIN_VALUE;
        int indbest = -1;
        while(true) {
            for (Ride r : data.rides) {
               if(!feas[r.index]) continue;
               Integer i = Payoff.compute(data, r, p, t);
               if(i == null) {
                   feas[r.index] = false;
               } else {
                   int iv = i;
                   if(iv > vbest) {
                       vbest = iv;
                   }
               }
            }
            if(indbest == -1) break;
            
            plan.add(indbest);

            /// update time and position
            t += Utils.dist(p, data.rides.get(indbest).pos1);
            if(t < data.rides.get(indbest).s) {
                t += (data.rides.get(indbest).s - t);
            }
            t += data.rides.get(indbest).dist;
            p = data.rides.get(indbest).pos2;
            data.rides.remove(indbest);
        }
        
        return plan;
    }
}
