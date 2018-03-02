package Competition;

import Framework.Logger;
import Genetics.Genome;

public class Payoff {
    static Logger logger = new Logger(true);

    public static Integer compute(Data data, Ride ride, Pos carPosition, int timestep) {

        int reward = ride.dist;
        int bonus = timestep <= ride.s ? data.bonus : 0;
        int availableAtStart = Utils.dist(carPosition, ride.pos1) + timestep;
        int moving = availableAtStart - timestep;
        int waiting = ride.s - availableAtStart;

        if (availableAtStart > ride.lastStart) {
            return null;
        }

        return (int)(reward * Genome.reward + bonus * Genome.bonus + moving * Genome.moving + waiting * Genome.waiting);
    }
}
