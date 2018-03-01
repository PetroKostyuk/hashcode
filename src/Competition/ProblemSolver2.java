package Competition;

import Framework.Logger;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ProblemSolver2 {
    Logger log = new Logger(true);

    /**
     * Transforms data so that solution is readable.
     *
     * @param data Data
     */
    public void solve(Data data){
        Collections.sort(data.rides);

        List<Car> cars = new LinkedList<>();
        for(int i=0; i<data.vehiclesCount; i++){
            cars.add(new Car());
        }

        boolean done = false;
        while(!done){
            // if no changes will be found, while will quit
            done = true;

            for(int i=0; i<data.vehiclesCount; i++){
                Ride r = cars.get(i).findRide(data);
                if(r != null){
                    data.rides.remove(r);
                    data.assignedRides.get(i).add(r.index);
                    done = false;
                }
            }
        }
    }
}
