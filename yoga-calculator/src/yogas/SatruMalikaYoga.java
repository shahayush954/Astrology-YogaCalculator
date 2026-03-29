package yogas;

import birthChart.BirthChart;

/*
 * Satru Malika Yoga: seven classical grahas occupy seven consecutive houses from the 6th.
 */
public class SatruMalikaYoga extends AbstractYoga {

    public SatruMalikaYoga() {
        setYogaName("Satru Malika Yoga");
        setYogaEffect("Tends to stress enmity, litigation, disease, debt, and daily friction. All seven grahas packed through the 6th-house arc can magnify obstacles, rivals, and worry over health and subsistence unless strongly tempered elsewhere in the chart.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        return MalikaYogaChecker.sevenGrahasOnePerConsecutiveFrom(birthChartData, 6);
    }
}
