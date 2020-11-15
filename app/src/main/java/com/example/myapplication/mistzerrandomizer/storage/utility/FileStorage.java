package com.example.myapplication.mistzerrandomizer.storage.utility;


import android.content.Context;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

abstract public class FileStorage<T> implements Storage<T> {
    private final static String PREFIX = "storage_";

    private Context context;
    private String filename;

    public FileStorage(Context context, String name, String extension) {
        this.context = context;
        this.filename = PREFIX + name + extension;
        read();
    }

    protected abstract void create();

    protected abstract void initialize(String value);

    protected abstract String getValue();

    protected void read() {
        try {
            FileInputStream in = context.openFileInput(filename);
            System.out.println(context.getFilesDir());
            if (in != null) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
                String temp;
                StringBuilder builder = new StringBuilder();
                while ((temp = bufferedReader.readLine()) != null) {
                    builder.append(temp);
                }
                in.close();
                initialize(builder.toString());
            }
        } catch (FileNotFoundException e) {
            create();
            write();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void write() {
        try {
            FileOutputStream out = context.openFileOutput(filename, Context.MODE_PRIVATE);
            OutputStreamWriter writer = new OutputStreamWriter(out);
            writer.write(getValue());
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
