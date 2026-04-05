package yogas;

import birthChart.BirthChart;
import chartBlocks.Planets;
import chartBlocks.Rashis;

import java.util.HashSet;
import java.util.Set;

/*
 * Gola Yoga (Nabhasa, negative): the seven classical grahas (Sun through Saturn) all occupy the same
 * whole-sign rashi. See {@link SulaYoga} (three signs) and {@link YugaYoga} (two signs). Rahu and
 * Ketu are ignored.
 */
public class GolaYoga extends AbstractYoga {

    public GolaYoga() {
        setYogaName("Gola Yoga");
        setYogaEffect("When every traditional graha shares a single sign, the chart can be overwhelmingly one-note — lack of spread, vulnerability to that sign’s lord and transits, and difficulty balancing life sectors unless the wider chart compensates.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        Set<Rashis> distinctSigns = new HashSet<>();
        for (Planets planet : Planets.SEVEN_GRAHAS) {
            Rashis rashi = birthChartData.getPlanetWiseRashis().get(planet);
            if (rashi == null) {
                return false;
            }
            distinctSigns.add(rashi);
        }
        return distinctSigns.size() == 1;
    }
}
