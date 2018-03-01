package Competition;
package Math;
public class Ride {
    int index, s, f, dist, lastStart;
    Pos pos1;
    Pos pos2;


    public Ride(int index, int r1, int c1, int r2, int c2, int s, int f){
        this.index = index;
        this.pos1 = new Pos(r1, c1);
        this.pos2 = new Pos(r2, c2);
        this.s = s;
        this.f = f;
        this.dist = Math.abs(r1 - r2) + Math.abs(c1 - c2);
        this.lastStart = f - dist;
    }
}
