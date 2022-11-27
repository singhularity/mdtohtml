package com.singhulariti.mdtohtml.parsers;

import com.google.inject.Inject;
import com.singhulariti.mdtohtml.dto.MarkDownContent;
import com.singhulariti.mdtohtml.dto.TextMarkdownContent;

import java.util.Set;

public class MdParserFactoryDefaultImpl implements MdParserFactory {
    private final Set<MarkdownParser> parsers;

    @Inject
    public MdParserFactoryDefaultImpl(Set<MarkdownParser> parsers) {
        this.parsers = parsers;
    }

    public MarkDownContent parse(String line) {
        if (line != null && !line.isEmpty()) {
            for (MarkdownParser parser : parsers) {
                if (parser.doesHandleToken(line)) {
                    return parser.parse(line);
                }
            }
        }

        return new TextMarkdownContent("", line);
    }
}
