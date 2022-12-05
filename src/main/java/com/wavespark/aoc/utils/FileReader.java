package com.wavespark.aoc.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    public InputStream getFileFromResourceAsStream(String fileName) {
        var filePath = "year2022/" + fileName;

        // The class loader that loaded the class
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(filePath);

        // the stream holding the file content
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + filePath);
        } else {
            return inputStream;
        }

    }

    public List<String> ReadFileContent(InputStream inputStream) {
        List<String> resultList = new ArrayList<String>();

        try (InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8); BufferedReader reader = new BufferedReader(streamReader)) {

            String line;
            while ((line = reader.readLine()) != null) {
                resultList.add(line);
            }

        } catch(IOException e){
            e.printStackTrace();
        }

        return resultList;
    }
}
