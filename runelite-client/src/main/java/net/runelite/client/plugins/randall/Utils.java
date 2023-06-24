package net.runelite.client.plugins.randall;

public class Utils {

    private static final Utils instance = new Utils();

    private Utils() {
    }

    public static Utils getInstance() {
        return instance;
    }

    public static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (Exception Ex) {
            System.out.println(Ex);
        }
    }
}