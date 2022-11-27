package com.singhulariti.mdtohtml.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class LocalMdToHtmlTagMapper implements MdToHtmlTagMapper {
    private static LocalMdToHtmlTagMapper INSTANCE;
    private final List<String> validTags;

    private LocalMdToHtmlTagMapper() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        InputStream is = LocalMdToHtmlTagMapper.class.getResourceAsStream("/mdToHtmlMapping.json");
        validTags = mapper.readValue(is, new TypeReference<>() {
        });
    }

    public static LocalMdToHtmlTagMapper getInstance() throws IOException {
        if (INSTANCE == null) {
            INSTANCE = new LocalMdToHtmlTagMapper();
        }

        return INSTANCE;
    }

    @Override
    public boolean isValidTag(String mdTag) {
        return validTags.contains(mdTag);
    }

}
