package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;

import java.util.HashSet;
import java.util.Set;

/**
 * Shared logic for Malika yogas: the seven classical grahas each occupy one of seven
 * consecutive houses from a given starting house (1–12), counting forward with wrap.
 */
final class MalikaYogaChecker {

    private MalikaYogaChecker() {
    }

    static boolean sevenGrahasOnePerConsecutiveFrom(BirthChart chart, int firstHouse) {
        if (firstHouse < 1 || firstHouse > 12) {
            throw new IllegalArgumentException("firstHouse must be 1–12: " + firstHouse);
        }
        Set<Integer> window = new HashSet<>();
        for (int i = 0; i < 7; i++) {
            window.add(((firstHouse - 1 + i) % 12) + 1);
        }
        Set<Integer> occupied = new HashSet<>();
        for (Planets planet : Planets.SEVEN_GRAHAS) {
            Houses house = chart.getPlanetHouses().get(planet);
            if (house == null) {
                return false;
            }
            int n = house.getHouseNumber();
            if (!window.contains(n) || !occupied.add(n)) {
                return false;
            }
        }
        return occupied.size() == 7;
    }
}
