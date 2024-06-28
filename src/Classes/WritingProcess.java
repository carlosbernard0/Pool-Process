package Classes;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WritingProcess extends Process{

    private Double firstOperator;
    private Double secondOperator;
    private String operatorSignal;

    public WritingProcess(Integer pid) {
        super(pid);
    }

    @Override
    public void execute() throws IOException {
        super.execute();

//        File file = new File("C:\\Users\\Admin\\IdeaProjects\\Pool-Process\\src\\computation.txt");
        File file = new File("C:\\Users\\GuilhermeCosta3\\Desktop\\Trabalho\\computation.txt");

        FileWriter escreverFileCriado = new FileWriter(file,true);

        escreverFileCriado.write(firstOperator+operatorSignal+secondOperator+"\n");
        escreverFileCriado.close();

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
        return getPid() + " WritingProcess " + firstOperator + " " + operatorSignal + " " + secondOperator;
    }
}
