package com.example.designpatterns.creational;
class Logger {
    private static Logger instance;
    private Logger() {}
    public static synchronized Logger getInstance() {
        if (instance == null) instance = new Logger();
        return instance;
    }
    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}
public class SingletonDemo {
    public static void main(String[] args) {
        Logger l1 = Logger.getInstance();
        Logger l2 = Logger.getInstance();
        l1.log("First log message");
        l2.log("Second log message");
        System.out.println("Same instance? " + (l1 == l2));
    }
}