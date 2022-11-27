package com.singhulariti.mdtohtml.converters;

import com.singhulariti.mdtohtml.dto.MarkDownContent;

public interface MdTagHandlerFactory {
    String handleMdTag(MarkDownContent markDownContent);
}
