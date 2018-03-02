package Genetics;

import java.util.Random;

public class Genome {

    public static double reward;
    public static double bonus;
    public static double moving;
    public static double waiting;
    public static int maxScoreYet;

    public double _reward;
    public double _bonus;
    public double _moving;
    public double _waiting;
    public int score;

    Random rand = new Random();

    public Genome(){
        _reward = rand.nextDouble()*2;
        _bonus = rand.nextDouble()*2;
        _moving = rand.nextDouble()*2;
        _waiting = rand.nextDouble()*2;
    }

    public Genome(double reward, double bonus, double moving, double waiting){
        this._reward = reward;
        this._bonus = bonus;
        this._moving = moving;
        this._waiting = waiting;
    }

    public void mutate(){
        if(rand.nextInt(2)==0) _reward += rand.nextDouble() - 0.5;
        if(rand.nextInt(2)==0) _bonus += rand.nextDouble() - 0.5;
        if(rand.nextInt(2)==0) _moving += rand.nextDouble() - 0.5;
        if(rand.nextInt(2)==0) _waiting += rand.nextDouble() - 0.5;

        // serious mutation
        if(rand.nextInt(4)==0){
            _reward += rand.nextDouble()*4 - 2;
            _bonus += rand.nextDouble()*4 - 2;
            _moving += rand.nextDouble()*4 - 2;
            _waiting += rand.nextDouble()*4 - 2;
        }
    }

    public Genome createDescendantByMutation(){
        Genome g = new Genome(_reward, _bonus, _moving, _waiting);
        g.mutate();
        return g;
    }

    public Genome createDescendantByCrossover(Genome g2){
        Genome g = new Genome(_reward, _bonus, _moving, _waiting);

        if(rand.nextInt(3)==0) g._reward = g2._reward;
        if(rand.nextInt(3)==0) g._bonus = g2._bonus;
        if(rand.nextInt(3)==0) g._moving = g2._moving;
        if(rand.nextInt(3)==0) g._waiting = g2._waiting;

        return g;
    }

    public String toString(){
        return score + ":\t" + _reward + ",  \t" + _bonus + ",  \t" + _moving + ",  \t" + _waiting + " ]";
    }

    public void use(int _maxScoreYet){
        reward = _reward;
        bonus = _bonus;
        moving = _moving;
        waiting = _waiting;
        maxScoreYet = _maxScoreYet;
    }
}