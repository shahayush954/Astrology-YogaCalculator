package chartBlocks;

public enum Houses {

    FIRST_HOUSE(1),
    SECOND_HOUSE(2),
    THIRD_HOUSE(3),
    FOURTH_HOUSE(4),
    FIFTH_HOUSE(5),
    SIXTH_HOUSE(6),
    SEVENTH_HOUSE(7),
    EIGHT_HOUSE(8),
    NINTH_HOUSE(9),
    TENTH_HOUSE(10),
    ELEVENTH_HOUSE(11),
    TWELVTH_HOUSE(12);

    private final int house;

    Houses(int house) { this.house = house; }

    public static Houses getHouseByNumber(int num) {
        if (num < 1 || num > 12) {
            System.out.println("Invalid number for a House");
            return null;
        }
        switch (num) {
            case 1:
                return FIRST_HOUSE;
            case 2:
                return SECOND_HOUSE;
            case 3:
                return THIRD_HOUSE;
            case 4:
                return FOURTH_HOUSE;
            case 5:
                return FIFTH_HOUSE;
            case 6:
                return SIXTH_HOUSE;
            case 7:
                return SEVENTH_HOUSE;
            case 8:
                return EIGHT_HOUSE;
            case 9:
                return NINTH_HOUSE;
            case 10:
                return TENTH_HOUSE;
            case 11:
                return ELEVENTH_HOUSE;
            case 12:
                return TWELVTH_HOUSE;
        }
        return null;
    }

    @Override
    public String toString() {
        return String.valueOf(this.house);
    }
}
