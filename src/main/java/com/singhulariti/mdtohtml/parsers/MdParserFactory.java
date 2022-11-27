package com.singhulariti.mdtohtml.parsers;

import com.singhulariti.mdtohtml.dto.MarkDownContent;

public interface MdParserFactory {
    MarkDownContent parse(String line);
}
