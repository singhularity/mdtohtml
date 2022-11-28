package com.singhulariti.mdtohtml.writers;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.singhulariti.mdtohtml.converters.ConverterModule;
import com.singhulariti.mdtohtml.converters.MdContentConversionOrchestrator;
import com.singhulariti.mdtohtml.dto.MarkDownContent;

import java.util.List;

/* Enforces contract for "writing" out the converted markdown content */
public abstract class MarkDownWriter {
    private final MdContentConversionOrchestrator mdContentConversionOrchestrator;

    public MarkDownWriter() {
        Injector injector = Guice.createInjector(new ConverterModule(), new WriterModule());
        this.mdContentConversionOrchestrator = injector.getInstance(MdContentConversionOrchestrator.class);
    }

    abstract public void writeContents(List<MarkDownContent> markDownContents);

    protected String convert(MarkDownContent content) {
        return mdContentConversionOrchestrator.handleMdTag(content);
    }
}
