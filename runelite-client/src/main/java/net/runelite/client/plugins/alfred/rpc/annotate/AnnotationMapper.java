package net.runelite.client.plugins.alfred.rpc.annotate;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import lombok.Getter;
import net.runelite.client.plugins.alfred.api.rs.bank.RSBank;
import net.runelite.client.plugins.alfred.api.rs.bank.RSBankHelper;
import net.runelite.client.plugins.alfred.api.rs.camera.RSCameraHelper;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

public class AnnotationMapper {
    private final Class<?>[] classes = {RSBank.class, RSBankHelper.class, RSCameraHelper.class};
    private List<Class<?>> annotatedClasses;
    private Map<String, Class<?>> typeMap = new HashMap<>();
    @Getter
    private Map<String, Method> methodNameToMethodMap;

    private JsonObject jsonMap;

    public AnnotationMapper() {
        annotatedClasses = new ArrayList<>();
        methodNameToMethodMap = new HashMap<>();
        jsonMap = new JsonObject();

        typeMap.put("string", String.class);
        typeMap.put("int", Integer.class);
        typeMap.put("boolean", Boolean.class);
        typeMap.put("double", Double.class);
        typeMap.put("float", Float.class);
        typeMap.put("long", Long.class);
        typeMap.put("short", Short.class);
        typeMap.put("byte", Byte.class);
        typeMap.put("char", Character.class);
    }

//    public void map() {
//        annotatedClasses = gatherAnnotatedClasses();
//
//        for (Class<?> cls : annotatedClasses) {
////            List<Field> annotatedFields = gatherAnnotatedFields(cls);
//            List<Method> annotatedMethods = gatherAnnotatedMethods(cls);
//            for (Method method : annotatedMethods) {
//                methodNameToMethodMap.put(method.getName(), method);
//            }
//
//        }
//    }

    public void map() {
        annotatedClasses = gatherAnnotatedClasses();

        for (Class<?> cls : annotatedClasses) {
            List<Field> annotatedFields = gatherAnnotatedFields(cls);
            List<Method> annotatedMethods = gatherAnnotatedMethods(cls);
            JsonObject classJson = getAnnotationsAsJSON(cls, annotatedFields, annotatedMethods);

            classJson.entrySet().forEach(entry -> {
                jsonMap.add(entry.getKey(), entry.getValue());
            });
        }
    }

    public void writeMapToFile(String filePath) {
        JsonArray jsonAnnotatedClasses = new JsonArray();
        for (Class<?> cls : annotatedClasses) {
            List<Field> annotatedFields = gatherAnnotatedFields(cls);
            List<Method> annotatedMethods = gatherAnnotatedMethods(cls);
            jsonAnnotatedClasses.add(getAnnotationsAsJSON(cls, annotatedFields, annotatedMethods));
        }

        try {
            FileWriter myWriter = new FileWriter(filePath);
            myWriter.write(jsonAnnotatedClasses.toString());
            myWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printMap() {
        for (Class<?> cls : annotatedClasses) {
            List<Field> annotatedFields = gatherAnnotatedFields(cls);
            List<Method> annotatedMethods = gatherAnnotatedMethods(cls);
            printAnnotations(cls, annotatedFields, annotatedMethods);
        }
    }

    private List<Class<?>> gatherAnnotatedClasses() {
        List<Class<?>> annotatedClasses = new ArrayList<>();

        try {
            for (Class<?> cls : classes) {
                Annotation annotation = cls.getAnnotation(RPCClass.class);
                if (annotation != null) {
                    annotatedClasses.add(cls);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return annotatedClasses;
    }

    private List<Field> gatherAnnotatedFields(Class cls) {
        List<Field> annotatedFields = new ArrayList<>();

        try {
            for (Field field : cls.getDeclaredFields()) {
                Annotation annotation = field.getAnnotation(RPCField.class);
                if (annotation != null) {
                    annotatedFields.add(field);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return annotatedFields;
    }

    private List<Method> gatherAnnotatedMethods(Class cls) {
        List<Method> annotatedMethods = new ArrayList<>();

        try {
            for (Method method : cls.getDeclaredMethods()) {
                Annotation annotation = method.getAnnotation(RPCMethod.class);
                if (annotation != null) {
                    annotatedMethods.add(method);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return annotatedMethods;
    }


    static class FieldInfo {
        String name;
        String type;
    }

    private FieldInfo getFieldInformation(Field field) {
        FieldInfo fieldInfo = new FieldInfo();
        fieldInfo.name = field.getName();
        fieldInfo.type = field.getType().getName();
        return fieldInfo;
    }

    static class MethodParameterInfo {
        String name;
        String type;
    }

    static class MethodInfo {
        String name;
        String description;
        MethodParameterInfo[] parameters;
        String returnType;
        String nestedReturnType;
    }

    private MethodInfo getMethodInformation(Method method) {
        MethodInfo methodInfo = new MethodInfo();
        methodInfo.name = method.getName();
        methodInfo.description = method.getAnnotation(RPCMethod.class).description();

        methodInfo.parameters = Arrays.stream(method.getParameters()).map(parameter -> {
            MethodParameterInfo methodParameterInfo = new MethodParameterInfo();
            methodParameterInfo.name = parameter.getName();

            String parameterType = parameter.getType().getName();
            Class<?> parameterClass = typeMap.get(parameterType);
            methodParameterInfo.type = parameterClass.getSimpleName();

            if (parameter.isAnnotationPresent(RPCParameter.class)) {
                RPCParameter annotation = parameter.getAnnotation(RPCParameter.class);
                methodParameterInfo.name = annotation.name();
            }
            return methodParameterInfo;
        }).toArray(MethodParameterInfo[]::new);

        String fullReturnTypeName = method.getReturnType().getName();
        methodInfo.returnType = fullReturnTypeName.substring(fullReturnTypeName.lastIndexOf(".") + 1);

        Type nestedReturnType = method.getGenericReturnType();
        if (nestedReturnType instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) nestedReturnType;
            String fullNestedReturnTypeName = parameterizedType.getActualTypeArguments()[0].getTypeName();
            methodInfo.nestedReturnType = fullNestedReturnTypeName.substring(fullNestedReturnTypeName.lastIndexOf(".") + 1);
        }

        return methodInfo;
    }

    private void printAnnotations(Class cls, List<Field> annotatedFields, List<Method> annotatedMethods) {
        System.out.println("Class: " + cls.getSimpleName());

        System.out.println("\tFields:");
        for (Field field : annotatedFields) {
            FieldInfo fieldInfo = getFieldInformation(field);
            System.out.println("\t\tName: " + fieldInfo.name);
            System.out.println("\t\tType: " + fieldInfo.type);
        }

        System.out.println("\tMethods:");
        for (Method method : annotatedMethods) {
            MethodInfo methodInfo = getMethodInformation(method);
            System.out.println("\t\tName: " + methodInfo.name);
            System.out.println("\t\tDescription: " + methodInfo.description);
            System.out.println("\t\tReturn Type: " + methodInfo.returnType);
            System.out.println("\t\tNested Return Type: " + methodInfo.nestedReturnType);

            System.out.println("\t\tParameters:");
            for (MethodParameterInfo parameter : methodInfo.parameters) {
                System.out.println("\t\t\tName: " + parameter.name);
                System.out.println("\t\t\tType: " + parameter.type);
            }

            System.out.println();
        }

        System.out.println();
    }

    private JsonObject getAnnotationsAsJSON(Class cls, List<Field> annotatedFields, List<Method> annotatedMethods) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("class", cls.getSimpleName());

        JsonArray fields = new JsonArray();
        for (Field field : annotatedFields) {
            FieldInfo fieldInfo = getFieldInformation(field);
            JsonObject fieldObject = new JsonObject();
            fieldObject.addProperty("name", fieldInfo.name);
            fieldObject.addProperty("type", fieldInfo.type);
            fields.add(fieldObject);
        }
        jsonObject.add("fields", fields);

        JsonArray methods = new JsonArray();
        for (Method method : annotatedMethods) {
            MethodInfo methodInfo = getMethodInformation(method);
            JsonObject methodObject = new JsonObject();
            methodObject.addProperty("name", methodInfo.name);
            methodObject.addProperty("description", methodInfo.description);
            methodObject.addProperty("return_type", methodInfo.returnType);
            methodObject.addProperty("nested_return_type", methodInfo.nestedReturnType);

            JsonArray parameters = new JsonArray();
            for (MethodParameterInfo parameter : methodInfo.parameters) {
                JsonObject parameterObject = new JsonObject();
                parameterObject.addProperty("name", parameter.name);
                parameterObject.addProperty("type", parameter.type);
                parameters.add(parameterObject);
            }
            methodObject.add("parameters", parameters);

            methods.add(methodObject);
        }

        jsonObject.add("methods", methods);
        return jsonObject;
    }
}
