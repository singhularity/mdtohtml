package com.singhulariti.mdtohtml.parsers;

import com.singhulariti.mdtohtml.dto.LinkMarkDownContent;
import com.singhulariti.mdtohtml.dto.MarkDownContent;

public class MdLinkTextParser implements MdTextParser {
    @Override
    public boolean doesHandleToken(String token) {
        return token.startsWith("[");
    }

    @Override
    public MarkDownContent parse(String line) {
        StringBuilder linkText = new StringBuilder();
        String url = "";
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '[') {
                i++;
                while (line.charAt(i) != ']') {
                    linkText.append(line.charAt(i++));
                }
            }
            if (line.charAt(i) == '(') {
                url = line.substring(i + 1, line.length() - 2);
            }
        }
        return new LinkMarkDownContent("", url, linkText.toString());
    }
}
