package Competition;

import Framework.Logger;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Structure containing all global variables.
 * Use 'public' modifier for them all.
 */
public class Data {
    public String deleteMe = ":P";

    public static Data read(File file) throws IOException{
        Scanner sc = new Scanner(file);
        Data data = new Data();

        // TODO: during competition
        Logger.verbose("Loading data from file:");
        Logger.verbose(file);
        Logger.verbose();

        return data;
    }

    public void write(File file) throws IOException {
        // TODO: here the file is created and written into

        Logger.verbose("Saving data to file:");
        Logger.verbose(file);
        Logger.verbose();

    }
}
