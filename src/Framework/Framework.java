package Framework;

import Competition.Data;
import Competition.Loader;
import Competition.Saver;
import Competition.Solver;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class Framework {
    Logger log = new Logger(true);
    String specificCase = "big.in";

    String directoryIn = "data/in";
    String directoryOut = "data/out";

    public static void main(String[] args) {
        new Framework();
    }

    public Framework(){
        List<File> files = getFiles();
        for (File fileIn : files) {
            // prepare output file
            String baseName = fileIn.getName();
            File fileOut = new File(directoryOut+"/"+baseName+".out");

            try {
                process(fileIn, fileOut);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void process(File fileIn, File fileOut) throws Exception{
        // Load data, solve data, save data. Piece of cake, right?

        // load data
        Loader loader = new Loader();
        Data data = loader.load(fileIn);

        // solve data
        Solver solver = new Solver();
        solver.solve(data);

        // save data
        Saver saver = new Saver();
        saver.save(fileOut, data);
    }


    public List<File> getFiles(){
        List<File> result = new LinkedList<>();

        if(!specificCase.equals("")){
            result.add(new File(directoryIn + "/" + specificCase));
            return result;
        }

        File dir = new File(directoryIn);
        File[] allFiles = dir.listFiles();

        for (File file : allFiles) {
            if (file.isFile()) {
                result.add(file);
            }
        }

        return result;
    }


}
