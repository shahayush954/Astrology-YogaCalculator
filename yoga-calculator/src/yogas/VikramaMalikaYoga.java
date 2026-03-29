package yogas;

import birthChart.BirthChart;

/*
 * Vikrama Malika Yoga: seven classical grahas occupy seven consecutive houses from the 3rd.
 */
public class VikramaMalikaYoga extends AbstractYoga {

    public VikramaMalikaYoga() {
        setYogaName("Vikrama Malika Yoga");
        setYogaEffect("Strengthens courage, initiative, siblings, and hands-on skills. The grahas across the 3rd-house arc support bold action, communication, and practical enterprise.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        return MalikaYogaChecker.sevenGrahasOnePerConsecutiveFrom(birthChartData, 3);
    }
}
