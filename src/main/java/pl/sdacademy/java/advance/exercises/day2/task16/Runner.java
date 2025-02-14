package pl.sdacademy.java.advance.exercises.day2.task16;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public enum Runner {
    BEGINNER(201, Integer.MAX_VALUE),
    INTERMEDIATE(101, 200),
    ADVANCED(0, 100);

    private static final Runner[] VALUES = values(); // values() zwraca nam wszytskie elementy z enuma - BEGINNER, INTERMEDIATE, ADVANCED
    private final int minMinutes;
    private final int maxMinutes;

    Runner(int minMinutes, int maxMinutes) {
        this.minMinutes = minMinutes;
        this.maxMinutes = maxMinutes;
    }

    //List<Runner>
    public static Runner getFitnessLevel(int runningTimeInMinutes) {
        return Arrays.stream(VALUES)
                .filter(runner -> runningTimeInMinutes <= runner.maxMinutes && runningTimeInMinutes >= runner.minMinutes)
                .findFirst()
                .orElse(BEGINNER);
                //.orElseThrow(() -> new IllegalArgumentException("Podany czas jest spoza zakresu!"));
    }
}
