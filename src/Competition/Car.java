package Competition;

public class Car {
    Pos position;
    int timeAvailable;

    public Car(){
        position = new Pos(0,0);
        timeAvailable = 0;

    }

    public Car(Pos pos, int timeAvailable){
        this.position = pos;
        this.timeAvailable = timeAvailable;

    }

    public Ride findRide(Data data){
        Integer pCurr;
        int pMax = Integer.MIN_VALUE;
        Ride rideMax = null;
        for (Ride currRide : data.rides){
            pCurr = Payoff.compute(data, currRide, this.position, timeAvailable);
            if (pCurr != null && pCurr > pMax){
                pMax = pCurr;
                rideMax = currRide;
            }
        }
        /// update time and position
        if (rideMax == null){
            return null;
        }

        return rideMax;
    }

    public int addRide(Data data, Ride ride){
        int rideDistance = Utils.dist(ride.pos1, ride.pos2);
        int distanceToStart = Utils.dist(position, ride.pos1);
        int timeOnStart = timeAvailable + distanceToStart;

        timeAvailable += timeOnStart;
        if(timeAvailable < ride.s) {
            timeAvailable = ride.s;
        }
        timeAvailable += ride.dist;
        position = ride.pos2;

        return rideDistance + (timeOnStart<=ride.s ? data.bonus : 0);
    }

}
