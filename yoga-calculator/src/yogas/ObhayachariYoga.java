package yogas;

import birthChart.BirthChart;

/*
Obhayachari Yoga is formed when both Vasi Yoga and Vesi Yoga are present in the chart.
 */
public class ObhayachariYoga extends AbstractYoga {

    public ObhayachariYoga() {
        setYogaName("Obhayachari Yoga");
        setYogaEffect("The native enjoys the combined benefits of Vasi and Vesi yogas—wealth, comforts, support from others, and gains through distant or subtle matters. The person is often fortunate, prosperous and well regarded. The person will be an eloquent speaker. He will have well-proportioned limbs, will take delight in everything, will be liked by all. wealthy and famous.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        return new VesiYoga().isYogaPresent(birthChartData)
                && new VasiYoga().isYogaPresent(birthChartData);
    }
}
