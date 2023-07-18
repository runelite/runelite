package net.runelite.client.plugins.alfred.rpc.http;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import net.runelite.http.api.RuneLiteAPI;

import java.io.*;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;

public class RPCServer {
    public HttpServer server;
    private final Map<String, Method> methodNameToMethodMap;

    public RPCServer(Map<String, Method> methodNameToMethodMap) {
        this.methodNameToMethodMap = methodNameToMethodMap;
    }

    public void start() throws Exception {
        server = com.sun.net.httpserver.HttpServer.create(new InetSocketAddress(8888), 0);
        server.createContext("/rpc/", this::handle);
        server.setExecutor(Executors.newSingleThreadExecutor());
        server.start();
    }

    public void stop() throws Exception {
        server.stop(1);
    }

    public void handle(HttpExchange exchange) throws IOException {
        String requestMethod = exchange.getRequestMethod();
        String requestURI = String.valueOf(exchange.getRequestURI());

        if (requestMethod.equals("POST")) {
            handleRPC(exchange);

        } else if (requestMethod.equals("GET") && requestURI.equals("/rpc/list/")) {
            listRPCs(exchange);

        } else {
            exchange.sendResponseHeaders(405, 0);

        }
        exchange.close();
    }

    private void listRPCs(HttpExchange exchange) throws IOException {
        JsonArray response = new JsonArray();
        for (String methodName : methodNameToMethodMap.keySet()) {
            JsonObject row = new JsonObject();
            row.addProperty("class", methodNameToMethodMap.get(methodName).getDeclaringClass().getSimpleName());
            row.addProperty("method", methodName);
            response.add(row);
        }

        writeResponse(exchange, 200, response);
    }

    private void handleRPC(HttpExchange exchange) throws IOException {
        JsonObject response = new JsonObject();
        JsonObject postData = getPostData(exchange);

        String methodName = postData.get("method").getAsString();
        JsonArray parameters = postData.get("parameters").getAsJsonArray();

        if (methodNameToMethodMap.containsKey(methodName)) {
            Method method = methodNameToMethodMap.get(methodName);
            Class<?>[] parameterTypes = method.getParameterTypes();
            Object[] parameterObjects = new Object[parameterTypes.length];

            for (int i = 0; i < parameterTypes.length; i++) {
                Class<?> parameterType = parameterTypes[i];
                JsonElement parameter = parameters.get(i);

                // parameter type to class type map
                Map<String, Class<?>> typeMap = new HashMap<>();
                typeMap.put("string", String.class);
                typeMap.put("int", Integer.class);
                typeMap.put("boolean", Boolean.class);
                typeMap.put("double", Double.class);
                typeMap.put("float", Float.class);
                typeMap.put("long", Long.class);
                typeMap.put("short", Short.class);
                typeMap.put("byte", Byte.class);
                typeMap.put("char", Character.class);

                Class<?> parameterTypeClass = typeMap.get(parameterType.getName());

                if (parameterTypeClass.equals(String.class)) {
                    parameterObjects[i] = parameter.getAsString();
                } else if (parameterTypeClass.equals(Integer.class)) {
                    parameterObjects[i] = parameter.getAsInt();
                } else if (parameterTypeClass.equals(Boolean.class)) {
                    parameterObjects[i] = parameter.getAsBoolean();
                } else if (parameterTypeClass.equals(Double.class)) {
                    parameterObjects[i] = parameter.getAsDouble();
                } else if (parameterTypeClass.equals(Float.class)) {
                    parameterObjects[i] = parameter.getAsFloat();
                } else if (parameterTypeClass.equals(Long.class)) {
                    parameterObjects[i] = parameter.getAsLong();
                } else if (parameterTypeClass.equals(Short.class)) {
                    parameterObjects[i] = parameter.getAsShort();
                } else if (parameterTypeClass.equals(Byte.class)) {
                    parameterObjects[i] = parameter.getAsByte();
                } else if (parameterTypeClass.equals(Character.class)) {
                    parameterObjects[i] = parameter.getAsCharacter();
                } else if (parameterTypeClass.equals(JsonObject.class)) {
                    parameterObjects[i] = parameter.getAsJsonObject();
                } else if (parameterTypeClass.equals(JsonArray.class)) {
                    parameterObjects[i] = parameter.getAsJsonArray();
                } else {
                    parameterObjects[i] = parameter;
                }
            }

            try {
                Object declaringClassInstance = method.getDeclaringClass().newInstance();
                Object result = method.invoke(declaringClassInstance, parameterObjects);
                response.add("result", new Gson().toJsonTree(result));
                writeResponse(exchange, 200, response);

            } catch (Exception e) {
                e.printStackTrace();
                response.add("error", new Gson().toJsonTree(e.getMessage()));
                writeResponse(exchange, 500, response);
            }

        } else {
            response.addProperty("error", "Method not found");
            writeResponse(exchange, 404, response);
        }
    }

    private void writeResponse(HttpExchange exchange, int statusCode, JsonObject data) throws IOException {
        writeResponseInteral(exchange, statusCode, data);
    }

    private void writeResponse(HttpExchange exchange, int statusCode, JsonArray data) throws IOException {
        writeResponseInteral(exchange, statusCode, data);
    }

    private Map<String, String> getQueryParams(HttpExchange exchange) {
        return queryParamsToMap(exchange.getRequestURI().getQuery());
    }

    private JsonObject getPostData(HttpExchange exchange) throws IOException {
        InputStream requestBody = exchange.getRequestBody();
        String requestBodyString = convertStreamToString(requestBody);

        Gson gson = new Gson();
        return gson.fromJson(requestBodyString, JsonObject.class);
    }

    private void writeResponseInteral(HttpExchange exchange, int statusCode, Object data) throws IOException {
        exchange.sendResponseHeaders(statusCode, 0);
        try (OutputStreamWriter out = new OutputStreamWriter(exchange.getResponseBody())) {
            RuneLiteAPI.GSON.toJson(data, out);
        }
    }

    private Map<String, String> queryParamsToMap(String query) {
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

    private String convertStreamToString(InputStream inputStream) throws IOException {
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
