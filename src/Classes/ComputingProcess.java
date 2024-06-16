package Classes;

import java.util.Objects;

public class ComputingProcess extends Process{
    private Double firstOperator;
    private Double secondOperator;
    private String operatorSignal;

    public ComputingProcess(Integer pid, Double firstOperator, Double secondOperator,String operatorSignal) {
        super(pid);
        this.firstOperator = firstOperator;
        this.secondOperator = secondOperator;
        this.operatorSignal = operatorSignal;


    }

    @Override
    public void execute(){
        double result = 0.0;
        if (Objects.equals(operatorSignal, "+")) {result = secondOperator+firstOperator;}
        if (Objects.equals(operatorSignal, "-")) {result = firstOperator-secondOperator;}
        if (Objects.equals(operatorSignal, "*")) {result = firstOperator*secondOperator;}
        if (Objects.equals(operatorSignal, "/")) {result = firstOperator/secondOperator;}

    }



}
