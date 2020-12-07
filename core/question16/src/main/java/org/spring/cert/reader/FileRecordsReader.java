package org.spring.cert.reader;

import org.spring.cert.ds.Record;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class FileRecordsReader implements RecordsReader, Ordered {
    @Override
    public Collection<Record> readRecords() {
        return null;
    }

    @Override
    public int getOrder() {
        return 3;
    }
}
