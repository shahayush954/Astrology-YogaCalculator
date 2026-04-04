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
            new DevendraYoga(),
            new AdhiYoga(),
            new ChatussagaraYoga(),
            new ChandikaYoga(),
            new VasumathiYoga(),
            new VidyutYoga(),
            new VishnuYoga(),
            new RajalakshanaYoga(),
            new AmalaYoga(),
            new AmsavatarYoga(),
            new ParvataYoga(),
            new VesiYoga(),
            new VasiYoga(),
            new ObhayachariYoga(),
            new HamsaYoga(),
            new HariHaraBrahmaYoga(),
            new IndraYoga(),
            new JayaYoga(),
            new MalavyaYoga(),
            new MatsyaYoga(),
            new MakutaYoga(),
            new RaviYoga(),
            new RuchakaYoga(),
            new BhadraYoga(),
            new BrahmaYoga(),
            new BudhaAdityaYoga(),
            new KalaNidhiYoga(),
            new KulvardhanaYoga(),
            new KusumaYoga(),
            new MahaBhagyaYoga(),
            new PushkalaYoga(),
            new LakshmiYoga(),
            new GarudaYoga(),
            new GauriYoga(),
            new GoYoga(),
            new BharathiYoga(),
            new ChapaYoga(),
            new SreenathaYoga(),
            new SivaYoga(),
            new ThrilochanaYoga(),
            new ParijathaYoga(),
            new LagnaMalikaYoga(),
            new DhanaMalikaYoga(),
            new VikramaMalikaYoga(),
            new SukhaMalikaYoga(),
            new PutraMalikaYoga(),
            new BhagyaMalikaYoga(),
            new KarmaMalikaYoga(),
            new LabhaMalikaYoga(),
            new VrayaMalikaYoga(),
            new YupaYoga(),
            new IshuYoga(),
            new SaktiYoga(),
            new DandaYoga()
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
