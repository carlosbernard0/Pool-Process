import Classes.*;
import Classes.Process;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static File fileListaProcessos = new File("..\\Pool-Process\\src\\listaProcessos.txt");

    public Main() throws IOException {
    }


    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);


//      Declarações de variáveis
        int escolhaDoUsuario;
        int tipoDeProcessoEscolhido;
        int contadorId = 0;
        ArrayList<Process> listaDeProcessos = new ArrayList<>();

        System.out.println(fileListaProcessos.getPath());

//      Execução do código
        System.out.println("Sistema de Processos...\n");



        do {

            System.out.println("""
                    \nEscolha uma opção:
                    
                    (1) - Criar novo processo.
                    (2) - Executar próximo processo.
                    (3) - Executar processo por Id (pId).
                    (4) - Salvar a fila de processos.
                    (5) - Carregar do arquivo a fila de processos.
                    (0) - Parar execução.
                    
                    """);

            System.out.print("Digite a opção desejada: ");
            escolhaDoUsuario = input.nextInt();
            input.nextLine();

            switch (escolhaDoUsuario){

                case 0:
                    System.exit(0);
                case 1:

                    System.out.println("""
                    
                    Tipos de Processos:
                    
                    (1) - Cálculo.
                    (2) - Gravação.
                    (3) - Leitura.
                    (4) - Impressão.
                    
                    """);

                    System.out.print("Digite o tipo de processo escolhido: ");
                    tipoDeProcessoEscolhido = input.nextInt();
                    input.nextLine();

                    //region Processo de Cálculo (ComputingProcess)

                    if(tipoDeProcessoEscolhido==1){
                        ComputingProcess c1 = new ComputingProcess(++contadorId);

                        System.out.print("\nDigite o valor do primeiro operador: ");
                        c1.setFirstOperator(input.nextDouble());
                        input.nextLine();

                        System.out.print("\nDigite o sinal de operação (+,-,*,/): ");
                        String sinalDoOperador = input.nextLine();

                        System.out.print("\nDigite o valor do segundo operador: ");
                        c1.setSecondOperator(input.nextDouble());
                        input.nextLine();

                        if(!c1.verificarOperador(sinalDoOperador)){
                            break;
                        }

                        System.out.println("\nProcesso de cálculo guardado com sucesso! seu pId é "+contadorId+".");

                        listaDeProcessos.add(c1);

                    }
                    //endregion

                    //region Processo de Gravação (WritingProcess)

                    if(tipoDeProcessoEscolhido==2){

                        WritingProcess w1 = new WritingProcess(++contadorId);

                        System.out.print("\nDigite o valor do primeiro operador: ");
                        w1.setFirstOperator(input.nextDouble());
                        input.nextLine();

                        System.out.print("\nDigite o sinal de operação (+,-,*,/)");
                        String sinalDoOperador = input.nextLine();

                        System.out.print("\nDigite o valor do segundo operador: ");
                        w1.setSecondOperator(input.nextDouble());
                        input.nextLine();

                        if(!w1.verificarOperador(sinalDoOperador)){
                            break;
                        }

                        System.out.println("\nProcesso de gravação guardado com sucesso! seu pId é "+contadorId+".");


                        listaDeProcessos.add(w1);

                    }

                    //endregion

                    //region Processo de Leitura (ReadingProcess)
                    if(tipoDeProcessoEscolhido==3){
                        ReadingProcess r1 = new ReadingProcess(++contadorId);
                        // Criando o método e passando a lista

                        System.out.println("\nProcesso de leitura guardada com sucesso! seu pId é "+contadorId+".");


                        listaDeProcessos.add(r1);
                    }
                    //endregion

                    //region Processo de Impressão (PrintingProcess)
                    if(tipoDeProcessoEscolhido==4){
                        PrintingProcess p1 = new PrintingProcess(++contadorId, listaDeProcessos);
                        System.out.println("\nProcesso de impressão guardada com sucesso! seu pId é "+contadorId+".");

                        p1.execute(); //testes

                        listaDeProcessos.add(p1);
                    }
                    //endregion

                    break;
                case 2:
                    Process processoExecute = listaDeProcessos.get(0);
                    System.out.printf("\nExecutando processo (%d) ...\n",processoExecute.getPid());
                    processoExecute.execute();
                    listaDeProcessos.remove(0);
                    atualizarArquivoListaProcessos(processoExecute.getPid(),processoExecute,listaDeProcessos);

                    break;
                case 3:
                    break;
                case 4:
                    FileWriter escrever = new FileWriter(fileListaProcessos,true);

                    for (int i = 0; i < listaDeProcessos.size(); i++) {
                            escrever.write(listaDeProcessos.get(i).toString());
                    }
                    contadorId = listaDeProcessos.size()-1;
                    escrever.close();
                    break;
                case 5:
                    ArrayList<Process> listaCarregamento = new ArrayList<>();
                    Scanner inputArquivo = new Scanner(fileListaProcessos);

                    while (inputArquivo.hasNextLine()){
                        String linha = inputArquivo.nextLine();
                        String[] colunas = linha.split(" ");

                        //criacao do objeto conforme o nome
                        if (colunas[1].equals("ComputingProcess")){
                           ComputingProcess process = new ComputingProcess(Integer.parseInt(colunas[0]));

                            process.setFirstOperator(Double.parseDouble(colunas[2]));
                            process.setOperatorSignal(colunas[3]);
                            process.setSecondOperator(Double.parseDouble(colunas[4]));
                            listaCarregamento.add(process);

                        } else if (colunas[1].equals("WritingProcess")) {
                            WritingProcess process = new WritingProcess(Integer.parseInt(colunas[0]));

                            process.setFirstOperator(Double.parseDouble(colunas[2]));
                            process.setOperatorSignal(colunas[3]);
                            process.setSecondOperator(Double.parseDouble(colunas[4]));
                            listaCarregamento.add(process);

                        }else if (colunas[1].equals("ReadingProcess")) {
                            ReadingProcess process = new ReadingProcess(Integer.parseInt(colunas[0]));

                            listaCarregamento.add(process);

                        }else if (colunas[1].equals("PrintingProcess")) {
                            PrintingProcess process = new PrintingProcess(Integer.parseInt(colunas[0]));

                            listaCarregamento.add(process);
                        }
                    }

                    // removendo todos registros da lista principal (SE TIVER)
                    for (int i = 0; i < listaDeProcessos.size(); i++) {
                        listaDeProcessos.remove(listaDeProcessos.get(i));
                    }

                    // adicionando os registros criados da listaAux para o array principal
                    listaDeProcessos.addAll(listaCarregamento);


                    contadorId = listaCarregamento.size()-1;
                    break;

            }





        }while(true);




    }

    public static void retornarProcessos(ArrayList<Process> listaDeProcessos, FileWriter escreverFileCriado) throws IOException {

        for (int i = 0; i < listaDeProcessos.size(); i++) {
            escreverFileCriado.write(listaDeProcessos.get(i).toString());
        }
    }

    // vai excluir o processo que foi executado e assim atualizando o arquivo
    public static void atualizarArquivoListaProcessos (Integer idDoProcesso,Process processRemove,ArrayList<Process> listaAtual) throws IOException {
        Scanner inputArquivo = new Scanner(fileListaProcessos);

        //encontrar o arquivo que esta sendo executado e remover da listaAtual
        while (inputArquivo.hasNextLine()){
            String linha = inputArquivo.nextLine();
            String[] colunas = linha.split(" ");
            Integer idProcess = Integer.parseInt(colunas[0]);
            if (idProcess.equals(idDoProcesso)){
                listaAtual.remove(processRemove);
            }
        }

        //salvar o arquivo da lista nova
        FileWriter escreverArquivoAtualizado = new FileWriter(fileListaProcessos,false);
        for (int i = 0; i < listaAtual.size(); i++) {
            escreverArquivoAtualizado.write(listaAtual.get(i).toString());
        }
        escreverArquivoAtualizado.close();



    }

}

