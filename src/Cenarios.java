import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.System.currentTimeMillis;
import static java.lang.System.nanoTime;

public class Cenarios {

    private HashMap<String, ArrayList> dados;
    private Integer[] array;
    private Integer execucao;
    private Long start;
    private Long finish;
    private Long time;

    public Cenarios(final Integer[] array) {
        this.array = array;
        dados = new HashMap<>();
        execucao = 1;
        dados = Inicializar.inicializarHasMap();
    }

    public HashMap<String, ArrayList> run(final HashMap<String, ArrayList> tabela) {
        this.runBubbleSort();
        this.runInsertion();
        this.runSelection();
        this.runHeap();
        this.runShell();
        return Calculo.calcular(dados, tabela);
    }

    private void runBubbleSort() {
        while (execucao <= 10) {
            start = nanoTime();
            Metodos.bubbleSort(array.clone());
            finish = nanoTime();
            time = finish - start;
            execucao++;
            dados.get("BubbleSort").add(time);
        }
        execucao = 1;
    }

    private void runInsertion() {
        while (execucao <= 10) {
            start = nanoTime();
            Metodos.insertionSort(array.clone());
            finish = nanoTime();
            time = finish - start;
            execucao++;
            dados.get("Insertion").add(time);
        }
        execucao = 1;
    }

    private void runSelection() {
        while (execucao <= 10) {
            start = currentTimeMillis();
            Metodos.selectionSort(array.clone());
            finish = nanoTime();
            time = finish - start;
            execucao++;
            dados.get("Selection").add(time);
        }
        execucao = 1;
    }

    private void runHeap() {
        while (execucao <= 10) {
            start = nanoTime();
            Metodos.heapSort(array.clone());
            finish = nanoTime();
            time = finish - start;
            execucao++;
            dados.get("Heap").add(time);
        }
        execucao = 1;
    }

    private void runShell() {
        while (execucao <= 10) {
            start = nanoTime();
            Metodos.shellSort(array.clone());
            finish = nanoTime();
            time = finish - start;
            execucao++;
            dados.get("Shell").add(time);
        }
        execucao = 1;
    }
}
