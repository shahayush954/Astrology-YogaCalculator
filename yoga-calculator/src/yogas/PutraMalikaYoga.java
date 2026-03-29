package yogas;

import birthChart.BirthChart;

/*
 * Putra Malika Yoga: seven classical grahas occupy seven consecutive houses from the 5th.
 */
public class PutraMalikaYoga extends AbstractYoga {

    public PutraMalikaYoga() {
        setYogaName("Putra Malika Yoga");
        setYogaEffect("Highlights creativity, children, speculation, and intelligence. Grahas spanning the 5th-house arc support learning, progeny themes, and expressive pursuits.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        return MalikaYogaChecker.sevenGrahasOnePerConsecutiveFrom(birthChartData, 5);
    }
}
