package com.singhulariti.mdtohtml.readers;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.singhulariti.mdtohtml.dto.MarkDownContent;
import com.singhulariti.mdtohtml.parsers.MdParserFactory;
import com.singhulariti.mdtohtml.parsers.ParserModule;

import java.util.List;

/* Enforces contract for Markdown text readers
 * Implementing subclasses should return a list of parsed Markdown content that can identify tags and any content data
 * */
public abstract class MarkdownReader {
    private final MdParserFactory mdParserFactory;

    public MarkdownReader() {
        Injector injector = Guice.createInjector(new ParserModule());
        this.mdParserFactory = injector.getInstance(MdParserFactory.class);
    }

    public abstract List<MarkDownContent> readContent();

    protected MdParserFactory getMdParserFactory() {
        return mdParserFactory;
    }
}
