package Classes;

import java.io.IOException;
import java.util.ArrayList;

public class PrintingProcess extends Process{

    ArrayList<Process> poolDeProcessos;

    public PrintingProcess(Integer pid, ArrayList<Process> poolDeProcessos) {
        super(pid);
        this.poolDeProcessos = poolDeProcessos;
    }

    public PrintingProcess(Integer pid) {
        super(pid);
    }

    @Override
    public void execute() throws IOException {

        for (Process processo : poolDeProcessos){
            System.out.println(processo.toString());
        }

    }

    @Override
    public String toString() {
        return getPid() + " PrintingProcess\n";

    }
}
