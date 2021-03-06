package org.spring.cert.definitions.configuration.level;

import org.spring.cert.definitions.configuration.level.dao.DatabaseStoreFinancialDataDao;
import org.spring.cert.definitions.configuration.level.dao.FinancialDataDao;
import org.spring.cert.definitions.configuration.level.writer.DatabaseStoreFinancialReportWriter;
import org.spring.cert.definitions.configuration.level.writer.FinancialReportWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("database")
public class DatabaseApplicationConfiguration {
    @Bean
    public FinancialDataDao databaseStoreFinancialDataDao() {
        return new DatabaseStoreFinancialDataDao();
    }

    @Bean
    public FinancialReportWriter databaseStoreFinancialReportWriter() {
        return new DatabaseStoreFinancialReportWriter();
    }
}
