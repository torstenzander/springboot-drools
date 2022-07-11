package de.tzander.springbootdrools.service;

import de.tzander.springbootdrools.facts.FareFact;
import de.tzander.springbootdrools.facts.TaxiRideFact;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaxiFareCalculatorService {

    @Autowired
    private KieContainer kieContainer;

    public Long calculateFare(TaxiRideFact taxiRide, FareFact rideFareFact) {
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.setGlobal("rideFare", rideFareFact);
        kieSession.insert(taxiRide);
        kieSession.fireAllRules();
        kieSession.dispose();
        return rideFareFact.getTotalFare();
    }
}

