package yogas;

import birthChart.BirthChart;
import chartBlocks.Planets;
import chartBlocks.Rashis;

import java.util.HashSet;
import java.util.Set;

/*
 * Sula Yoga (Nabhasa, negative): the seven classical grahas (Sun through Saturn) occupy exactly three
 * distinct whole-sign rashis. Denser than {@link KedaraYoga} (four signs); see {@link YugaYoga} and
 * {@link GolaYoga}. Rahu and Ketu are ignored.
 */
public class SulaYoga extends AbstractYoga {

    public SulaYoga() {
        setYogaName("Sula Yoga");
        setYogaEffect("When the seven traditional grahas crowd into only three signs, like a spear-point of force, life can feel sharp, narrow, and prone to conflict or fixation unless the chart offers relief elsewhere.");
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
        return distinctSigns.size() == 3;
    }
}
