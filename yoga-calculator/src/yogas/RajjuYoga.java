package yogas;

import birthChart.BirthChart;
import chartBlocks.Planets;
import chartBlocks.Rashis;

/*
 * Rajju Yoga (Nabhasa): the seven classical grahas (Sun through Saturn) all occupy only movable
 * (chara) rashis — see {@link BirthChart#MOVABLE_RASHIS}. {@link MusalaYoga} (fixed) and
 * {@link NalaYoga} (dual signs; negative) follow the same idea. Rahu and Ketu are ignored.
 */
public class RajjuYoga extends AbstractYoga {

    public RajjuYoga() {
        setYogaName("Rajju Yoga");
        setYogaEffect("When every traditional graha sits in movable signs only, the chart can resemble a rope — motion, change, and shifting circumstances; adaptability and restlessness together when other factors agree.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        for (Planets planet : Planets.SEVEN_GRAHAS) {
            Rashis rashi = birthChartData.getPlanetWiseRashis().get(planet);
            if (rashi == null || !BirthChart.MOVABLE_RASHIS.contains(rashi)) {
                return false;
            }
        }
        return true;
    }
}
