package Competition;

import Framework.Logger;

import java.util.List;

public class ProblemSolver {
    Logger log = new Logger(true);

    /**
     * Transforms data so that solution is readable.
     *
     * @param data Data
     */
    public void solve(Data data){
        for (int car = 0; car < data.vehiclesCount; car++) {
            List<Integer> carRides = Plan.make(data);
            data.assignedRides.add(carRides);
        }
    }
}
