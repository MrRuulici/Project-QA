package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.testng.Assert;
import util.CustomLogger;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

public class ExtentManager {

    private static final Logger LOG = CustomLogger.INSTANCE.getLogger(ExtentManager.class);
    private static final String REPORT_CONFIG_PATH = "src/main/resources/extentReportConfig.xml";
    private static ExtentReports extentReports;
    private static final LocalDate CURRENT_DATE = LocalDate.now();

    public static ExtentReports getInstance() {
        return extentReports;
    }

    @SneakyThrows
    public static synchronized ExtentReports createExtentReports() {
        LOG.info("Create extent report");
        if (extentReports == null) {
            ExtentSparkReporter reporter = new ExtentSparkReporter("./test-output/extent-report.html")
                    .viewConfigurer()
                    .viewOrder()
                    .as(new ViewName[]{
                            ViewName.TEST,
                            ViewName.DASHBOARD,
                            ViewName.CATEGORY,
                            ViewName.DEVICE
                    })
                    .apply();

            reporter.loadXMLConfig(getDefaultCustomConfigFile());
            extentReports = new ExtentReports();
            extentReports.attachReporter(reporter);
            extentReports.setSystemInfo("Author", System.getProperty("user.name"));
            extentReports.setSystemInfo("Date", CURRENT_DATE.toString());
            extentReports.setSystemInfo("Browser", System.getProperty("driver"));
        }
        return extentReports;
    }

    private static File getDefaultCustomConfigFile() throws IOException {
        var reportConfigAsStream = ExtentManager.class.getResourceAsStream("/extentReportConfig.xml");
        Assert.assertNotNull(reportConfigAsStream, "The extentReportConfig.xml file is null");
        File configFile;
        try {
            configFile = File.createTempFile("extentReportConfig", ".xml");
            Assert.assertNotNull(configFile);
            FileUtils.copyInputStreamToFile(reportConfigAsStream, configFile);
        } catch (IOException e) {
            throw new IOException("The report configFile is not found in path " + REPORT_CONFIG_PATH + "\n " + e.getLocalizedMessage());
        }
        return configFile;
    }
}
