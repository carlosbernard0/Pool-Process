package Classes;

import java.util.ArrayList;

public class ReadingProcess extends Process {

    public ArrayList<Process> arquivoDeLeitura;

    public ReadingProcess(Integer pid, ArrayList<Process> textoTransformadoParaLista) {
        super(pid);
        this.arquivoDeLeitura = textoTransformadoParaLista;
    }

    @Override
    public void execute(){
        for (int i = 0; i < this.arquivoDeLeitura.size(); i++) {
            //ler cada coluna do array (arquivo) e printar na tela
        }
    }

    @Override
    public String toString() {
        return "("+ getPid() + ")" + " ReadingProcess";
    }
}
