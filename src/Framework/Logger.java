package Framework;

public class Logger {
    private boolean log;
    public static boolean MAIN_VERBOSITY = true;

    public Logger(boolean log){
        this.log = log;
    }

    public void log(){
        log("");
    }

    public void log(Object o){
        if(log) {
            System.out.println(o);
        }
    }
}
