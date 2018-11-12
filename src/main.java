import java.util.ArrayList;
import java.util.HashMap;

public class main {

    public static void main(String[] args) {
        HashMap<String, ArrayList> tabela = Inicializar.inicializarHasMap();
        Integer execucao = 1;
        Integer size = 128;
        //Cenario 1
        while (execucao <= 2) {
            size *= execucao;
            tabela = new Cenarios(Inicializar.inicializarChaveUnica(size, false, true)).run(tabela);
            execucao++;
        }

        //Obs diminui o while para uns 6 para testar
        System.out.println(tabela);
    }
}
