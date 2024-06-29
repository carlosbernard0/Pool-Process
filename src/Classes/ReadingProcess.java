package Classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadingProcess extends Process {

    public ArrayList<Process> arquivoDeLeitura;

    public ReadingProcess(Integer pid) {
        super(pid);
    }

    @Override
    public void execute() throws IOException {
//        for (int i = 0; i < this.arquivoDeLeitura.size(); i++) {
            //ler cada coluna do array (arquivo) e printar na tela
        File fileCarregar = new File("..\\Pool-Process\\src\\computation.txt");

        Scanner inputArquivo = new Scanner(fileCarregar);

        while (inputArquivo.hasNextLine()){
            String linha = inputArquivo.nextLine();
            String[] colunas = linha.split(" ");

            ArrayList<Double> arrayIds = new ArrayList<>();
            File fileListaProcessos = new File("..\\Pool-Process\\src\\listaProcessos.txt");
            Scanner inputListaProcessos = new Scanner(fileListaProcessos);
            while (inputListaProcessos.hasNextLine()) {
                String linhaLista = inputArquivo.nextLine();
                String[] colunasLista = linhaLista.split(" ");
                arrayIds.add(Double.valueOf(colunasLista[0]));
            }
            double teste = arrayIds.size();
            Double idDoProcesso = arrayIds.get(teste);

            ComputingProcess computingProcess = new ComputingProcess(idDoProcesso);
            computingProcess.setFirstOperator(Double.valueOf(colunas[1]));
            computingProcess.setOperatorSignal(colunas[2]);
            computingProcess.setSecondOperator(Double.valueOf(colunas[3]));




        }

        FileWriter arquivoAtualizado = new FileWriter(fileCarregar,false);

        arquivoAtualizado.write(" ");
        arquivoAtualizado.close();

//        }

    }

    @Override
    public String toString() {
        return getPid() + " ReadingProcess";
    }
}
