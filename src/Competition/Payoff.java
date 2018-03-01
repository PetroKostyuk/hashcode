package Competition;

import Framework.Logger;

public class Payoff {
    static Logger logger = new Logger(true);

    public static Integer compute(Data data, Ride ride, Pos carPosition, int timestep) {
        // distance reward
        int payoff = ride.dist;

        // bonus
        if (timestep == ride.s) {
            payoff += data.bonus;
        }

        // too late
        int timeConsumed = Utils.dist(carPosition, ride.pos1) + ride.dist;

        int carAvailableAtStart = timeConsumed + timestep;
        if (carAvailableAtStart > ride.lastStart) {
            return null;
        }

        // too early at the start
        if (carAvailableAtStart < ride.s) {
            timeConsumed += ride.s - carAvailableAtStart;
        }

        return 1000*payoff/timeConsumed;
    }
}
