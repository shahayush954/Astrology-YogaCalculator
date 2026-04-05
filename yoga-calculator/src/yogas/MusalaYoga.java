package yogas;

import birthChart.BirthChart;
import chartBlocks.Planets;
import chartBlocks.Rashis;

/*
 * Musala Yoga (Nabhasa): the seven classical grahas (Sun through Saturn) all occupy only fixed
 * (sthira) rashis — see {@link BirthChart#FIXED_RASHIS}. {@link RajjuYoga} (movable) and
 * {@link NalaYoga} (dual signs; negative) are related. Rahu and Ketu are ignored.
 */
public class MusalaYoga extends AbstractYoga {

    public MusalaYoga() {
        setYogaName("Musala Yoga");
        setYogaEffect("When every traditional graha sits in fixed signs only, the chart can resemble a pestle — stubborn strength, durability, and resistance to change, for good or ill depending on the rest of the chart.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        for (Planets planet : Planets.SEVEN_GRAHAS) {
            Rashis rashi = birthChartData.getPlanetWiseRashis().get(planet);
            if (rashi == null || !BirthChart.FIXED_RASHIS.contains(rashi)) {
                return false;
            }
        }
        return true;
    }
}
