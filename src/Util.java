/*
Grupo 1
Felipe Lacerda da Silva
Felipe Flores
John Lenon Marques de Oliveira
 */

import java.util.*;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.Arrays.stream;
import static java.util.Collections.*;
import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.toList;

public class Util {

    public static Integer[] initializeArrayUniqueKeys(final Integer size, final Boolean random, final Boolean reverse) {
        Integer[] array = Stream.generate(() -> new Random().nextInt())
                .distinct()
                .limit(size)
                .collect(toList())
                .toArray(new Integer[0]);

        if (nonNull(random) && random) {
            return array;
        }

        stream(array).sorted();

        if (reverse) {
            reverse(asList(array));
        }

        return array;
    }

    public static Integer[] initializeArrayDuplicateKeys(final Integer size, final Integer repeatedPercentage) {
        ArrayList<Integer> arrayList = new ArrayList();

        Integer[] array = new Integer[size];

        final Integer repetidos = (int) Math.floor(size * ((double) repeatedPercentage / 100));

        while (arrayList.size() < size) {
            Integer number = new Random().nextInt();
            for (int i = 1; i <= repetidos && arrayList.size() != size; i++) {
                arrayList.add(number);
            }
        }

        Integer count = 0;

        while (arrayList.size() != 0) {
            Integer position = new Random().nextInt(arrayList.size());
            array[count++] = arrayList.get(position);
            arrayList.remove(arrayList.get(position));
        }

        return array;
    }

    public static HashMap<String, ArrayList> initializeHashMap() {
        HashMap<String, ArrayList> hashMap = new HashMap<>();
        hashMap.put("Bubble", new ArrayList());
        hashMap.put("Insertion", new ArrayList());
        hashMap.put("Selection", new ArrayList());
        hashMap.put("Heap", new ArrayList());
        hashMap.put("Shell", new ArrayList());
        hashMap.put("Merge", new ArrayList());
        hashMap.put("Quick", new ArrayList());
        return hashMap;
    }
}
