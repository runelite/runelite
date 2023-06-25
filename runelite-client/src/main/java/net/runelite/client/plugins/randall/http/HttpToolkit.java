package net.runelite.client.plugins.randall.http;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.sun.net.httpserver.HttpExchange;
import net.runelite.http.api.RuneLiteAPI;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class HttpToolkit {

    public static void writeResponse(HttpExchange exchange, int statusCode, JsonObject data) throws IOException {
        writeResponseInteral(exchange, statusCode, data);
    }

    public static void writeResponse(HttpExchange exchange, int statusCode, JsonArray data) throws IOException {
        writeResponseInteral(exchange, statusCode, data);
    }

    public static Map<String, String> getQueryParams(HttpExchange exchange) {
        return queryParamsToMap(exchange.getRequestURI().getQuery());
    }

    public static JsonObject getPostData(HttpExchange exchange) throws IOException {
        InputStream requestBody = exchange.getRequestBody();
        String requestBodyString = convertStreamToString(requestBody);

        Gson gson = new Gson();
        return gson.fromJson(requestBodyString, JsonObject.class);
    }

    private static void writeResponseInteral(HttpExchange exchange, int statusCode, Object data) throws IOException {
        exchange.sendResponseHeaders(statusCode, 0);
        try (OutputStreamWriter out = new OutputStreamWriter(exchange.getResponseBody())) {
            RuneLiteAPI.GSON.toJson(data, out);
        }
    }

    private static Map<String, String> queryParamsToMap(String query) {
        if (query == null) {
            return null;
        }
        Map<String, String> result = new HashMap<>();
        for (String param : query.split("&")) {
            String[] entry = param.split("=");
            if (entry.length > 1) {
                result.put(entry[0], entry[1]);
            } else {
                result.put(entry[0], "");
            }
        }
        return result;
    }

    private static String convertStreamToString(InputStream inputStream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line).append("\n");
        }
        reader.close();
        return stringBuilder.toString();
    }
}
