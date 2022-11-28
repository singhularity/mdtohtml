package com.singhulariti.mdtohtml.writers;

import com.google.inject.AbstractModule;
import com.singhulariti.mdtohtml.converters.MdContentConversionOrchestrator;
import com.singhulariti.mdtohtml.converters.MdContentConversionOrchestratorDefaultHtmlImpl;

/* Registers writers to output converted content */
public class WriterModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(MdContentConversionOrchestrator.class).to(MdContentConversionOrchestratorDefaultHtmlImpl.class);
    }
}
