package yogas;

import birthChart.BirthChart;
import chartBlocks.Planets;
import chartBlocks.Rashis;

import java.util.HashSet;
import java.util.Set;

/*
 * Pasa Yoga (Nabhasa): the seven classical grahas (Sun through Saturn) occupy exactly five distinct
 * whole-sign rashis (two “overlaps” among the seven — e.g. two pairs sharing signs, or a triple plus
 * a pair, etc.). Contrast {@link VallakiYoga} (seven signs), {@link DamniYoga} (six), and
 * {@link KedaraYoga} (four). Rahu and Ketu are ignored.
 */
public class PasaYoga extends AbstractYoga {

    public PasaYoga() {
        setYogaName("Pasa Yoga");
        setYogaEffect("When the seven traditional grahas cluster into only five signs, like a noose drawing strands together, themes of binding, focus, and shared conditions gain weight — for good or ill depending on the rest of the chart.");
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
        return distinctSigns.size() == 5;
    }
}
