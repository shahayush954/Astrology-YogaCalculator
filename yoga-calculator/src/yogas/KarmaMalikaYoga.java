package yogas;

import birthChart.BirthChart;

/*
 * Karma Malika Yoga: seven classical grahas occupy seven consecutive houses from the 10th.
 */
public class KarmaMalikaYoga extends AbstractYoga {

    public KarmaMalikaYoga() {
        setYogaName("Karma Malika Yoga");
        setYogaEffect("Spotlights career, reputation, authority, and public duty. Grahas spanning the 10th-house arc strengthen visibility, responsibility, and achievement in the world.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        return MalikaYogaChecker.sevenGrahasOnePerConsecutiveFrom(birthChartData, 10);
    }
}
