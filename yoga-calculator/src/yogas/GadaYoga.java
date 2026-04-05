package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;

import java.util.HashSet;
import java.util.Set;

/*
 * Gada Yoga: the seven classical grahas (Sun through Saturn) all occupy only the first pair of
 * consecutive kendras from Lagna — the 1st and 4th houses — and each of those two houses has at least
 * one of them. Rahu and Ketu are ignored.
 */
public class GadaYoga extends AbstractYoga {

    public GadaYoga() {
        setYogaName("Gada Yoga");
        setYogaEffect("When every traditional graha is confined to Lagna and the 4th from it, with both angles occupied, the chart stresses self and foundations — a tight mace-like concentration of planetary force on personality and inner stability when other factors agree.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        Set<Integer> housesOccupiedBySeven = new HashSet<>();
        for (Planets planet : Planets.SEVEN_GRAHAS) {
            Houses house = birthChartData.getPlanetHouses().get(planet);
            if (house == null) {
                return false;
            }
            int n = house.getHouseNumber();
            if (n != 1 && n != 4) {
                return false;
            }
            housesOccupiedBySeven.add(n);
        }
        return housesOccupiedBySeven.size() == 2;
    }
}
