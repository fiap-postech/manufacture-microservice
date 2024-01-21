package br.com.fiap.tech.challenge.driven.consumer.util;

import br.com.fiap.tech.challenge.enterprise.error.ApplicationError;
import br.com.fiap.tech.challenge.exception.ApplicationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JsonUtil {

    public static <T> T fromJsonString(final String json, Class<T> type) {
        try {
            return getObjectMapper().readValue(json, type);
        } catch (JsonProcessingException e) {
            throw new ApplicationException(ApplicationError.UNKNOWN_ERROR, e.getMessage());
        }
    }

    private static ObjectMapper getObjectMapper() {
        return new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }
}