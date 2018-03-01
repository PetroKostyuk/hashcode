package Competition;

public  class Utils {

    public static int dist(Pos p1, Pos p2){

        return Math.abs(p1.r - p2.r) + Math.abs(p1.c - p2.c);

    }

}
