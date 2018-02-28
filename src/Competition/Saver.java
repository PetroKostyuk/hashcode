package Competition;

import Framework.Logger;

import java.io.File;

public class Saver {
    Logger log = new Logger(true);

    public void save(File file, Data data){

        // TODO: save data to file
        log.log("Saving data to file:");
        log.log(file);
        log.log();

    }
}
