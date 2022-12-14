package com.singhulariti.mdtohtml.converters;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;

public class ConverterModule extends AbstractModule {
    @Override
    protected void configure() {
        Multibinder<MdTagConverter> tagHandlers = Multibinder.newSetBinder(binder(), MdTagConverter.class);
        tagHandlers.addBinding().to(LinkMdTagToHtmlConverter.class);
        tagHandlers.addBinding().to(PlainTextMdToHtmlTagConverter.class);
    }
}
