package hr.algebra.java2.cartographers.utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.util.List;

public class DocumentationUtils {
    public static final String PATH_WITH_CLASSES = "target/classes/";
    public static final String HTML_DOCUMENTATION_FILE_PATH = "doc/documentation.html";
    public static final String CLASS_FILE_EXTENSION = ".class";

    public static void generateHtmlDocumentationFile() throws IOException {
        Path start = Paths.get(PATH_WITH_CLASSES);
        try (Stream<Path> stream = Files.walk(start, Integer.MAX_VALUE)) {
            List<String> classList = stream
                    .filter(path -> path.getFileName().toString().endsWith(CLASS_FILE_EXTENSION) &&
                            Character.isUpperCase(path.getFileName().toString().charAt(0)))
                    .map(String::valueOf)
                    .sorted()
                    .toList();

            String htmlString = generateHtmlDocumentationCode(classList);

            File docFile = new File(HTML_DOCUMENTATION_FILE_PATH);
            if (!docFile.getParentFile().exists()) {
                docFile.getParentFile().mkdirs();
            }
            if (!docFile.exists()) {
                docFile.createNewFile();
            }

            Files.writeString(Path.of(HTML_DOCUMENTATION_FILE_PATH), htmlString);
        }
    }

    private static String generateHtmlDocumentationCode(List<String> classList) {
        StringBuilder sb = new StringBuilder();
        String htmlStart = """
                <!DOCTYPE html>
                <html>
                <head>
                <title>Java documentation</title>
                </head>
                <body>
                
                <h1>List of classes:</h1>""";

        sb.append(htmlStart);

        for(String className : classList) {
            className = className.substring(PATH_WITH_CLASSES.length(), className.length() - CLASS_FILE_EXTENSION.length())
                    .replace("\\", ".");
            try {
                Class<?> clazz = Class.forName(className);
                sb.append("<h1>Class: ").append(clazz.getSimpleName()).append("</h1><br />");
                if (clazz.getConstructors().length > 0) {
                    sb.append("<h2>Constructors:</h2><br />");
                    for (Constructor constructor : clazz.getConstructors()) {
                        sb.append("<p>").append(constructor).append("</p><br />");
                    }
                }
                else {
                    sb.append("<h2>No constructors</h2><br />");
                }
                if (clazz.getDeclaredMethods().length > 0) {
                    for (Method method : clazz.getDeclaredMethods()) {
                        sb.append("<h3>Method: ").append(method.getName()).append("</h3><br />");
                        sb.append("<p>").append(method).append("</p><br />");
                    }
                }
                else {
                    sb.append("<h2>No methods</h2><br />");
                }
                if (clazz.getDeclaredFields().length > 0) {
                    for (Field field : clazz.getDeclaredFields()) {
                        sb.append("<h3>Field:</h3><br />");
                        sb.append("<p>").append(field).append("</p><br />");
                    }
                }
                else {
                    sb.append("<h2>No fields</h2><br />");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        String htmlEnd = """
                
                </body>
                </html>""";

        sb.append(htmlEnd);
        return sb.toString();
    }
}
