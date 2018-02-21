package Competition;

import Framework.Logger;

import java.io.File;

public class Loader {
    Logger log = new Logger(true);

    public Data load(File file){
        Data data = new Data();

        // TODO: during competition
        log.write("Loading data from file:");
        log.write(file);
        log.write();

        return data;
    }
}
