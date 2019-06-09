package net.runelite.client.util.bootstrap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Bootstrapper {

    public static void main(String[] args) {
        Gson gson = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
        try {
            FileWriter fw = new FileWriter("./bootstrap.json");
            gson.toJson(new Bootstrap(), fw);
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
