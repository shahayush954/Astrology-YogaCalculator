package yogas;

import birthChart.BirthChart;
import chartBlocks.Planets;
import chartBlocks.Rashis;

import java.util.HashSet;
import java.util.Set;

/*
 * Damni Yoga (Nabhasa): the seven classical grahas (Sun through Saturn) occupy exactly six distinct
 * whole-sign rashis — one sign is shared by two grahas, the other five signs each hold one. Contrast
 * {@link VallakiYoga} (seven distinct signs), {@link PasaYoga} (five), and {@link KedaraYoga} (four).
 * Rahu and Ketu are ignored.
 */
public class DamniYoga extends AbstractYoga {

    public DamniYoga() {
        setYogaName("Damni Yoga");
        setYogaEffect("When the seven traditional grahas spread across only six signs, one pair doubling up, the chart tightens focus yet keeps breadth — concentrated alliances of influence and blended outcomes when other factors agree.");
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
        return distinctSigns.size() == 6;
    }
}
