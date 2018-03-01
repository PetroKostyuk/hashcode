package Competition;

import Framework.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Structure containing all global variables.
 * Use 'public' modifier for them all.
 */
public class Data {
    static Logger logger = new Logger(true);

    public List<Ride> rides; // sorted by lastStart
    public List<List<Integer>> assignedRides;
    public int simulationTime;
    public int vehiclesCount;
    public int ridesCount;
    public int bonus;

    public void logAll(){
        logger.log("simulationTime: " + simulationTime);
        logger.log("vehiclesCount: " + vehiclesCount);
        logger.log("ridesCount: " + ridesCount);
        logger.log("bonus: " + bonus);
        logger.log("rides:");
        for(int i=0; i<rides.size(); i++){
            logger.log(rides.get(i).toString());
        }
    }

    public static Data read(File file) throws IOException{
        Scanner sc = new Scanner(file);
        Data data = new Data();

        // TODO: during competition
        logger.log("Loading data from file:");
        logger.log(file);
        logger.log();

        sc.nextInt();
        sc.nextInt();
        data.vehiclesCount = sc.nextInt();
        data.ridesCount = sc.nextInt();
        data.bonus = sc.nextInt();
        data.simulationTime = sc.nextInt();

        data.rides = new LinkedList<>();
        for(int i=0; i<data.ridesCount; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            int s = sc.nextInt();
            int f = sc.nextInt();
            data.rides.add(new Ride(i, a, b, x, y, s, f));
        }

        data.assignedRides = new LinkedList<>();
        for(int i=0; i<data.vehiclesCount; i++){
            data.assignedRides.add(new LinkedList<>());
        }

        data.logAll();

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
