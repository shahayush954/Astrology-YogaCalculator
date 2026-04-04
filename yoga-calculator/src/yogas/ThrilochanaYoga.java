package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * Thrilochana (Trilochana) Yoga: the Sun, Moon, and Mars occupy three distinct houses that form one
 * elemental trine — {1,5,9}, {2,6,10}, {3,7,11}, or {4,8,12} — so each is in trine to the other two
 * (whole-sign chart).
 */
public class ThrilochanaYoga extends AbstractYoga {

    private static final int[][] TRIKONA_HOUSE_GROUPS = {
            {1, 5, 9},
            {2, 6, 10},
            {3, 7, 11},
            {4, 8, 12}
    };

    public ThrilochanaYoga() {
        setYogaName("Thrilochana Yoga");
        setYogaEffect("The Sun, Moon, and Mars spread across one trikona set can sharpen courage, clarity, and decisive energy when the chart supports it — a pattern linked to penetrating vision and firm action.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        Houses sunHouse = birthChartData.getPlanetHouses().get(Planets.SUN);
        Houses moonHouse = birthChartData.getPlanetHouses().get(Planets.MOON);
        Houses marsHouse = birthChartData.getPlanetHouses().get(Planets.MARS);
        if (sunHouse == null || moonHouse == null || marsHouse == null) {
            return false;
        }

        Set<Integer> occupied = new HashSet<>(Arrays.asList(
                sunHouse.getHouseNumber(),
                moonHouse.getHouseNumber(),
                marsHouse.getHouseNumber()
        ));
        if (occupied.size() != 3) {
            return false;
        }

        for (int[] group : TRIKONA_HOUSE_GROUPS) {
            Set<Integer> expected = new HashSet<>();
            for (int h : group) {
                expected.add(h);
            }
            if (occupied.equals(expected)) {
                return true;
            }
        }
        return false;
    }
}
