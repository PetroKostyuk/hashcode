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
        int availableAtStart = Utils.dist(carPosition, ride.pos1) + timestep;
        if (availableAtStart > ride.lastStart) {
            return null;
        }

        // too early at the start
        if (availableAtStart < ride.s) {
            payoff -= ride.s - availableAtStart;
        }

        return payoff;
    }
}
