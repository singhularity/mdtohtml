package com.singhulariti.mdtohtml.writers;

import com.singhulariti.mdtohtml.dto.MarkDownContent;

import java.util.List;

public class StdOutHtmlMarkDownWriter extends MarkDownWriter {
    @Override
    public void writeContents(List<MarkDownContent> markDownContents) {
        for (MarkDownContent content : markDownContents) {
            System.out.println(getMdTagHandlerFactory().handleMdTag(content));
        }
    }
}
