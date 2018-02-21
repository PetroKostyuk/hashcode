package Competition;

import Framework.Logger;

import java.io.File;
import java.util.Scanner;

public class Loader {
    Logger log = new Logger(true);

    public Data load(File file) throws Exception{
        Scanner sc = new Scanner(file);
        Data data = new Data();

        // TODO: during competition
        log.write("Loading data from file:");
        log.write(file);
        log.write();

        return data;
    }
}
