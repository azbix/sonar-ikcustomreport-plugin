package org.sonarsource.plugins.ikcustomreport;

import static java.util.Arrays.asList;

import java.util.List;

import org.sonar.api.config.PropertyDefinition;
import org.sonar.api.PropertyType;
import org.sonar.api.resources.Qualifiers;

public class IKCustomReportPluginProperties {

  public static final String IK_CUSTOM_REPORT_FILENAME = "sonar.ikcustomreport.filename";
  public static final String IK_CUSTOM_REPORT_PATTERN = "sonar.ikcustomreport.pattern";

  private IKCustomReportPluginProperties() {
    // only statics
  }

  public static List<PropertyDefinition> definitions() {
    int i = 0;
    return asList(
      PropertyDefinition.builder(IK_CUSTOM_REPORT_FILENAME)
        .name("Report file")
        .description("Name of report file")
        .onlyOnQualifiers(Qualifiers.PROJECT)
        .index(++i)
        .build(),
      PropertyDefinition.builder(IK_CUSTOM_REPORT_PATTERN)
        .name("Failure count pattern")
        .description("Regular expression to detect failures")
        .onlyOnQualifiers(Qualifiers.PROJECT)
        .index(++i)
        .build()
      );
  }
}
