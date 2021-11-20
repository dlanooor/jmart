package com.ronaldJmartBO.dbjson;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Vector;

public class JsonTable<T> extends Vector<T>
{
    private static final Gson gson = new Gson();
    public final String filepath;

    @SuppressWarnings("unchecked")
    public JsonTable(Class<T> clazz, String filepath) throws IOException
    {
        this.filepath = filepath;
        try
        {
            Class<T[]> arrayType = (Class<T[]>) Array.newInstance(clazz, 0).getClass();
            T[] loaded = readJson(arrayType, filepath);
            if (loaded != null)
                Collections.addAll(this, loaded);
        }
        catch (FileNotFoundException e) {}
    }

    public void writeJson() throws IOException
    {
        writeJson(this, this.filepath);
    }

    public static void writeJson(Object object, String filepath) throws IOException
    {
        File file = new File(filepath);
        if (!file.exists())
        {
            File parent = file.getParentFile();
            if (parent != null)
                parent.mkdirs();
            file.createNewFile();
        }
        final FileWriter writer = new FileWriter(filepath);
        writer.write(gson.toJson(object));
        writer.close();
    }

    public static <T> T readJson(Class<T> clazz, String filepath) throws FileNotFoundException
    {
        final JsonReader reader = new JsonReader(new FileReader(filepath));
        return gson.fromJson(reader, clazz);
    }
}

//import com.google.gson.Gson;
//import com.google.gson.stream.JsonReader;
//
//import java.io.*;
//import java.util.*;
//import java.lang.reflect.*;
//
//public class JsonTable<T> extends Vector {
//    public final String filepath;
//    private static final Gson gson = new Gson();
//
//    public JsonTable(Class<T> clazz, String filepath) throws IOException {
//        this.filepath = filepath;
//        try {
//            Class<T[]> arrayType = (Class<T[]>) Array.newInstance(clazz, 0).getClass();
//            T[] loaded = readJson(arrayType, filepath);
//
//            if (loaded != null) {
//                Collections.addAll(this, loaded);
//            }
//        }
//        catch (FileNotFoundException e)
//        {
//            File file = new File(filepath);
//            File fileParent =  file.getParentFile();
//            if(fileParent != null)
//                fileParent.mkdirs();
//            file.createNewFile();
//        }
//    }
//
//    public static <T>T readJson(Class<T> clazz, String filepath) throws FileNotFoundException {
//        JsonReader jsonReader = new JsonReader(new FileReader(filepath));
//        T obj = gson.fromJson(jsonReader, clazz);
//        return obj;
//    }
//
//    public void writeJson() throws IOException {
//        writeJson(this, this.filepath);
//    }
//
//    public static void writeJson(Object object, String filepath) throws IOException {
//        FileWriter fwrite = new FileWriter(filepath);
//        String s = gson.toJson(object);
//        fwrite.write(s);
//        fwrite.close();
//    }
//}