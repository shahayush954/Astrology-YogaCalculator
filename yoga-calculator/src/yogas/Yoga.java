package yogas;

import birthChart.BirthChart;

import java.util.Arrays;
import java.util.List;

public interface Yoga {

    List<Yoga> positiveYogas = Arrays.asList(
            new GajKesariYoga(),
            new SunaphaYoga(),
            new AnaphaYoga(),
            new DhurdhuraYoga()
    );

    List<Yoga> negativeYogas = Arrays.asList();

    boolean isYogaPresent(BirthChart birthChartData);
    String getYogaName();
    String getYogaEffect();
}
