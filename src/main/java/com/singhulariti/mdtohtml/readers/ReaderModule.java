package com.singhulariti.mdtohtml.readers;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

/* Register all Markdown content readers here */
public class ReaderModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(MarkdownReader.class).annotatedWith(Names.named("stdInReader")).to(CommandLineMarkdownReader.class);
        bind(MarkdownReader.class).annotatedWith(Names.named("fileReader")).to(FileMarkdownReader.class);
    }
}
