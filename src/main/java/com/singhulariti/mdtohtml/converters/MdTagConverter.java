package com.singhulariti.mdtohtml.converters;

import com.singhulariti.mdtohtml.dto.MarkDownContent;

/* Enforces the contract for implementing parsed Markdown content converters
 * Implementing subclasses will answer questions on eligible Markdown tags they can handle
 * Implementing subclasses will return the "converted" Markdown content for eligible tags handled by them
 * */
public abstract class MdTagConverter {
    public abstract String handleMdTag(MarkDownContent content);

    public abstract boolean canHandleMdTag(MarkDownContent content);

    protected String getHtmlTagWrappedContent(String htmlTag, String content) {
        return String.format("<%s>%s</%s>", htmlTag, content, htmlTag);
    }
}
