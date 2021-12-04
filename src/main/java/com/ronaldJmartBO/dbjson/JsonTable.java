package com.ronaldJmartBO.dbjson;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Vector;

/**
 * Represents JsonTable
 *
 * @param <T> the type parameter
 * @author Ronald Grant
 * @version 1.0
 * @since 24 September 2021
 */
public class JsonTable<T> extends Vector<T>
{
    private static final Gson gson = new Gson();
    /**
     * The Filepath.
     */
    public final String filepath;

    /**
     * Instantiates a new Json table.
     *
     * @param clazz    the clazz
     * @param filepath the filepath
     * @throws IOException the io exception
     */
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

    /**
     * Write json.
     *
     * @throws IOException the io exception
     */
    public void writeJson() throws IOException
    {
        writeJson(this, this.filepath);
    }

    /**
     * Write json.
     *
     * @param object   the object
     * @param filepath the filepath
     * @throws IOException the io exception
     */
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

    /**
     * Read json t.
     *
     * @param <T>      the type parameter
     * @param clazz    the clazz
     * @param filepath the filepath
     * @return the t
     * @throws FileNotFoundException the file not found exception
     */
    public static <T> T readJson(Class<T> clazz, String filepath) throws FileNotFoundException
    {
        final JsonReader reader = new JsonReader(new FileReader(filepath));
        return gson.fromJson(reader, clazz);
    }
}