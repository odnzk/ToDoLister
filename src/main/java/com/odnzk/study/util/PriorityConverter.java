package com.odnzk.study.util;

import com.odnzk.study.exception.ConvertingExceptionException;
import com.odnzk.study.model.Priority;
import org.springframework.core.convert.converter.Converter;

import java.util.Arrays;

public class PriorityConverter implements Converter<String, Priority> {
    @Override
    public Priority convert(String source) {
        if (source.length() == 0) {
            return null;
        }
        return Arrays.stream(Priority.values())
                .filter(priority -> priority.getKey().equals(source))
                .findAny()
                .orElseThrow(() -> new ConvertingExceptionException("Invalid priority"));
    }

}
