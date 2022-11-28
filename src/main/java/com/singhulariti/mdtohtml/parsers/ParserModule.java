package com.singhulariti.mdtohtml.parsers;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;

/* Registers the eligible Markdown content parsers */
public class ParserModule extends AbstractModule {
    @Override
    protected void configure() {
        Multibinder<MdTextParser> parsers = Multibinder.newSetBinder(binder(), MdTextParser.class);
        parsers.addBinding().to(MdLinkTextParser.class);
        parsers.addBinding().to(MdHeadingTextParser.class);
        bind(MdParsingOrchestrator.class).to(MdParsingOrchestratorDefaultImpl.class);
    }
}