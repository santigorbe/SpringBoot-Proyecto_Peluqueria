package org.example.peluqueria.handler;

import java.util.Map;

public record ErrorResponse(
    Map<String, String> errors
) {

}
