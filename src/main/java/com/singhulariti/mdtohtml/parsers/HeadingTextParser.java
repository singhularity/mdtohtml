package com.singhulariti.mdtohtml.parsers;

import com.singhulariti.mdtohtml.dto.MarkDownContent;
import com.singhulariti.mdtohtml.dto.TextMarkdownContent;

public class HeadingTextParser implements MarkdownParser {
    @Override
    public boolean doesHandleToken(String token) {
        return token.startsWith("#");
    }

    @Override
    public MarkDownContent parse(String line) {
        StringBuilder tag = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '#') {
                tag.append("#");
            } else {
                break;
            }
        }
        String content = line.replace(tag, "").trim();
        return new TextMarkdownContent(tag.toString(), content);
    }
}
