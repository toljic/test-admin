package rs.ems.data.flux;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("rs.ems.data.flux");

        noClasses()
            .that()
            .resideInAnyPackage("rs.ems.data.flux.service..")
            .or()
            .resideInAnyPackage("rs.ems.data.flux.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..rs.ems.data.flux.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
