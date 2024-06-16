package Classes;

public class WritingProcess extends Process{

    private Double firstOperator;
    private Double secondOperator;
    private String operatorSignal;

    public WritingProcess(Integer pid, Double firstOperator, Double secondOperator, String operatorSignal) {
        super(pid);
        this.firstOperator = firstOperator;
        this.secondOperator = secondOperator;
        this.operatorSignal = operatorSignal;
    }

    @Override
    public void execute() {
        super.execute();

//        file.write("O resultado da conta 2 * 2 é  resultado")

    }
}
