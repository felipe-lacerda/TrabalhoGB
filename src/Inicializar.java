import java.sql.Array;
import java.util.*;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.Arrays.stream;
import static java.util.Collections.*;
import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.toList;

public class Inicializar {

    public static Integer[] inicializarChaveUnica(final Integer size, final Boolean aleatoria, final Boolean inverter) {
        Integer[] array = Stream.generate(() -> new Random().nextInt(size))
                .distinct()
                .limit(size)
                .collect(toList())
                .toArray(new Integer[0]);

        if (nonNull(aleatoria) && aleatoria) {
            return array;
        }

        stream(array).sorted();

        if (inverter) {
            reverse(asList(array));
        }

        return array;
    }

    public static HashMap<String, ArrayList> inicializarHasMap() {
        HashMap<String, ArrayList> hashMap = new HashMap<>();
        hashMap.put("BubbleSort", new ArrayList());
        hashMap.put("Insertion", new ArrayList());
        hashMap.put("Selection", new ArrayList());
        hashMap.put("Heap", new ArrayList());
        hashMap.put("Shell", new ArrayList());
        hashMap.put("Merge", new ArrayList());
        hashMap.put("Quick", new ArrayList());
        return hashMap;
    }
}
