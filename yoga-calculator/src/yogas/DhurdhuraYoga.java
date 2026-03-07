package yogas;

import birthChart.BirthChart;
/*
If there are planets on either side of the Moon, the combination goes under the name of Dhurdhura.
Benefics present then more auspicious
 */
public class DhurdhuraYoga extends AbstractYoga{

    public DhurdhuraYoga() {
        setYogaName("Dhurdhura Yoga");
        setYogaEffect("The native is bountiful. He will be blessed with much wealth and conveyances. . It signifies immense wealth, prosperity, intellectual wisdom, and unparalleled willpower. This yoga brings steady growth, charitable nature, and recognition to the native. ");
    }
    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        return new SunaphaYoga().isYogaPresent(birthChartData) && new AnaphaYoga().isYogaPresent(birthChartData);
    }
}
