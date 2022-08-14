package com.mayuran19.datasourceconfig.datasource;

public class ThreadLocalStorage {
    private static ThreadLocal<String> currentLoggedInUser = new ThreadLocal<>();

    public static void setCurrentLoggedInUser(String currentLoggedInUser) {
        ThreadLocalStorage.currentLoggedInUser.set(currentLoggedInUser);
    }

    public static String getCurrentLoggedInUser() {
        return currentLoggedInUser.get();
    }
}
