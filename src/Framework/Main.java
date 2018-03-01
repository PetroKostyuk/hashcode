package Framework;

import Competition.ProblemSolver;
import Framework.Logger;
import Framework.ProblemRunner;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Logger.MAIN_VERBOSITY = true;

        String[] inputFiles = {
                "data/in/a_example.in"
        };

        String[] outputFiles = {
                "data/out/a_example.out"
        };

//        new ProblemRunner("data/in", "data/out", new ProblemSolver());
        new ProblemRunner(inputFiles, outputFiles, new ProblemSolver());
    }
}
