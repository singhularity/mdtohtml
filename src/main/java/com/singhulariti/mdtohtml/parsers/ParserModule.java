package com.singhulariti.mdtohtml.parsers;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;

public class ParserModule extends AbstractModule {
    @Override
    protected void configure() {
        Multibinder<MarkdownParser> parsers = Multibinder.newSetBinder(binder(), MarkdownParser.class);
        parsers.addBinding().to(LinkTextParser.class);
        parsers.addBinding().to(HeadingTextParser.class);
        bind(MdParserFactory.class).to(MdParserFactoryDefaultImpl.class);
    }
}