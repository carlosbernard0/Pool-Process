package Classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadingProcess extends Process {

    File fileComputation = new File("..\\Pool-Process\\src\\computation.txt");
    File fileListaProcessos = new File("..\\Pool-Process\\src\\listaProcessos.txt");

    public ArrayList<Process> arquivoDeLeitura;

    public ReadingProcess(Integer pid) {
        super(pid);
    }

    @Override
    public void execute() throws IOException {
        //ler cada coluna do array (arquivo) e printar na tela
        Scanner inputArquivoComputation = new Scanner(fileComputation);
        ArrayList<ComputingProcess> novosProcessos = new ArrayList<>();


        while (inputArquivoComputation.hasNextLine()){
            String linha = inputArquivoComputation.nextLine();
            String[] colunas = linha.split(" ");

            ArrayList<Integer> arrayIds = new ArrayList<>();
            Scanner inputListaProcessos = new Scanner(fileListaProcessos);
            while (inputListaProcessos.hasNextLine()) {
                String linhaLista = inputListaProcessos.nextLine();
                String[] colunasLista = linhaLista.split(" ");
                arrayIds.add(Integer.valueOf(colunasLista[0]));
            }

            int ultimoIdDaLista = arrayIds.size()-1;
            int idDoProcesso = arrayIds.get(ultimoIdDaLista);

            ComputingProcess process = new ComputingProcess(++idDoProcesso);
            arrayIds.add(idDoProcesso);    //adicionando na lista para os proximos processos tiverem id diferentes
            process.setFirstOperator(Double.valueOf(colunas[1]));
            process.setOperatorSignal(colunas[2]);
            process.setSecondOperator(Double.valueOf(colunas[3]));

            novosProcessos.add(process);
            FileWriter escreverListaProcessos = new FileWriter(fileListaProcessos, true);
            escreverListaProcessos.write(process.toString());
            escreverListaProcessos.close();
        }

        FileWriter escreverComputationAtualizado = new FileWriter(fileComputation,false);
        escreverComputationAtualizado.write("");
        escreverComputationAtualizado.close();
    }

    @Override
    public String toString() {
        return getPid() + " ReadingProcess\n";
    }
}
