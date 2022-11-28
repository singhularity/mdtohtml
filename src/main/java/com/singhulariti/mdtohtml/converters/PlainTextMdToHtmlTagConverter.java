package com.singhulariti.mdtohtml.converters;

import com.singhulariti.mdtohtml.dto.MarkDownContent;
import com.singhulariti.mdtohtml.dto.TextMarkdownContent;

/* Converts a parsed Markdown header or plain text to HTML equivalent */
public class PlainTextMdToHtmlTagConverter extends MdTagConverter {
    @Override
    public String handleMdTag(MarkDownContent markDownContent) {
        TextMarkdownContent markdownContent = (TextMarkdownContent) markDownContent;
        String tag = markdownContent.getMdToken();
        String content = markdownContent.getContent();
        switch (tag) {
            case "#":
                return getHtmlTagWrappedContent("h1", content);
            case "##":
                return getHtmlTagWrappedContent("h2", content);
            case "###":
                return getHtmlTagWrappedContent("h3", content);
            case "####":
                return getHtmlTagWrappedContent("h4", content);
            case "#####":
                return getHtmlTagWrappedContent("h5", content);
            case "######":
                return getHtmlTagWrappedContent("h6", content);
            case "":
                if ("".equals(content.trim())) {
                    return content;
                } else {
                    return getHtmlTagWrappedContent("p", content);
                }
            default:
                return content;
        }
    }

    @Override
    public boolean canHandleMdTag(MarkDownContent content) {
        return content instanceof TextMarkdownContent;
    }
}
