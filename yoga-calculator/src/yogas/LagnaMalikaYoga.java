package yogas;

import birthChart.BirthChart;


/*
 * Lagna Malika Yoga is formed when all seven classical planets (Sun, Moon, Mars, Mercury,
 * Jupiter, Venus, Saturn), excluding Rahu and Ketu, occupy the seven consecutive houses
 * beginning from the Lagna (houses 1 through 7), one planet per house.
 */
public class LagnaMalikaYoga extends AbstractYoga {

    public LagnaMalikaYoga() {
        setYogaName("Lagna Malika Yoga");
        setYogaEffect("The native is endowed with vitality, influence, and the ability to rise in life. The seven grahas filling the first seven houses from Lagna strengthens the self, relationships, and material pursuits in a balanced way, often bringing recognition, prosperity, and a commanding presence. The check for planets is done out of order");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        return MalikaYogaChecker.sevenGrahasOnePerConsecutiveFrom(birthChartData, 1);
    }
}
