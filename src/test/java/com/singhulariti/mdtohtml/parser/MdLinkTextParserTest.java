package com.singhulariti.mdtohtml.parser;

import com.singhulariti.mdtohtml.dto.LinkMarkDownContent;
import com.singhulariti.mdtohtml.parsers.MdLinkTextParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MdLinkTextParserTest {
    @Test
    public void testParsingLinkText() {
        LinkMarkDownContent expected = new LinkMarkDownContent("", "https://www.example.com", "Link text");
        assertEquals(expected, new MdLinkTextParser().parse("[Link text](https://www.example.com)"));
    }
}
