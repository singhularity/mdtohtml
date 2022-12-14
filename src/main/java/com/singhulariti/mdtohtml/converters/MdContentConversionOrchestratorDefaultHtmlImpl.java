package com.singhulariti.mdtohtml.converters;

import com.singhulariti.mdtohtml.dto.MarkDownContent;

import javax.inject.Inject;
import java.util.Set;

/* Default implementation of a factory which returns converted version of
 *   parsed markdown content using registered handlers */
public class MdContentConversionOrchestratorDefaultHtmlImpl implements MdContentConversionOrchestrator {
    private Set<MdTagConverter> mdTagConverters;

    @Inject
    public MdContentConversionOrchestratorDefaultHtmlImpl(Set<MdTagConverter> mdTagConverters) {
        this.mdTagConverters = mdTagConverters;
    }

    public String handleMdTag(MarkDownContent markDownContent) {
        for (MdTagConverter handler : mdTagConverters) {
            if (handler.canHandleMdTag(markDownContent)) {
                return handler.handleMdTag(markDownContent);
            }
        }

        return "";
    }
}
