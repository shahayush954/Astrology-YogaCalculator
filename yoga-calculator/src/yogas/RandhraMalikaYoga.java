package yogas;

import birthChart.BirthChart;

/*
 * Randhra Malika Yoga: seven classical grahas occupy seven consecutive houses from the 8th.
 */
public class RandhraMalikaYoga extends AbstractYoga {

    public RandhraMalikaYoga() {
        setYogaName("Randhra Malika Yoga");
        setYogaEffect("Increases exposure to sudden setbacks, chronic anxiety, obstacles to longevity, and complexity around others’ wealth. All seven grahas through the 8th-house arc can intensify crises, secrecy, and unpredictable turns unless mitigated by stronger factors.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        return MalikaYogaChecker.sevenGrahasOnePerConsecutiveFrom(birthChartData, 8);
    }
}
