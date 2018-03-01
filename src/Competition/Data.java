package Competition;

import Framework.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Structure containing all global variables.
 * Use 'public' modifier for them all.
 */
public class Data {
    static Logger logger = new Logger(true); 
    public String deleteMe = ":P";





    public static Data read(File file) throws IOException{
        Scanner sc = new Scanner(file);
        Data data = new Data();

        // TODO: during competition
        logger.log("Loading data from file:");
        logger.log(file);
        logger.log();

        return data;
    }

    public void write(File file) throws IOException {
        // TODO: here the file is created and written into

        logger.log("Saving data to file:");
        logger.log(file);
        logger.log();

        FileWriter fw = new FileWriter(file);
        fw.close();
    }
}
