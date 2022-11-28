package com.singhulariti.mdtohtml.parsers;

import com.singhulariti.mdtohtml.dto.MarkDownContent;

/* Enforces a contract to implement handlers for parsed markdown content
 * Implementing subclasses will allow checking what Markdown tags they can handle
 * Implementing subclasses will return the parsed Markdown tags and content for tags handled by them
 * */
public interface MdTextParser {
    boolean doesHandleToken(String token);

    MarkDownContent parse(String line);
}
