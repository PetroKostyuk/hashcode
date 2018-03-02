package Genetics;

import Competition.ProblemSolver2;
import Framework.ProblemRunner;

import java.io.IOException;

public class GenomeCase {
    String[] inputFiles;
    String[] outputFiles;

    public GenomeCase(String inputFile, String outputFile){
        inputFiles = new String[]{inputFile};
        outputFiles = new String[]{outputFile};
    }

    void evaluateGenome(Genome g, int maxScoreYet){
        try {
            g.use(maxScoreYet);
            ProblemRunner pr = new ProblemRunner(inputFiles, outputFiles, new ProblemSolver2());
            g.score = pr.totalScore;
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.score = Integer.MIN_VALUE;
    }
}
