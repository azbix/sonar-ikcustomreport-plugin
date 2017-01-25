package org.sonarsource.plugins.ikcustomreport;

import org.sonar.api.Plugin;
import org.sonar.api.Properties;
import org.sonar.api.Property;
import org.sonar.api.PropertyType;

import org.sonarsource.plugins.ikcustomreport.IKCustomReportMetrics;
import org.sonarsource.plugins.ikcustomreport.IKCustomReportPluginProperties;
import org.sonarsource.plugins.ikcustomreport.IKCustomReportIssuesSensor;
import org.sonarsource.plugins.ikcustomreport.IKCustomReportWidget;

public class IKCustomReportPlugin implements Plugin {

  @Override
  public void define(Context context) {
    context
      .addExtensions(IKCustomReportPluginProperties.definitions())
      .addExtensions(IKCustomReportMetrics.class, IKCustomReportIssuesSensor.class, IKCustomReportWidget.class);
  }
}
