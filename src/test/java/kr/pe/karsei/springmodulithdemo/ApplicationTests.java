package kr.pe.karsei.springmodulithdemo;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.docs.Documenter;
import org.springframework.modulith.model.ApplicationModules;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ApplicationTests {

    ApplicationModules modules = ApplicationModules.of(SpringModulithDemoApplication.class);

    @Test
    void verifiesModularStructure() {
        ApplicationModules list = modules.verify();
        assertNotNull(list);
    }

    @Test
    void createModuleDocumentation() {
        new Documenter(modules).writeDocumentation();
    }
}
