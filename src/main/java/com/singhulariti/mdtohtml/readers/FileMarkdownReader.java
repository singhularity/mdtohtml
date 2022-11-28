package com.singhulariti.mdtohtml.readers;

import com.singhulariti.mdtohtml.dto.MarkDownContent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Can read Markdown content from a file and returned parsed content*/
public class FileMarkdownReader extends MarkdownReader {
    private final String filePath;

    public FileMarkdownReader(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<MarkDownContent> readContent() {
        List<MarkDownContent> contents = new ArrayList<>();
        try {
            Scanner reader = new Scanner(new FileInputStream(filePath));
            while (reader.hasNextLine()) {
                contents.add(parseContent(reader.nextLine()));
            }
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("Invalid File Found!");
        }

        return contents;
    }
}
