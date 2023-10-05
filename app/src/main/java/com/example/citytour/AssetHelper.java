package com.example.citytour;

import android.content.Context;
import android.content.res.AssetManager;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class AssetHelper {

        private final AssetManager assetManager;

        public AssetHelper(Context context) {
            this.assetManager = context.getAssets();
        }

        public String getJsonStringFromAsset(String fileName) {
            StringBuilder stringBuilder = new StringBuilder();
            try {
                InputStream is = assetManager.open(fileName);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));

                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line);
                }

                bufferedReader.close();
                return stringBuilder.toString();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

    public static Map<String, String> loadJSONFromFile(String filePath) {
        Map<String, String> textsMap = new HashMap<>();
        try {
            String content = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                content = new String(Files.readAllBytes(Paths.get(filePath)));
            }
            ObjectMapper mapper = new ObjectMapper();
            textsMap = mapper.readValue(content, HashMap.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return textsMap;
    }

    public static Optional<String> getTextByKey(String filePath, String jsonKey) {
        Map<String, String> textsMap = loadJSONFromFile(filePath);
        return Optional.ofNullable(textsMap.get(jsonKey));
    }
    }
