package com.singhulariti.mdtohtml.dto;

import java.util.Objects;

public abstract class MarkDownContent {
    private final String mdToken;

    public MarkDownContent(String mdToken) {
        this.mdToken = mdToken;
    }

    public String getMdToken() {
        return mdToken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarkDownContent that = (MarkDownContent) o;
        return Objects.equals(mdToken, that.mdToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mdToken);
    }
}
