package yogas;

public abstract class AbstractYoga implements Yoga {

    private String yogaName;
    private String yogaEffect;

    @Override
    public String getYogaName() {
        return yogaName;
    }

    @Override
    public String getYogaEffect() {
        return yogaEffect;
    }

    public void setYogaName(String yogaName) {
        this.yogaName = yogaName;
    }

    public void setYogaEffect(String yogaEffect) {
        this.yogaEffect = yogaEffect;
    }
}
