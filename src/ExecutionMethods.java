/*
Grupo 1
Felipe Lacerda da Silva
Felipe Flores
John Lenon Marques de Oliveira
 */

import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.System.nanoTime;

public class ExecutionMethods {

    private HashMap<String, ArrayList> dados;
    private Integer[] array;
    private Integer execution;
    private Long start;
    private Long finish;
    private Long time;

    public ExecutionMethods(final Integer[] array) {
        this.array = array;
        dados = new HashMap<>();
        execution = 1;
        dados = Util.initializeHashMap();
    }

    public HashMap<String, ArrayList> run(final HashMap<String, ArrayList> table) {
        this.runBubbleSort();
        this.runInsertion();
        this.runSelection();
        this.runHeap();
        this.runShell();
        this.runMergeSort();
        this.runQuickSort();
        return Calculation.calculate(dados, table);
    }

    private void runBubbleSort() {
        while (execution <= 10) {
            start = nanoTime();
            Methods.bubbleSort(array.clone());
            finish = nanoTime();
            time = finish - start;
            execution++;
            dados.get("Bubble").add(time);
        }
        execution = 1;
    }

    private void runInsertion() {
        while (execution <= 10) {
            start = nanoTime();
            Methods.insertionSort(array.clone());
            finish = nanoTime();
            time = finish - start;
            execution++;
            dados.get("Insertion").add(time);
        }
        execution = 1;
    }

    private void runSelection() {
        while (execution <= 10) {
            start = nanoTime();
            Methods.selectionSort(array.clone());
            finish = nanoTime();
            time = finish - start;
            execution++;
            dados.get("Selection").add(time);
        }
        execution = 1;
    }

    private void runHeap() {
        while (execution <= 10) {
            start = nanoTime();
            Methods.heapSort(array.clone());
            finish = nanoTime();
            time = finish - start;
            execution++;
            dados.get("Heap").add(time);
        }
        execution = 1;
    }

    private void runShell() {
        while (execution <= 10) {
            start = nanoTime();
            Methods.shellSort(array.clone());
            finish = nanoTime();
            time = finish - start;
            execution++;
            dados.get("Shell").add(time);
        }
        execution = 1;
    }

    private void runMergeSort() {
        while (execution <= 10) {
            start = nanoTime();
            Methods.mergeSort(array.clone());
            finish = nanoTime();
            time = finish - start;
            execution++;
            dados.get("Merge").add(time);
        }
        execution = 1;
    }

    private void runQuickSort() {
        while (execution <= 10) {
            start = nanoTime();
            Methods.quickSort(array.clone());
            finish = nanoTime();
            time = finish - start;
            execution++;
            dados.get("Quick").add(time);
        }
        execution = 1;
    }
}
