package yogas;

import birthChart.BirthChart;

/*
 * Bhagya Malika Yoga: seven classical grahas occupy seven consecutive houses from the 9th.
 */
public class BhagyaMalikaYoga extends AbstractYoga {

    public BhagyaMalikaYoga() {
        setYogaName("Bhagya Malika Yoga");
        setYogaEffect("Supports fortune, dharma, higher learning, and grace from teachers. The seven grahas across the 9th-house arc favour wisdom, travel for purpose, and ethical rise.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        return MalikaYogaChecker.sevenGrahasOnePerConsecutiveFrom(birthChartData, 9);
    }
}
