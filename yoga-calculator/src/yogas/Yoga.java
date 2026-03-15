package yogas;

import birthChart.BirthChart;

import java.util.Arrays;
import java.util.List;

public interface Yoga {

    List<Yoga> positiveYogas = Arrays.asList(
            new GajKesariYoga(),
            new SunaphaYoga(),
            new AnaphaYoga(),
            new DhurdhuraYoga(),
            new AdhiYoga(),
            new ChatussagaraYoga(),
            new VasumathiYoga(),
            new RajalakshanaYoga(),
            new AmalaYoga(),
            new ParvataYoga(),
            new VesiYoga(),
            new VasiYoga(),
            new ObhayachariYoga()
    );

    List<Yoga> negativeYogas = Arrays.asList(
            new KemaDrumaYoga(),
            new ChandraMangalaYoga(),
            new SakataYoga(),
            new VanchanaChoraBheethiYoga()
    );

    boolean isYogaPresent(BirthChart birthChartData);
    String getYogaName();
    String getYogaEffect();
}
