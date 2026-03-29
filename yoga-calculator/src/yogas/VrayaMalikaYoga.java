package yogas;

import birthChart.BirthChart;

/*
 * Vraya (Vyaya) Malika Yoga: seven classical grahas occupy seven consecutive houses from the 12th.
 */
public class VrayaMalikaYoga extends AbstractYoga {

    public VrayaMalikaYoga() {
        setYogaName("Vraya Malika Yoga");
        setYogaEffect("Connects to liberation themes, foreign lands, expenses, and the bed of loss. Grahas across the 12th-house arc can favour spirituality, retreat, and life beyond material fixation when other factors support it.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        return MalikaYogaChecker.sevenGrahasOnePerConsecutiveFrom(birthChartData, 12);
    }
}
