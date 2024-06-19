import Classes.ComputingProcess;
import Classes.Process;
import Classes.WritingProcess;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);

//      Declarações de variáveis
        ArrayList<Process> listaDeProcessos = new ArrayList<>();
        int escolhaDoUsuario;
        int tipoDeProcessoEscolhido;
        int contadorId = 0;

        File file;

//      Execução do código
        System.out.println("Sistema de Processos...\n");


            System.out.println("""
                    Escolha uma opção:
                    
                    (1) - Criar arquivo de processos.
                    (2) - Carregar arquivo de processos.
                    (0) - Parar execução.
                    
                    """);

            System.out.print("Digite a opção desejada: ");
            escolhaDoUsuario = input.nextInt();
            input.nextLine();

            switch (escolhaDoUsuario){

                case 0:
                    System.exit(400);
                case 1:

//                    file = new File("C:\\Users\\Admin\\IdeaProjects\\Pool-Process\\src\\computation.txt");
                  file = new File("C:\\Users\\GuilhermeCosta3\\Desktop\\Trabalho\\computation.txt");

                    FileWriter escreverFileCriado = new FileWriter(file,true);
                    escreverFileCriado.close();

                    break;

                case 2:

                    file = new File("C:\\Users\\Admin\\IdeaProjects\\Pool-Process\\src\\computation.txt");
//                  file = new File("C:\\Users\\GuilhermeCosta3\\Desktop\\Trabalho\\"+nomeArquivoCarregado+".txt");

                    FileWriter escreverFileCarregado = new FileWriter(file,true);

                    break;
            }



        do {

            System.out.println("""
                    Escolha uma opção:
                    
                    (1) - Criar novo processo.
                    (2) - Executar próximo processo.
                    (3) - Executar processo por Id (pId).
                    (0) - Parar execução.
                    
                    """);

            System.out.print("Digite a opção desejada: ");
            escolhaDoUsuario = input.nextInt();
            input.nextLine();

            switch (escolhaDoUsuario){

                case 0:
                    System.exit(400);
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
                        ComputingProcess c1 = new ComputingProcess(contadorId++);

                        System.out.print("\nDigite o valor do primeiro operador: ");
                        c1.setFirstOperator(input.nextDouble());

                        System.out.print("\nDigite o valor do segundo operador: ");
                        c1.setSecondOperator(input.nextDouble());

                        System.out.print("\nDigite o sinal de operação (+,-,*,/)");
                        String sinalDoOperador = input.nextLine();

                        if(!c1.verificarOperador(sinalDoOperador)){
                            break;
                        }
                        assert listaDeProcessos != null;
                        listaDeProcessos.add(c1);

                    }
                    //endregion

                    //region Processo de Gravação (WritingProcess)

                    if(tipoDeProcessoEscolhido==2){

                        WritingProcess w1 = new WritingProcess(contadorId++);

                        System.out.print("\nDigite o valor do primeiro operador: ");
                        w1.setFirstOperator(input.nextDouble());

                        System.out.print("\nDigite o valor do segundo operador: ");
                        w1.setSecondOperator(input.nextDouble());
                        input.nextLine();

                        System.out.print("\nDigite o sinal de operação (+,-,*,/)");
                        String sinalDoOperador = input.nextLine();

                        if(!w1.verificarOperador(sinalDoOperador)){
                            break;
                        }

                        assert listaDeProcessos != null;

                        listaDeProcessos.add(w1);

                        w1.execute();

                    }

                    //endregion

                    //region Processo de Leitura (ReadingProcess)
                    if(tipoDeProcessoEscolhido==3){}
                    //endregion

                    //region Processo de Impressão (PrintingProcess)
                    if(tipoDeProcessoEscolhido==4){}
                    //endregion
            }



        }while(true);




    }
}

