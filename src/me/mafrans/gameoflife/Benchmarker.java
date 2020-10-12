package me.mafrans.gameoflife;

public class Benchmarker {
    private static long lastTime = System.currentTimeMillis();
    public static void next(String title) {
        System.out.println(String.format("%s: %dms", title, System.currentTimeMillis() - lastTime));
        lastTime = System.currentTimeMillis();
    }
    public static void next() {
        lastTime = System.currentTimeMillis();
    }
}
