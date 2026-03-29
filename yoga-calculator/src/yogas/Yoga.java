package yogas;

import birthChart.BirthChart;

import java.util.Arrays;
import java.util.List;

public interface Yoga {

    List<Yoga> positiveYogas = Arrays.asList(
            new GajKesariYoga(),
            new GajaYoga(),
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
            new ObhayachariYoga(),
            new HamsaYoga(),
            new MalavyaYoga(),
            new RuchakaYoga(),
            new BhadraYoga(),
            new BudhaAdityaYoga(),
            new MahaBhagyaYoga(),
            new PushkalaYoga(),
            new LakshmiYoga(),
            new GauriYoga(),
            new BharathiYoga(),
            new ChapaYoga(),
            new SreenathaYoga(),
            new ParijathaYoga(),
            new LagnaMalikaYoga(),
            new DhanaMalikaYoga(),
            new VikramaMalikaYoga(),
            new SukhaMalikaYoga(),
            new PutraMalikaYoga(),
            new BhagyaMalikaYoga(),
            new KarmaMalikaYoga(),
            new LabhaMalikaYoga(),
            new VrayaMalikaYoga()
    );

    List<Yoga> negativeYogas = Arrays.asList(
            new KemaDrumaYoga(),
            new ChandraMangalaYoga(),
            new SakataYoga(),
            new VanchanaChoraBheethiYoga(),
            new SasaYoga(),
            new SatruMalikaYoga(),
            new KalatraMalikaYoga(),
            new RandhraMalikaYoga()
    );

    boolean isYogaPresent(BirthChart birthChartData);
    String getYogaName();
    String getYogaEffect();
}
