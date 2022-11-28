package com.singhulariti.mdtohtml.readers;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.singhulariti.mdtohtml.dto.MarkDownContent;
import com.singhulariti.mdtohtml.parsers.MdParsingOrchestrator;
import com.singhulariti.mdtohtml.parsers.ParserModule;

import java.util.List;

/* Enforces contract for Markdown text readers
 * Implementing subclasses should return a list of parsed Markdown content that can identify tags and any content data
 * */
public abstract class MarkdownReader {
    private final MdParsingOrchestrator mdParsingOrchestrator;

    public MarkdownReader() {
        Injector injector = Guice.createInjector(new ParserModule());
        this.mdParsingOrchestrator = injector.getInstance(MdParsingOrchestrator.class);
    }

    public abstract List<MarkDownContent> readContent();

    protected MarkDownContent parseContent(String content) {
        return mdParsingOrchestrator.parse(content);
    }
}
