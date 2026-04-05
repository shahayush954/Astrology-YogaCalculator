package yogas;

import birthChart.BirthChart;
import chartBlocks.Planets;
import chartBlocks.Rashis;

import java.util.HashSet;
import java.util.Set;

/*
 * Yuga Yoga (Nabhasa, negative): the seven classical grahas (Sun through Saturn) occupy exactly two
 * distinct whole-sign rashis. See {@link SulaYoga} (three signs) and {@link GolaYoga} (one sign).
 * Rahu and Ketu are ignored.
 */
public class YugaYoga extends AbstractYoga {

    public YugaYoga() {
        setYogaName("Yuga Yoga");
        setYogaEffect("When the seven traditional grahas compress into only two signs, polarisation and imbalance between two areas of life can dominate; extremes of fortune or stress are likelier unless other factors strongly moderate.");
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
        return distinctSigns.size() == 2;
    }
}
