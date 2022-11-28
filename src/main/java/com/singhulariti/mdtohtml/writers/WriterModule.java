package com.singhulariti.mdtohtml.writers;

import com.google.inject.AbstractModule;
import com.singhulariti.mdtohtml.converters.MdTagHandlerFactory;
import com.singhulariti.mdtohtml.converters.MdTagHandlerFactoryDefaultHtmlImpl;

/* Registers writers to output converted content */
public class WriterModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(MdTagHandlerFactory.class).to(MdTagHandlerFactoryDefaultHtmlImpl.class);
    }
}
