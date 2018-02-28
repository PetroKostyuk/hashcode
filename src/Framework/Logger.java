package Framework;

public class Logger {
    boolean log;

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
