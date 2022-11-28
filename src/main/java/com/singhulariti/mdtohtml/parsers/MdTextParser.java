package com.singhulariti.mdtohtml.parsers;

import com.singhulariti.mdtohtml.dto.MarkDownContent;

public interface MdTextParser {
    boolean doesHandleToken(String token);

    MarkDownContent parse(String line);
}
