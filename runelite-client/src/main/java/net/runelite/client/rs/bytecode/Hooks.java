package net.runelite.client.rs.bytecode;

import java.lang.reflect.Method;
import java.util.List;

public class Hooks {

    public String clientInstance = "";
    public String actorClass = "";
    public String projectileClass = "";
    public String playerClass = "";
    public String clientClass = "client"; //Always named client
    public String[] protectedMethods;

    public Hooks() {
    }
}
