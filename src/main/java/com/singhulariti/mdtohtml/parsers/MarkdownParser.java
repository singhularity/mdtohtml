package com.singhulariti.mdtohtml.parsers;

import com.singhulariti.mdtohtml.dto.MarkDownContent;

public interface MarkdownParser {
    boolean doesHandleToken(String token);

    MarkDownContent parse(String line);
}
