package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;

import java.util.HashSet;
import java.util.Set;

/*
 * Hala Yoga (Nabhasa): the seven classical grahas (Sun through Saturn) all occupy only the houses of
 * one whole-sign triad — either 2nd–6th–10th, or 3rd–7th–11th, or 4th–8th–12th from Lagna — and each
 * house in that triad has at least one of them. Rahu and Ketu are ignored.
 */
public class HalaYoga extends AbstractYoga {

    public HalaYoga() {
        setYogaName("Hala Yoga");
        setYogaEffect("When every traditional graha clusters in one whole-sign trikona from Lagna — the artha (2-6-10), kama (3-7-11), or moksha (4-8-12) set — with all three houses used, the chart can show a plough-like pattern of steady toil and recurring results when other factors agree.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        return sevenGrahasFillTriad(birthChartData, 2, 6, 10)
                || sevenGrahasFillTriad(birthChartData, 3, 7, 11)
                || sevenGrahasFillTriad(birthChartData, 4, 8, 12);
    }

    private static boolean sevenGrahasFillTriad(BirthChart birthChartData, int a, int b, int c) {
        Set<Integer> occupied = new HashSet<>();
        for (Planets planet : Planets.SEVEN_GRAHAS) {
            Houses house = birthChartData.getPlanetHouses().get(planet);
            if (house == null) {
                return false;
            }
            int n = house.getHouseNumber();
            if (n != a && n != b && n != c) {
                return false;
            }
            occupied.add(n);
        }
        return occupied.size() == 3;
    }
}
