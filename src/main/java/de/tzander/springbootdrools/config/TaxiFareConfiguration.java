package de.tzander.springbootdrools.config;

import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.KieServices;
import org.kie.api.builder.KieModule;
import org.kie.api.runtime.KieContainer;
import org.kie.internal.io.ResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaxiFareConfiguration {

    private static final String excelFile = "de/tzander/springbootdrools/rules/TAXI_FARE_RULE.xlsx";
    private static final String drlFile = "de/tzander/springbootdrools/rules/TAXI_FARE_RULE.drl";


    @Bean
    public KieContainer kieContainer() {
        KieServices service = KieServices.Factory.get();

        KieFileSystem kieFileSystem = service.newKieFileSystem();
        kieFileSystem.write(ResourceFactory.newClassPathResource(excelFile));
        KieBuilder kieBuilder = service.newKieBuilder(kieFileSystem);
        kieBuilder.buildAll();
        KieModule kieModule = kieBuilder.getKieModule();

        return service.newKieContainer(kieModule.getReleaseId());
    }
}
