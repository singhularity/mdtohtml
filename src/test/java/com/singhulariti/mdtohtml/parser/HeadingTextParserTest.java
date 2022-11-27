package com.singhulariti.mdtohtml.parser;

import com.singhulariti.mdtohtml.dto.TextMarkdownContent;
import com.singhulariti.mdtohtml.parsers.HeadingTextParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeadingTextParserTest {
    @Test
    public void testParsingHeading1() {
        TextMarkdownContent expected = new TextMarkdownContent("#", "Test");
        assertEquals(expected, new HeadingTextParser().parse("# Test"));
    }

    @Test
    public void testParsingHeading1NoSpaces() {
        TextMarkdownContent expected = new TextMarkdownContent("#", "Test");
        assertEquals(expected, new HeadingTextParser().parse("# Test"));
    }

    @Test
    public void testParsingHeading2() {
        TextMarkdownContent expected = new TextMarkdownContent("##", "Test");
        assertEquals(expected, new HeadingTextParser().parse("## Test"));
    }

    @Test
    public void testParsingHeading3() {
        TextMarkdownContent expected = new TextMarkdownContent("###", "Test");
        assertEquals(expected, new HeadingTextParser().parse("### Test"));
    }

    @Test
    public void testParsingHeading4() {
        TextMarkdownContent expected = new TextMarkdownContent("####", "Test");
        assertEquals(expected, new HeadingTextParser().parse("#### Test"));
    }

    @Test
    public void testParsingHeading5() {
        TextMarkdownContent expected = new TextMarkdownContent("#####", "Test");
        assertEquals(expected, new HeadingTextParser().parse("##### Test"));
    }

    @Test
    public void testParsingHeading6() {
        TextMarkdownContent expected = new TextMarkdownContent("######", "Test");
        assertEquals(expected, new HeadingTextParser().parse("###### Test"));
    }

    @Test
    public void testParsingHeading6NoSpaces() {
        TextMarkdownContent expected = new TextMarkdownContent("######", "Test");
        assertEquals(expected, new HeadingTextParser().parse("######Test"));
    }
}
