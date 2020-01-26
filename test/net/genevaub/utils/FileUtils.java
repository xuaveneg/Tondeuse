package net.genevaub.utils;

import java.util.Objects;

public class FileUtils {

    public static String getTestResourceFile(String resourceName) {
        return Objects.requireNonNull(FileUtils.class
                .getClassLoader()
                .getResource(resourceName))
                .getFile();
    }
}
