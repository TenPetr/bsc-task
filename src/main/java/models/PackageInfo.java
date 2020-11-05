package models;

public class PackageInfo {

    private String postalCode;

    private Float weight;

    public PackageInfo(final String postalCode, final Float weight) {
        this.postalCode = postalCode;
        this.weight = weight;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(final String postalCode) {
        this.postalCode = postalCode;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(final Float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return postalCode + " " + weight;
    }
}
