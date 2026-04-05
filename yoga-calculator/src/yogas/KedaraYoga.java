package yogas;

import birthChart.BirthChart;
import chartBlocks.Planets;
import chartBlocks.Rashis;

import java.util.HashSet;
import java.util.Set;

/*
 * Kedara Yoga (Nabhasa): the seven classical grahas (Sun through Saturn) occupy exactly four distinct
 * whole-sign rashis. Contrast {@link VallakiYoga} (seven), {@link DamniYoga} (six), and
 * {@link PasaYoga} (five). Denser clusters — {@link SulaYoga} (three), {@link YugaYoga} (two), and
 * {@link GolaYoga} (one sign) — are negative Nabhasa yogas. Rahu and Ketu are ignored.
 */
public class KedaraYoga extends AbstractYoga {

    public KedaraYoga() {
        setYogaName("Kedara Yoga");
        setYogaEffect("When the seven traditional grahas compress into only four signs, like a field ploughed into few furrows, themes of consolidation, practical focus, and earth-bound stability can dominate when the chart supports them.");
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
        return distinctSigns.size() == 4;
    }
}
