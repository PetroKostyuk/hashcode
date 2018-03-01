package Framework;

import Competition.Data;
import Competition.ProblemSolver;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ProblemRunner {

    public ProblemRunner(String[] inputFileNames, String[] outputFileNames, ProblemSolver problemSolver) throws IOException {
        List<File> inputFiles = new ArrayList<>();
        List<File> outputFiles = new ArrayList<>();

        for (String inputFileName : inputFileNames) {
            inputFiles.add(new File(inputFileName));
        }

        for (String outputFileName : outputFileNames) {
            outputFiles.add(new File(outputFileName));
        }

        solve(inputFiles, outputFiles, problemSolver);
    }

    public ProblemRunner(List<File> inputFiles, List<File> outputFiles, ProblemSolver problemSolver) throws IOException {
        solve(inputFiles, outputFiles, problemSolver);
    }

    public ProblemRunner(String inputDirectoryName, String outputDirectoryName, ProblemSolver problemSolver) throws IOException {
        List<File> inputFiles = loadFilesInDirectory(inputDirectoryName);
        List<File> outputFiles = new LinkedList<>();

        for (File inputFile : inputFiles) {
            outputFiles.add(new File(outputDirectoryName + inputFile.getName() + ".out"));
        }

        solve(inputFiles, outputFiles, problemSolver);
    }

    private List<File> loadFilesInDirectory(String directoryName) throws IOException {
        List<File> files = new LinkedList<>();
        File[] fileCandidates = new File(directoryName).listFiles();

        if (fileCandidates == null || fileCandidates.length == 0) {
            throw new IOException("Directory does not contain any files: " + directoryName);
        }

        for (File file : fileCandidates) {
            if (file.isFile()) {
                files.add(file);
            }
        }

        return files;
    }

    private void solve(List<File> inputFiles, List<File> outputFiles, ProblemSolver problemSolver) throws IOException {
        if (inputFiles.size() != outputFiles.size()) {
            throw new RuntimeException("Input file list size != output file list size.");
        }

        for (int i = 0; i < inputFiles.size(); i++) {
            File inputFile = inputFiles.get(i);
            File outputFile = outputFiles.get(i);

            Logger.verbose("Starting solver for: " + inputFile.getName());

            Data data = Data.read(inputFile);
            problemSolver.solve(data);
            data.write(outputFile);
        }
    }

}
