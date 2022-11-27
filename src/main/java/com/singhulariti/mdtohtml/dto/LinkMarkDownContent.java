package com.singhulariti.mdtohtml.dto;

public class LinkMarkDownContent extends MarkDownContent {
    private final String url;
    private final String linkText;

    public LinkMarkDownContent(String mdToken, String url, String linkText) {
        super(mdToken);
        this.url = url;
        this.linkText = linkText;
    }

    public String getLinkText() {
        return linkText;
    }

    public String getUrl() {
        return url;
    }
}
