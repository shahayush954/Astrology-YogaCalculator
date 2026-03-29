package yogas;

import birthChart.BirthChart;

/*
 * Kalatra Malika Yoga: seven classical grahas occupy seven consecutive houses from the 7th.
 */
public class KalatraMalikaYoga extends AbstractYoga {

    public KalatraMalikaYoga() {
        setYogaName("Kalatra Malika Yoga");
        setYogaEffect("Often strains marriage, partnerships, and open enemies. The seven grahas concentrated across the 7th-house sector (wrapping through the 1st) can bring instability in unions, contractual disputes, or friction with the spouse and business allies.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        return MalikaYogaChecker.sevenGrahasOnePerConsecutiveFrom(birthChartData, 7);
    }
}
