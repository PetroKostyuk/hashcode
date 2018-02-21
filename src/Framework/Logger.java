package Framework;

public class Logger {
    boolean log;

    public Logger(boolean log){
        this.log = log;
    }

    public void write(){
        write("");
    }

    public void write(Object o){
        if(log) {
            System.out.println(o);
        }
    }
}
