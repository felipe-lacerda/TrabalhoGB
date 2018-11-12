import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.lang.Double.parseDouble;
import static java.util.stream.Collectors.toList;

public class Calculo {


    public static HashMap<String, ArrayList> calcular(final HashMap<String, ArrayList> dados, final HashMap<String, ArrayList> tabela) {
        Integer execucao = 0;
        List<String> keys = dados.keySet().stream().collect(Collectors.toList());
        while (execucao < keys.size()) {
            ArrayList times = dados.get(keys.get(execucao));

            if (!times.isEmpty()) {
                Double media = times.stream().mapToLong(time -> Long.valueOf(time.toString())).average().getAsDouble();
                Double total = times.stream().map(time -> Math.pow(parseDouble(time.toString()), 2)).mapToDouble(time -> Double.parseDouble(time.toString())).sum();

                total -= Math.pow(media, 2);
                total /= times.size() - 1;
                total = Math.sqrt(total);

                final Long x1 = Math.round(media - total);
                final Long x2 = Math.round(media + total);

                media = times.stream().filter(time -> (Long) time > x1 && (Long) time < x2).mapToLong(time -> Long.valueOf(time.toString())).average().getAsDouble();

                tabela.get(keys.get(execucao)).add(Math.round(media));
            }
            execucao++;
        }

        return tabela;
    }
}
