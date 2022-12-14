package com.singhulariti.mdtohtml.parsers;

import com.singhulariti.mdtohtml.dto.MarkDownContent;

/* Enforces contract to parse Markdown content using one of the eligible parsers */
public interface MdParsingOrchestrator {
    MarkDownContent parse(String line);
}
