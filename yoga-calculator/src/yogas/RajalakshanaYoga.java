package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;

/*
Rajalakshana Yoga is formed when Jupiter, Venus, Mercury and the Moon occupy the 1st, 4th, 7th or 10th
houses (Kendras) irrespective of the order. The yoga also occurs when all four of these planets
are specifically placed in the 1st house.
 */
public class RajalakshanaYoga extends AbstractYoga {

    public RajalakshanaYoga() {
        setYogaName("Rajalakshana Yoga");
        setYogaEffect("The native gains royal or noble qualities, good reputation, wealth and comfort. The combination of these four planets in angular houses bestows dignity, leadership, and success in worldly and spiritual pursuits. The native will possess an attractive appearance and he will be endowed with all the good qualities of high personage");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        Houses houseOfJupiter = birthChartData.getPlanetHouses().get(Planets.JUPITER);
        Houses houseOfVenus = birthChartData.getPlanetHouses().get(Planets.VENUS);
        Houses houseOfMercury = birthChartData.getPlanetHouses().get(Planets.MERCURY);
        Houses houseOfMoon = birthChartData.getPlanetHouses().get(Planets.MOON);

        return isInKendra(houseOfJupiter) && isInKendra(houseOfVenus)
                && isInKendra(houseOfMercury) && isInKendra(houseOfMoon);
    }

    private boolean isInKendra(Houses house) {
        return BirthChart.KENDRA_HOUSES.contains(house);
    }
}
