package br.com.fiap.tech.challenge.adapter.driven.dynamodb.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.Instant;

@NoArgsConstructor(access =  AccessLevel.PRIVATE)
public class TtlUtils {

    public static final String TTL_KEY = "aws.dynamodb.time-to-live";

    public static Long inSeconds(Long ttl) {
        return Instant.now().plusSeconds(ttl).getEpochSecond();
    }
}