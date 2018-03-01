package Competition;

import Framework.Logger;

public class Payoff {
    static Logger logger = new Logger(true);

    public static Integer compute(Data data, Ride ride, Pos position, int timestep) {
        if (timestep > ride.lastStart) {
            return null;
        }

        return ride.dist +
    }
}
