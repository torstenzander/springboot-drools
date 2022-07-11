package de.tzander.springbootdrools;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TaxiFareCalculatorServiceIT {

    @Autowired
    private TaxiFareCalculatorService taxiFareCalculatorService;

    @Test
    public void shouldFareWithoutNighchargeWhenNightSurchargeFalseAndDistanceLessThan10() {
        TaxiRideFact taxiRide = new TaxiRideFact();
        taxiRide.setNightSurcharge(false);
        taxiRide.setDistanceInMile(9L);
        FareFact rideFareFact = new FareFact();
        Long totalCharge = taxiFareCalculatorService.calculateFare(taxiRide, rideFareFact);

        assertNotNull(totalCharge);
        assertEquals(Long.valueOf(70), totalCharge);
    }

    @Test
    public void shouldFareWithoutNighchargeWhenNightSurchargeFalseAndDistanceLessMoreThan10() {
        TaxiRideFact taxiRide = new TaxiRideFact();
        taxiRide.setNightSurcharge(false);
        taxiRide.setDistanceInMile(11L);
        FareFact rideFareFact = new FareFact();
        Long totalCharge = taxiFareCalculatorService.calculateFare(taxiRide, rideFareFact);

        assertNotNull(totalCharge);
        assertEquals(Long.valueOf(50), totalCharge);
    }

}
