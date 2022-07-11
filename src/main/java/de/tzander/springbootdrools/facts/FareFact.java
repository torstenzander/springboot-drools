package de.tzander.springbootdrools.facts;

public class FareFact {

    private Long nightSurcharge = 0L;
    private Long rideFare;

    public Long getNightSurcharge() {
        return nightSurcharge;
    }

    public void setNightSurcharge(Long nightSurcharge) {
        this.nightSurcharge = nightSurcharge;
    }

    public Long getRideFare() {
        return rideFare;
    }

    public void setRideFare(Long rideFare) {
        this.rideFare = rideFare;
    }

    public Long getTotalFare() {
        return nightSurcharge + rideFare;
    }
}
