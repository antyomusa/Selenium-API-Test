package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/feature",          // Lokasi file .feature
        glue = "stepDef",                                  // Package berisi step definitions
        tags = "@ParabankPositive",                                   // Tag scenario yang ingin dijalankan
        plugin = {
                "pretty",                                      // Format log hasil eksekusi
                "html:target/RegressionReport.html"            // Output report dalam format HTML
        }
)
public class RunTest {
}
