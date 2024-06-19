package Classes;

import java.io.IOException;

public abstract class Process {
    private Integer pid;

    public Process(Integer pid) {
        this.pid = pid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public void execute() throws IOException {

    }

}
