package org.spring.cert.definitions.configuration.level.writer;

import org.spring.cert.definitions.configuration.level.ds.FinancialMonthSummary;
import org.spring.cert.definitions.configuration.level.ds.FinancialQuarterSummary;
import org.spring.cert.definitions.configuration.level.ds.FinancialYearSummary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

public class DatabaseStoreFinancialReportWriter implements FinancialReportWriter {
    @Override
    public void appendFreeText(String title) {
        System.out.println("Database Writer => appendFreeText");
    }

    @Override
    public void appendFinancialYearSummary(FinancialYearSummary financialYearSummary) {
        System.out.println("Database Writer => appendFinancialYearSummary");
    }

    @Override
    public void appendFinancialQuarterSummary(FinancialQuarterSummary financialQuarterSummary) {
        System.out.println("Database Writer => appendFinancialQuarterSummary");
    }

    @Override
    public void appendFinancialMonthSummary(FinancialMonthSummary financialMonthSummary) {
        System.out.println("Database Writer => appendFinancialMonthSummary");
    }
}
