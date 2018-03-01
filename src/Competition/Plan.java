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
        while(true) {
            int vbest = Integer.MIN_VALUE;
            int indbest = -1;
            for (int indRide = 0; indRide < data.rides.size(); indRide++) {
                Ride r = data.rides.get(indRide);
                if(!feas[indRide]) continue;
                Integer i = Payoff.compute(data, r, p, t);
                if(i == null) {
                    feas[indRide] = false;
                } else {
                    int iv = i;
                    if(iv > vbest) {
                        vbest = iv;
                        indbest = indRide;
                    }
                }
            }
            if(indbest == -1) break;
            
            plan.add(data.rides.get(indbest).index);

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
