package com.singhulariti.mdtohtml.writer;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.singhulariti.mdtohtml.converters.ConverterModule;
import com.singhulariti.mdtohtml.converters.MdTagHandlerFactory;
import com.singhulariti.mdtohtml.dto.LinkMarkDownContent;
import com.singhulariti.mdtohtml.dto.TextMarkdownContent;
import com.singhulariti.mdtohtml.writers.WriterModule;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MdTagConverterFactoryDefaultImplTest {
    private final MdTagHandlerFactory mdTagHandlerFactory;

    public MdTagConverterFactoryDefaultImplTest() {
        Injector injector = Guice.createInjector(new WriterModule(), new ConverterModule());
        this.mdTagHandlerFactory = injector.getInstance(MdTagHandlerFactory.class);
    }

    @Test
    public void testWritingHeading1() {
        String expected = "<h1>Test Text</h1>";
        assertEquals(expected, mdTagHandlerFactory.handleMdTag(new TextMarkdownContent("#", "Test Text")));
    }

    @Test
    public void testWritingHeading2() {
        String expected = "<h2>Test Text</h2>";
        assertEquals(expected, mdTagHandlerFactory.handleMdTag(new TextMarkdownContent("##", "Test Text")));
    }

    @Test
    public void testWritingHeading3() {
        String expected = "<h3>Test Text</h3>";
        assertEquals(expected, mdTagHandlerFactory.handleMdTag(new TextMarkdownContent("###", "Test Text")));
    }

    @Test
    public void testWritingHeading4() {
        String expected = "<h4>Test Text</h4>";
        assertEquals(expected, mdTagHandlerFactory.handleMdTag(new TextMarkdownContent("####", "Test Text")));
    }

    @Test
    public void testWritingHeading5() {
        String expected = "<h5>Test Text</h5>";
        assertEquals(expected, mdTagHandlerFactory.handleMdTag(new TextMarkdownContent("#####", "Test Text")));
    }

    @Test
    public void testWritingHeading6() {
        String expected = "<h6>Test Text</h6>";
        assertEquals(expected, mdTagHandlerFactory.handleMdTag(new TextMarkdownContent("######", "Test Text")));
    }

    @Test
    public void testWritingUnformattedText() {
        String expected = "<p>Test Text</p>";
        assertEquals(expected, mdTagHandlerFactory.handleMdTag(new TextMarkdownContent("", "Test Text")));
    }

    @Test
    public void testWritingBlankLine() {
        String expected = "";
        assertEquals(expected, mdTagHandlerFactory.handleMdTag(new TextMarkdownContent("", "")));
    }

    @Test
    public void testWritingLink() {
        String expected = "<a href=\"https://www.example.com\">Link text</a>";
        assertEquals(expected, mdTagHandlerFactory.handleMdTag(new LinkMarkDownContent("", "https://www.example.com", "Link text")));
    }
}
