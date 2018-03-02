package Framework;

import Competition.ProblemSolver;
import Competition.ProblemSolver2;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Logger.MAIN_VERBOSITY = true;

        String[] inputFiles = {
//                "data/in/b_should_be_easy.in"
                "data/in/e_high_bonus.in"
        };

        String[] outputFiles = {
                "data/out/e_high_bonus.out"
        };

//        new ProblemRunner("data/in", "data/out", new ProblemSolver2());
        new ProblemRunner(inputFiles, outputFiles, new ProblemSolver2());
    }
}
