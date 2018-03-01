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
        int pCurr;
        int pMax = Integer.MIN_VALUE;
        Ride rideMax = null;
        for (Ride currRide : data.rides){
            pCurr = Payoff.compute(data, currRide, this.position, timeAvailable);
            if (pCurr > pMax){
                pMax = pCurr;
                rideMax = currRide;
            }
        }
        return rideMax;
    }

}
