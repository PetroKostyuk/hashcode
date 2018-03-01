package Competition;

import Framework.Logger;

public class Payoff {
    static Logger logger = new Logger(true);

    public static Integer compute(Data data, Ride ride, Pos carPosition, int timestep) {
        int payoff = ride.dist;

        if (timestep == ride.s) {
            payoff += data.bonus;
        }

        int availableAtStart = Utils.dist(carPosition, ride.pos1) + timestep;
        if (availableAtStart > ride.lastStart) {
            return null;
        }

        if (availableAtStart < ride.s) {
            payoff += ride.s - availableAtStart;
        }

        return payoff;
    }
}
