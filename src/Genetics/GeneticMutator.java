package Genetics;

import Framework.Logger;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class GeneticMutator {
    Random rand = new Random();
    int generationSize = 20;
    Logger logger = new Logger(true);
    GenomeCase gCase;

    Genome[] lastGeneration;

    int maxScoreYet = 0;
    Genome bestGenomeYet = null;

    public GeneticMutator(GenomeCase gCase){
        this.gCase = gCase;

        lastGeneration = new Genome[generationSize];
        for(int i=0; i<generationSize; i++){
            lastGeneration[i] = new Genome();
            evaluateGenome(lastGeneration[i]);

            for(int j=i; j>0; j--){
                if(lastGeneration[j].score > lastGeneration[j-1].score){
                    Genome g = lastGeneration[j];
                    lastGeneration[j] = lastGeneration[j-1];
                    lastGeneration[j-1] = g;
                }
            }
        }

        lastGeneration[0] = new Genome(1.2757516310836592, 3.6847734976922033, -1.1519282268280397, -0.17015137447934692);
        evaluateGenome(lastGeneration[0]);

        while(true) {
            logger.log("== END OF CYCLE == WINNER:");
            logger.log(bestGenomeYet);
            logger.log("== NEW CYCLE ==");
            createNewGeneration();
        }
    }

    public void createNewGeneration(){
        List<Genome> newGenomes = new LinkedList<>();

        for(int i=0; i<generationSize; i++){
            Genome g = lastGeneration[i].createDescendantByMutation();
            evaluateGenome(g);

            newGenomes.add(g);
        }


        for(int i=0; i<generationSize; i++){
            Genome g = lastGeneration[i].createDescendantByCrossover(lastGeneration[rand.nextInt(generationSize)]);
            evaluateGenome(g);

            newGenomes.add(g);
        }

        for(int i=0; i<generationSize; i++){
            addGenomeIfGood(newGenomes.get(i));
        }
    }

    public void addGenomeIfGood(Genome g){
        if(g.score > lastGeneration[generationSize-1].score){
            lastGeneration[generationSize-1] = g;
        }

        for(int i=generationSize-1; i>0; i--){
            if(lastGeneration[i].score > lastGeneration[i-1].score){
                Genome gTemp= lastGeneration[i];
                lastGeneration[i] = lastGeneration[i-1];
                lastGeneration[i-1] = gTemp;
            }
        }
    }

    public void evaluateGenome(Genome g){
        gCase.evaluateGenome(g, maxScoreYet);
        logger.log("evaluating genome: " + g.toString());
        if(g.score > maxScoreYet){
            logger.log("FOUND NEW HIGH SCORE!!!");
            maxScoreYet = g.score;
            bestGenomeYet = g;
        }
    }

    public static void main(String[] args) {
        GeneticMutator gm = new GeneticMutator(new GenomeCase("data/in/e_high_bonus.in", "data/out/e_high_bonus.out"));
    }
}
