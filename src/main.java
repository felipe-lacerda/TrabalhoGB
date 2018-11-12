import java.util.ArrayList;
import java.util.HashMap;

public class main {

    public static void main(String[] args) {
        HashMap<String, ArrayList> tabela = Inicializar.inicializarHasMap();
        Integer execucao = 1;
        Integer size = 128;

        //Cenario 1
        while (execucao <= 10) {
            size *= execucao;
            tabela = new Cenarios(Inicializar.inicializarChaveUnica(size, null, false)).run(tabela);
            execucao++;
        }
        System.out.println(tabela);
        //TODO salvar tabela em arquivo

        //Cenario 2
        tabela = Inicializar.inicializarHasMap();
        execucao = 1;
        size = 128;
        while (execucao <= 10) {
            size *= execucao;
            tabela = new Cenarios(Inicializar.inicializarChaveUnica(size, null, true)).run(tabela);
            execucao++;
        }
        System.out.println(tabela);
        //TODO salvar tabela em arquivo

        //Cenario 3
        tabela = Inicializar.inicializarHasMap();
        execucao = 1;
        size = 128;
        while (execucao <= 10) {
            size *= execucao;
            tabela = new Cenarios(Inicializar.inicializarChaveUnica(size, true, null)).run(tabela);
            execucao++;
        }
        System.out.println(tabela);
        //TODO salvar tabela em arquivo

        //Obs diminui o while para uns 6 para testar

    }
}
