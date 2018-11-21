/*
Grupo 1
Felipe Lacerda da Silva
Felipe Flores
John Lenon Marques de Oliveira
 */

import java.util.ArrayList;
import java.util.HashMap;

public class Scenarios {
    private HashMap<String, ArrayList> table;
    private Integer execution;
    private Integer size;

    public void scenarioAscendingOrderUniqueKeys() throws Exception {
        initializeAttributes();
        while (execution <= 4) {
            System.out.println(size);
            table = new ExecutionMethods(Util.initializeArrayUniqueKeys(size, null, false)).run(table);
            size *= 2;
            execution++;
        }
        System.out.println(table);
        new GeneratorPDF("teste", table).runReport();
    }

    public void scenarioDescendingOrderUniqueKeys(){
        initializeAttributes();
        while (execution <= 10) {
            System.out.println(size);
            table = new ExecutionMethods(Util.initializeArrayUniqueKeys(size, null, true)).run(table);
            size *= 2;
            execution++;
        }
        System.out.println(table);
    }

    public void scenarioRandomOrderUniqueKeys(){
        initializeAttributes();
        while (execution <= 10) {
            System.out.println(size);
            table = new ExecutionMethods(Util.initializeArrayUniqueKeys(size, true, null)).run(table);
            size *= 2;
            execution++;
        }
        System.out.println(table);
    }

    public void scenarioRandomOrderDuplicateKeys(){
        initializeAttributes();
        while (execution <= 10) {
            System.out.println(size);
            table = new ExecutionMethods(Util.initializeArrayDuplicateKeys(size, 5)).run(table);
            size *= 2;
            execution++;
        }
        System.out.println(table);
    }

    public void allScenarios() throws Exception {
        scenarioAscendingOrderUniqueKeys();
        scenarioDescendingOrderUniqueKeys();
        scenarioRandomOrderUniqueKeys();
        scenarioRandomOrderDuplicateKeys();
    }

    private void initializeAttributes(){
        table = Util.initializeHashMap();
        execution = 1;
        size = 128;
    }
}
