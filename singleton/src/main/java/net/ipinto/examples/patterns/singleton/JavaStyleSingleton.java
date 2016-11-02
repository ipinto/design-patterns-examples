package net.ipinto.examples.patterns.singleton;


public class JavaStyleSingleton {

    private static volatile JavaStyleSingleton instance;

    private JavaStyleSingleton() { }

    public static JavaStyleSingleton getInstance() {
        if (instance == null) {
            synchronized (JavaStyleSingleton.class) {
                instance = new JavaStyleSingleton();
            }
        }
        return instance;
    }

    String capitalize(String text) {
        return text == null ? null : text.substring(0, 1).toUpperCase() + text.substring(1);
    }

}
