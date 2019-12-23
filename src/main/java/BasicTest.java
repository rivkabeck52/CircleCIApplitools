import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.StdoutLogHandler;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.selenium.fluent.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BasicTest {
    public static void main(String[] args){

        Eyes eyes = new Eyes();

        BatchInfo batchInfo = new BatchInfo("Circle CI Batch");
        eyes.setBatch(batchInfo);

        RemoteWebDriver driver = new ChromeDriver();

        eyes.setApiKey(System.getenv("APPLITOOLS_API_KEY"));

        eyes.open(driver, "Circle CI", "Circle CI Test", new RectangleSize(800, 600));

        driver.get("https://demo.applitools.com/");

        eyes.check("Window Check", Target.window());

        driver.quit();

        eyes.close();

        eyes.abortIfNotClosed();

    }
}
