package com.singhulariti.mdtohtml.converters;

import com.singhulariti.mdtohtml.dto.MarkDownContent;

/* Enforces the contract for implementing a factory which returns converted version of parsed markdown content
 * using eligible handlers */
public interface MdTagHandlerFactory {
    String handleMdTag(MarkDownContent markDownContent);
}
