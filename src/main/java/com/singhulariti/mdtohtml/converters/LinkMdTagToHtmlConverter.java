package com.singhulariti.mdtohtml.converters;

import com.singhulariti.mdtohtml.dto.LinkMarkDownContent;
import com.singhulariti.mdtohtml.dto.MarkDownContent;

/* Converts a parsed Markdown Link to HTML equivalent */
public class LinkMdTagToHtmlConverter extends MdTagConverter {
    @Override
    public String handleMdTag(MarkDownContent markDownContent) {
        LinkMarkDownContent linkContents = (LinkMarkDownContent) markDownContent;
        String linkText = linkContents.getLinkText();
        String url = linkContents.getUrl();
        if (linkText == null || linkText.isEmpty()) {
            return String.format("<a href=\"%s\"/>", url);
        }
        return String.format("<a href=\"%s\">%s</a>", url, linkText);
    }

    @Override
    public boolean canHandleMdTag(MarkDownContent content) {
        return content instanceof LinkMarkDownContent;
    }
}
