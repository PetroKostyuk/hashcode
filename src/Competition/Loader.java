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
        log.log("Loading data from file:");
        log.log(file);
        log.log();

        return data;
    }
}
