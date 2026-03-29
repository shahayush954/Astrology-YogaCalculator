package yogas;

import birthChart.BirthChart;

/*
 * Sukha Malika Yoga: seven classical grahas occupy seven consecutive houses from the 4th.
 */
public class SukhaMalikaYoga extends AbstractYoga {

    public SukhaMalikaYoga() {
        setYogaName("Sukha Malika Yoga");
        setYogaEffect("Emphasizes home, emotional foundation, property, and inner peace. The seven grahas through the 4th-house sector often deepen roots, comfort, and domestic stability.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        return MalikaYogaChecker.sevenGrahasOnePerConsecutiveFrom(birthChartData, 4);
    }
}
