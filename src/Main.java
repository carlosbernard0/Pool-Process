import Classes.ComputingProcess;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);

//      Declarações de variáaveis

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

                    System.out.print("\nDigite o nome do arquivo a ser criado: ");
                    String nomeArquivoCriado = input.nextLine();
                    file = new File("C:\\Users\\GuilhermeCosta3\\Desktop\\Trabalho\\"+nomeArquivoCriado+".txt");

                    FileWriter escreverFileCriado = new FileWriter(file,true);
                    escreverFileCriado.close();

                    break;

                case 2:

                    System.out.print("\nDigite o nome do arquivo a ser carregado: ");
                    String nomeArquivoCarregado = input.nextLine();
                    file = new File("C:\\Users\\GuilhermeCosta3\\Desktop\\Trabalho\\"+nomeArquivoCarregado+".txt");

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

                    // Cálculo
                    if(tipoDeProcessoEscolhido==1){
                        ComputingProcess c1 = new ComputingProcess(contadorId++);

                        System.out.print("\nDigite o valor do primeiro operador: ");
                        c1.setFirstOperator(input.nextDouble());

                    }
                    // Gravação
                    if(tipoDeProcessoEscolhido==2){}
                    // Leitura
                    if(tipoDeProcessoEscolhido==3){}
                    // Impressão
                    if(tipoDeProcessoEscolhido==4){}
            }



        }while(true);




    }
}

