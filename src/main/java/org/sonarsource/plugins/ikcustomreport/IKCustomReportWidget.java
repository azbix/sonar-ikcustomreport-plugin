package org.sonarsource.plugins.ikcustomreport;

import org.sonar.api.web.AbstractRubyTemplate;
import org.sonar.api.web.Description;
import org.sonar.api.web.RubyRailsWidget;
import org.sonar.api.web.UserRole;
import org.sonar.api.web.WidgetCategory;
import org.sonar.api.web.WidgetProperties;
import org.sonar.api.web.WidgetProperty;
import org.sonar.api.web.WidgetPropertyType;

@UserRole(UserRole.USER)
@Description("Displays count of failures in custom report file")
@WidgetCategory("Issues")
@WidgetProperties()
public class IKCustomReportWidget extends AbstractRubyTemplate implements RubyRailsWidget {

  @Override
  public String getId() {
    return "ikcustomreport";
  }

  @Override
  public String getTitle() {
    return "IK Custom Report";
  }

  @Override
  protected String getTemplatePath() {
    return "/ikcustomreport/ikcustomreport_widget.html.erb";
  }
}
