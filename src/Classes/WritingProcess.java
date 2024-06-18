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


    public Double getFirstOperator() {
        return firstOperator;
    }

    public void setFirstOperator(Double firstOperator) {
        this.firstOperator = firstOperator;
    }

    public Double getSecondOperator() {
        return secondOperator;
    }

    public void setSecondOperator(Double secondOperator) {
        this.secondOperator = secondOperator;
    }

    public String getOperatorSignal() {
        return operatorSignal;
    }

    public void setOperatorSignal(String operatorSignal) {
        this.operatorSignal = operatorSignal;
    }
}
