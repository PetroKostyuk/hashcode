package Competition;

import Framework.Logger;
import java.util.Collections;

import java.util.List;

public class ProblemSolver {
    Logger log = new Logger(true);

    /**
     * Transforms data so that solution is readable.
     *
     * @param data Data
     */
    public void solve(Data data){
        Collections.sort(data.rides);
        for (int car = 0; car < data.vehiclesCount; car++) {
            log.log("Car: " + car + "/" + data.vehiclesCount);
            List<Integer> carRides = Plan.make(data);
            data.assignedRides.add(carRides);
        }
    }
}
