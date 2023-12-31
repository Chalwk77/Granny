// Copyright (c) 2023, Jericho Crosby <jericho.crosby227@gmail.com>

package com.chalwk.util;

import org.json.JSONObject;

import java.io.*;

public class FileIO {

    static String programPath = getProgramPath();

    private static void checkExists(File file) throws IOException {
        boolean exists = file.exists();
        if (!exists) {
            boolean created = file.createNewFile();
            if (!created) {
                throw new IOException("Failed to create file: " + file);
            }
        }
    }

    public static String getProgramPath() {
        String currentDirectory = System.getProperty("user.dir");
        currentDirectory = currentDirectory.replace("\\", "/");
        return currentDirectory + "/";
    }

    public static String readFile(String fileName) throws IOException {

        File f = new File(programPath + fileName);
        checkExists(f);

        BufferedReader reader = new BufferedReader(new FileReader(f));
        String line = reader.readLine();
        StringBuilder stringBuilder = new StringBuilder();

        while (line != null) {
            stringBuilder.append(line);
            line = reader.readLine();
        }

        reader.close();
        return stringBuilder.toString();
    }

    public static JSONObject loadJSONFile(String fileName) throws IOException {
        String content = readFile(fileName);
        if (content.isEmpty()) {
            return new JSONObject();
        } else {
            return new JSONObject(content);
        }
    }

    public static <T> void write(String fileName, T json) throws IOException {

        /* When writing to file, make sure the output of json is indented.
        / Example:
        /
        /  JSONObject jo = new JSONObject();
        /  jo.put("name", "jon doe");
        /  jo.put("age", "22");
        /  jo.put("city", "chicago");
        /  write("settings.json", jo.toString(4));
        */

        FileWriter file = new FileWriter(programPath + fileName);
        file.write(json.toString()); // cannot indent here
        file.flush();
        file.close();
    }
}
