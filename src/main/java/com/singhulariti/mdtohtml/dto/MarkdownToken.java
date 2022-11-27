package com.singhulariti.mdtohtml.dto;

public enum MarkdownToken {
    HEADING1("#"),
    HEADING2("##"),
    HEADING3("###"),
    HEADING4("####"),
    HEADING5("#####"),
    HEADING6("#####"),
    NO_FORMAT(""),
    LINK_TEXT("[Link text]"),
    BLANK_LINE("Blank line");

    public final String stringValue;

    MarkdownToken(String stringValue) {
        this.stringValue = stringValue;
    }
}
