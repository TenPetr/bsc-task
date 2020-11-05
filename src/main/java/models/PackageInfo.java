package models;

public class PackageInfo {

    private String postalCode;

    private Double weight;

    public PackageInfo(final String postalCode, final Double weight) {
        this.postalCode = postalCode;
        this.weight = weight;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(final String postalCode) {
        this.postalCode = postalCode;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(final Double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return postalCode + " " + weight;
    }
}
