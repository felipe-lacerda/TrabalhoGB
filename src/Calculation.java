/*
Grupo 1
Felipe Lacerda da Silva
Felipe Flores
John Lenon Marques de Oliveira
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import static java.lang.Double.parseDouble;

public class Calculation {

    public static HashMap<String, ArrayList> calculate(final HashMap<String, ArrayList> dados, final HashMap<String, ArrayList> table) {
        Integer execution = 0;
        List<String> keys = dados.keySet().stream().collect(Collectors.toList());
        while (execution < keys.size()) {
            ArrayList times = dados.get(keys.get(execution));
            if (!times.isEmpty()) {
                Double media = times.stream().mapToLong(time -> Long.valueOf(time.toString())).average().getAsDouble();
                Double total = times.stream().map(time -> Math.pow(parseDouble(time.toString()), 2)).mapToDouble(time -> Double.parseDouble(time.toString())).sum();

                total -= Math.pow(media, 2) * times.size();
                total /= times.size() - 1;
                total = Math.sqrt(total);

                final Double x1 = media - total;
                final Double x2 = media + total;

                media = times.stream().filter(time -> (Long) time >= x1 && (Long) time <= x2).mapToLong(time -> Long.valueOf(time.toString())).average().getAsDouble();

                table.get(keys.get(execution)).add(Math.round(media));
            }
            execution++;
        }

        return table;
    }
}
