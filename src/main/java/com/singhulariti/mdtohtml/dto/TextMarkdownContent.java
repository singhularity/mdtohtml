package com.singhulariti.mdtohtml.dto;

import java.util.Objects;

public class TextMarkdownContent extends MarkDownContent {
    private final String content;

    public TextMarkdownContent(String mdToken, String content) {
        super(mdToken);
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TextMarkdownContent that = (TextMarkdownContent) o;
        return Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), content);
    }
}
