package com.singhulariti.mdtohtml.converters;

import com.singhulariti.mdtohtml.dto.MarkDownContent;

import javax.inject.Inject;
import java.util.Set;

public class MdTagHandlerFactoryDefaultHtmlImpl implements MdTagHandlerFactory {
    private Set<MdTagConverter> mdTagConverters;

    @Inject
    public MdTagHandlerFactoryDefaultHtmlImpl(Set<MdTagConverter> mdTagConverters) {
        this.mdTagConverters = mdTagConverters;
    }

    public String handleMdTag(MarkDownContent markDownContent) {
        for(MdTagConverter handler: mdTagConverters) {
            if(handler.canHandleMdTag(markDownContent)) {
                return handler.handleMdTag(markDownContent);
            }
        }

        return "";
    }
}
