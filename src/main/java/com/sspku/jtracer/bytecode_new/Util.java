package com.sspku.jtracer.bytecode_new;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;
import java.io.ByteArrayOutputStream;

public class Util {

    public static Set<String> visitedMethod = new HashSet<>();

    public static Set<String> visitedNative = new HashSet<>();

    public static void println() {
        System.out.println("--------------------------------");
    }
//this is an addition to get native methods form single bytecode instead of the whole path
public static byte[] getClassBytesFromFile(String classFilePath) throws IOException {
    try (InputStream inputStream = new FileInputStream(classFilePath);
         ByteArrayOutputStream buffer = new ByteArrayOutputStream()) {

        byte[] data = new byte[1024];
        int nRead;
        while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }
        return buffer.toByteArray();
    }
}
}