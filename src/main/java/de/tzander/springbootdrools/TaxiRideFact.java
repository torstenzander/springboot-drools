package de.tzander.springbootdrools;

public class TaxiRideFact {

    private Boolean isNightSurcharge;

    private Long distanceInMile;

    public TaxiRideFact() {
    }

    public TaxiRideFact(Boolean isNightSurcharge, Long distanceInMile) {
        this.isNightSurcharge = isNightSurcharge;
        this.distanceInMile = distanceInMile;
    }

    public Boolean getNightSurcharge() {
        return isNightSurcharge;
    }

    public void setNightSurcharge(Boolean nightSurcharge) {
        isNightSurcharge = nightSurcharge;
    }

    public Long getDistanceInMile() {
        return distanceInMile;
    }

    public void setDistanceInMile(Long distanceInMile) {
        this.distanceInMile = distanceInMile;
    }

}
