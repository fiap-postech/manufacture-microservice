package br.com.fiap.tech.challenge.manufacture.launcher.util;

import io.restassured.RestAssured;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.test.context.DynamicPropertyRegistry;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConfigurationOverrides {

    private static final int LOCAL_PORT = 8693;

    public static void overrideConfiguration(DynamicPropertyRegistry registry) {
        registry.add("server.port", () -> String.valueOf(LOCAL_PORT));

        RestAssured.port = LOCAL_PORT;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    public static void overrideConfiguration(DynamicPropertyRegistry registry, String mockServerEndpoint) {
        registry.add("purchase.host", () -> mockServerEndpoint);

        registry.add("server.port", () -> String.valueOf(LOCAL_PORT));

        RestAssured.port = LOCAL_PORT;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}