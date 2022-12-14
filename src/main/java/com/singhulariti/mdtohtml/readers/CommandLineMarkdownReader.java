package com.singhulariti.mdtohtml.readers;

import com.singhulariti.mdtohtml.dto.MarkDownContent;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Can read Markdown content from stdin and returned parsed content*/
public class CommandLineMarkdownReader extends MarkdownReader {
    @Override
    public List<MarkDownContent> readContent() {
        Scanner scanner = new Scanner(System.in);
        List<MarkDownContent> contents = new ArrayList<>();
        String text;
        while (true) {
            text = scanner.nextLine();
            if ("STOP".equals(text)) {
                break;
            }
            contents.add(parseContent((text)));
        }

        return contents;
    }
}
