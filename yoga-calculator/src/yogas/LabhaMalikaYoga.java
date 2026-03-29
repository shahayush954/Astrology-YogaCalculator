package yogas;

import birthChart.BirthChart;

/*
 * Labha Malika Yoga: seven classical grahas occupy seven consecutive houses from the 11th.
 */
public class LabhaMalikaYoga extends AbstractYoga {

    public LabhaMalikaYoga() {
        setYogaName("Labha Malika Yoga");
        setYogaEffect("Relates to gains, networks, aspirations, and elder siblings. The seven grahas through the 11th-house arc often support fulfilment of goals and social reward.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        return MalikaYogaChecker.sevenGrahasOnePerConsecutiveFrom(birthChartData, 11);
    }
}
