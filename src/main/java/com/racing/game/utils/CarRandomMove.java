package com.racing.game.utils;

import java.util.Random;

public class CarRandomMove {
    private static final Random random = new Random();

    private CarRandomMove() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean isGoForward() {
        return random.nextInt(10) >= 4;
    }
}
