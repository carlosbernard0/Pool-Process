package Classes;

import java.util.Objects;

public class ComputingProcess extends Process{
    private Double firstOperator;
    private Double secondOperator;
    private String operatorSignal;

    public ComputingProcess(Integer pid){super(pid);}


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

    @Override
    public void execute(){
        double result = 0.0;
        if (Objects.equals(operatorSignal, "+")) {result = secondOperator+firstOperator;}
        if (Objects.equals(operatorSignal, "-")) {result = firstOperator-secondOperator;}
        if (Objects.equals(operatorSignal, "*")) {result = firstOperator*secondOperator;}
        if (Objects.equals(operatorSignal, "/")) {result = firstOperator/secondOperator;}
        System.out.println("\nO resultado da operação "+firstOperator+" "+operatorSignal+" "+secondOperator+" é: "+ result);
    }


    public boolean verificarOperador(String sinalDoOperador){
        if(sinalDoOperador.equals("+") || sinalDoOperador.equals("-") ||
                sinalDoOperador.equals("*") || sinalDoOperador.equals("/"))
        {
            this.setOperatorSignal(sinalDoOperador);
            return true;
        }else
        {
            System.out.println("\nOperador inválido!");
            return false;
        }

    }

    @Override
    public String toString() {
        return this.firstOperator + " " + operatorSignal+ " "+this.secondOperator+"\n";
    }
}
