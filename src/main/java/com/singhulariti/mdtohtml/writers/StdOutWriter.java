package com.singhulariti.mdtohtml.writers;

import com.singhulariti.mdtohtml.dto.MarkDownContent;

import java.util.List;

/* Provides an implementation to write HTML content to stdout */
public class StdOutWriter extends MarkDownWriter {
    @Override
    public void writeContents(List<MarkDownContent> markDownContents) {
        markDownContents.forEach(c -> System.out.println(convert(c)));
    }
}
