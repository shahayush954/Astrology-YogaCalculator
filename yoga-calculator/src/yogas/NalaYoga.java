package yogas;

import birthChart.BirthChart;
import chartBlocks.Planets;
import chartBlocks.Rashis;

/*
 * Nala Yoga (Nabhasa, negative): the seven classical grahas (Sun through Saturn) all occupy only mixed
 * (dual / ubhaya) rashis — see {@link BirthChart#MIXED_RASHIS}. {@link RajjuYoga} and {@link MusalaYoga}
 * use the same pattern for movable and fixed signs (positive). Rahu and Ketu are ignored.
 */
public class NalaYoga extends AbstractYoga {

    public NalaYoga() {
        setYogaName("Nala Yoga");
        setYogaEffect("When every traditional graha sits in dual signs only, instability, indecision, and scattered results can dominate; versatility may come at the cost of steadiness unless the chart strongly compensates.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        for (Planets planet : Planets.SEVEN_GRAHAS) {
            Rashis rashi = birthChartData.getPlanetWiseRashis().get(planet);
            if (rashi == null || !BirthChart.MIXED_RASHIS.contains(rashi)) {
                return false;
            }
        }
        return true;
    }
}
