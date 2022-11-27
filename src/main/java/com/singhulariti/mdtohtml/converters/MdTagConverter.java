package com.singhulariti.mdtohtml.converters;

import com.singhulariti.mdtohtml.dto.MarkDownContent;

public abstract class MdTagConverter {
    public abstract String handleMdTag(MarkDownContent content);
    public abstract boolean canHandleMdTag(MarkDownContent content);

    protected String getHtmlTagWrappedContent(String htmlTag, String content) {
        return String.format("<%s>%s</%s>", htmlTag, content, htmlTag);
    }
}
