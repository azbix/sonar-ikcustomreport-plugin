package org.sonarsource.plugins.ikcustomreport;

import static org.sonarsource.plugins.ikcustomreport.IKCustomReportMetrics.TEST_FAILURES;

import org.sonar.api.batch.sensor.Sensor;
import org.sonar.api.batch.sensor.SensorContext;
import org.sonar.api.batch.sensor.SensorDescriptor;
import org.sonar.api.utils.log.Loggers;
import org.sonar.api.config.Settings;

import java.util.Scanner;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IKCustomReportIssuesSensor implements Sensor {

  private static Settings settings;

  @Override
  public void describe(SensorDescriptor descriptor) {
    descriptor.name("Parse custom test results");
  }

  @Override
  public void execute(SensorContext context) { 

    Integer issuesCount = -1;

    try {
      String baseDir = context.settings().getString("sonar.projectBaseDir"); 
      String repFilename = context.settings().getString(IKCustomReportPluginProperties.IK_CUSTOM_REPORT_FILENAME);
      String repPattern = context.settings().getString(IKCustomReportPluginProperties.IK_CUSTOM_REPORT_PATTERN);

      String content = new Scanner(new File(baseDir + "\\" + repFilename)).useDelimiter("\\Z").next();
      Loggers.get(getClass()).info("IK Custom Report Parser: file loaded");

      Pattern pattern = Pattern.compile(repPattern);
      Matcher  matcher = pattern.matcher(content);

      issuesCount = 0;
      while (matcher.find()) {
        issuesCount++;
      }

      Loggers.get(getClass()).info("IK Custom Report Parser: found " + issuesCount + " issues");

    } catch(Exception ex) {
      Loggers.get(getClass()).info("IK Custom Report Parser: " + ex.toString());
      issuesCount = -1;
    }

    context.<Integer>newMeasure().forMetric(TEST_FAILURES).on(context.module()).withValue(issuesCount).save();
  }
}
