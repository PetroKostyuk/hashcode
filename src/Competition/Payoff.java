package Competition;

import Framework.Logger;

public class Payoff {
    static Logger logger = new Logger(true);

    public static Integer compute(Data data, Ride ride, Pos carPosition, int timestep) {
        // distance reward
        int payoff = - 10 * ride.dist;

        // bonus
        if (timestep == ride.s) {
            payoff += data.bonus;
        }

        int distToStart = Utils.dist(carPosition, ride.pos1);
        int timeConsumed = distToStart + ride.dist;

        int carAvailableAtStart = timeConsumed + timestep;
        if (carAvailableAtStart > ride.lastStart) {
            return null;
        }

        // too early at the start
        int waitingTime = 0;
        if (carAvailableAtStart < ride.s) {
            waitingTime = ride.s - carAvailableAtStart;
        }

        return payoff - distToStart - waitingTime;
    }
}
