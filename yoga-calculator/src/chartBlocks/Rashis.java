package chartBlocks;

public enum Rashis {

    ARIES("Aries"),
    TAURUS("Taurus"),
    GEMINI("Gemini"),
    CANCER("Cancer"),
    LEO("Leo"),
    VIRGO("Virgo"),
    LIBRA("Libra"),
    SCORPIO("Scorpio"),
    SAGITTARIUS("Sagittarius"),
    CAPRICORN("Capricorn"),
    AQUARIUS("Aquarius"),
    PISCES("Pisces");

    private final String rashiName;
    Rashis(String rashiName) { this.rashiName = rashiName; }

    @Override
    public String toString() {
        return this.rashiName;
    }

    public static Rashis getRashiFromNumber(int num) {
        if (num < 1 || num > 12) {
            System.out.println("Invalid number for rashi");
            return null;
        }
        switch (num) {
            case 1:
                return ARIES;
            case 2:
                return TAURUS;
            case 3:
                return GEMINI;
            case 4:
                return CANCER;
            case 5:
                return LEO;
            case 6:
                return VIRGO;
            case 7:
                return LIBRA;
            case 8:
                return SCORPIO;
            case 9:
                return SAGITTARIUS;
            case 10:
                return CAPRICORN;
            case 11:
                return AQUARIUS;
            case 12:
                return PISCES;
        }
        return null;
    }

    public static Integer getRashiNumber(Rashis rashi) {
        switch (rashi) {
            case ARIES:
                return 1;
            case TAURUS:
                return 2;
            case GEMINI:
                return 3;
            case CANCER:
                return 4;
            case LEO:
                return 5;
            case VIRGO:
                return 6;
            case LIBRA:
                return 7;
            case SCORPIO:
                return 8;
            case SAGITTARIUS:
                return 9;
            case CAPRICORN:
                return 10;
            case AQUARIUS:
                return 11;
            case PISCES:
                return 12;
            default:
                System.out.println("Invalid Rashi Provided: " + rashi);
                return null;
        }
    }

}
