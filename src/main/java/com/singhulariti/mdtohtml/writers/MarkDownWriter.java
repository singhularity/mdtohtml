package com.singhulariti.mdtohtml.writers;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.singhulariti.mdtohtml.converters.ConverterModule;
import com.singhulariti.mdtohtml.converters.MdTagHandlerFactory;
import com.singhulariti.mdtohtml.dto.MarkDownContent;

import java.util.List;

public abstract class MarkDownWriter {
    private final MdTagHandlerFactory mdTagHandlerFactory;

    public MarkDownWriter() {
        Injector injector = Guice.createInjector(new ConverterModule(), new WriterModule());
        this.mdTagHandlerFactory = injector.getInstance(MdTagHandlerFactory.class);
    }

    abstract public void writeContents(List<MarkDownContent> markDownContents);

    public MdTagHandlerFactory getMdTagHandlerFactory() {
        return mdTagHandlerFactory;
    }
}
