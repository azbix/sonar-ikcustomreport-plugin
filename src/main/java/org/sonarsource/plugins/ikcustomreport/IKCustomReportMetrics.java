package org.sonarsource.plugins.ikcustomreport;

import static java.util.Arrays.asList;

import java.util.List;

import org.sonar.api.measures.CoreMetrics;
import org.sonar.api.measures.Metric;
import org.sonar.api.measures.Metrics;

public class IKCustomReportMetrics implements Metrics {

  public static final Metric<Integer> TEST_FAILURES = new Metric.Builder("ik_custom_report_failures_count", "All Failures", Metric.ValueType.INT)
    .setDescription("Test failures counter")
    .setDirection(Metric.DIRECTION_BETTER)
    .setQualitative(true)
    .setDomain(CoreMetrics.DOMAIN_GENERAL)
    .create();

  @Override
  public List<Metric> getMetrics() {
    return asList(TEST_FAILURES);
  }
}
