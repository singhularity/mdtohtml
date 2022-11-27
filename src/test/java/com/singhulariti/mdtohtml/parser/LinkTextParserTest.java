package com.singhulariti.mdtohtml.parser;

import com.singhulariti.mdtohtml.dto.LinkMarkDownContent;
import com.singhulariti.mdtohtml.parsers.LinkTextParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkTextParserTest {
    @Test
    public void testParsingLinkText() {
        LinkMarkDownContent expected = new LinkMarkDownContent("", "https://www.example.com", "Link text");
        assertEquals(expected, new LinkTextParser().parse("[Link text](https://www.example.com)"));
    }
}
