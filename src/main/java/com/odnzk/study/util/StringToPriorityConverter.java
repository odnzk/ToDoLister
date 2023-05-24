package com.odnzk.study.util;

import com.odnzk.study.exception.ConvertingExceptionException;
import com.odnzk.study.model.Priority;
import org.springframework.core.convert.converter.Converter;

import java.util.Arrays;
import java.util.Locale;

public class StringToPriorityConverter implements Converter<String, Priority> {
    @Override
    public Priority convert(String source) {
        if (source.length() == 0) {
            return null;
        }
        return Arrays.stream(Priority.values())
                .filter(priority -> priority.getKey().toLowerCase(Locale.ROOT).equals(source.toLowerCase(Locale.ROOT)))
                .findAny()
                .orElseThrow(() -> new ConvertingExceptionException("Invalid priority"));
    }

}
