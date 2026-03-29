package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;

/*
 * Gaja Yoga: the lord of the 9th house counted from the 11th is in the 11th house together with the
 * Moon, and the 11th house is aspected by the lord of the 11th (standard graha drishti from that
 * lord’s house).
 */
public class GajaYoga extends AbstractYoga {

    public GajaYoga() {
        setYogaName("Gaja Yoga");
        setYogaEffect("Supports gains, honour, and steadiness of fortune; the link between the 7th-from-11th lord, the Moon, and the 11th lord’s aspect on the house of gains can elevate status and prosperity when the chart agrees.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        Houses eleventh = Houses.ELEVENTH_HOUSE;
        Houses ninthFromEleventh = birthChartData.getNthHouseFromGivenHouse(eleventh, 9);
        Planets lordOfNinthFromEleventh = birthChartData.getLordOfHouse(ninthFromEleventh);
        if (lordOfNinthFromEleventh == null) {
            return false;
        }
        if (!eleventh.equals(birthChartData.getPlanetHouses().get(lordOfNinthFromEleventh))) {
            return false;
        }
        if (!eleventh.equals(birthChartData.getPlanetHouses().get(Planets.MOON))) {
            return false;
        }
        Planets lordOfEleventh = birthChartData.getLordOfHouse(eleventh);
        if (lordOfEleventh == null) {
            return false;
        }
        return birthChartData.planetAspectsHouse(lordOfEleventh, eleventh);
    }
}
