package yogas;

import birthChart.BirthChart;


/*
 * Dhana Malika Yoga is formed when all seven classical planets (Sun, Moon, Mars, Mercury,
 * Jupiter, Venus, Saturn), excluding Rahu and Ketu, occupy seven consecutive houses
 * beginning from the 2nd house (houses 2 through 8), one planet per house.
 */
public class DhanaMalikaYoga extends AbstractYoga {

    public DhanaMalikaYoga() {
        setYogaName("Dhana Malika Yoga");
        setYogaEffect("The native tends toward financial stability, resourcefulness, and growth through family, values, and sustained effort. The seven grahas spanning the wealth-oriented arc from the 2nd house often supports accumulation, earning power, and material comfort when other factors align.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        return MalikaYogaChecker.sevenGrahasOnePerConsecutiveFrom(birthChartData, 2);
    }
}
