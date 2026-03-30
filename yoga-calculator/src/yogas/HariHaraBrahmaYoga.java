package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Hari Hara Brahma Yoga: present when at least one of the following holds —
 * Hari: natural benefics occupy the 2nd, 8th, and 12th houses from the lord of the 2nd (each of
 * those three houses has at least one benefic).
 * Hara: Jupiter, Moon, and Mercury each lie in the 4th, 8th, or 9th house from the lord of the 7th.
 * Brahma: Sun, Venus, and Mars each lie in the 4th, 10th, or 11th house from the Lagna lord.
 */
public class HariHaraBrahmaYoga extends AbstractYoga {

    public HariHaraBrahmaYoga() {
        setYogaName("Hari Hara Brahma Yoga");
        setYogaEffect("Arises when Hari, Hara, or Brahma yoga is present alone or in combination. It ties wealth and speech houses (Hari), the 7th-lord arc for mind and wisdom (Hara), and the Lagna-lord connection of Sun, Venus, and Mars in the 4th, 10th, or 11th from the Lagna lord (Brahma), supporting vitality, harmony, and drive when the chart supports it.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        return isHariYoga(birthChartData)
                || isHaraYoga(birthChartData)
                || isBrahmaYoga(birthChartData);
    }

    private static boolean isHariYoga(BirthChart birthChart) {
        Planets lordOfSecond = birthChart.getLordOfHouse(Houses.SECOND_HOUSE);
        if (lordOfSecond == null) {
            return false;
        }
        Houses lord2House = birthChart.getPlanetHouses().get(lordOfSecond);
        if (lord2House == null) {
            return false;
        }
        Houses secondFromLord = birthChart.getNthHouseFromGivenHouse(lord2House, 2);
        Houses eighthFromLord = birthChart.getNthHouseFromGivenHouse(lord2House, 8);
        Houses twelfthFromLord = birthChart.getNthHouseFromGivenHouse(lord2House, 12);
        return houseHasNaturalBenefic(birthChart, secondFromLord)
                && houseHasNaturalBenefic(birthChart, eighthFromLord)
                && houseHasNaturalBenefic(birthChart, twelfthFromLord);
    }

    private static boolean isHaraYoga(BirthChart birthChart) {
        Planets lordOfSeventh = birthChart.getLordOfHouse(Houses.SEVENTH_HOUSE);
        if (lordOfSeventh == null) {
            return false;
        }
        Houses lord7House = birthChart.getPlanetHouses().get(lordOfSeventh);
        if (lord7House == null) {
            return false;
        }
        Set<Houses> allowed = housesFromReference(birthChart, lord7House, 4, 8, 9);
        return planetInHouseSet(birthChart, Planets.JUPITER, allowed)
                && planetInHouseSet(birthChart, Planets.MOON, allowed)
                && planetInHouseSet(birthChart, Planets.MERCURY, allowed);
    }

    private static boolean isBrahmaYoga(BirthChart birthChart) {
        Planets lagnaLord = birthChart.getLordOfHouse(Houses.FIRST_HOUSE);
        if (lagnaLord == null) {
            return false;
        }
        Houses lagnaLordHouse = birthChart.getPlanetHouses().get(lagnaLord);
        if (lagnaLordHouse == null) {
            return false;
        }
        Set<Houses> allowed = housesFromReference(birthChart, lagnaLordHouse, 4, 10, 11);
        return planetInHouseSet(birthChart, Planets.SUN, allowed)
                && planetInHouseSet(birthChart, Planets.VENUS, allowed)
                && planetInHouseSet(birthChart, Planets.MARS, allowed);
    }

    private static Set<Houses> housesFromReference(BirthChart birthChart, Houses reference, int... deltas) {
        Set<Houses> set = new HashSet<>();
        for (int d : deltas) {
            set.add(birthChart.getNthHouseFromGivenHouse(reference, d));
        }
        return set;
    }

    private static boolean planetInHouseSet(BirthChart birthChart, Planets planet, Set<Houses> houses) {
        Houses h = birthChart.getPlanetHouses().get(planet);
        return h != null && houses.contains(h);
    }

    private static boolean houseHasNaturalBenefic(BirthChart birthChart, Houses house) {
        List<Planets> inHouse = birthChart.getHouseWisePlanets().getOrDefault(house, new ArrayList<>());
        List<Planets> benefics = birthChart.getNaturalBeneficPlanets();
        return inHouse.stream().anyMatch(benefics::contains);
    }
}
