package domain;

import utils.DateTimeUtils;

import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class Movie {
    private static final char NEW_LINE = '\n';

    private final int id;
    private final String name;
    private final int price;

    private List<PlaySchedule> playSchedules = new ArrayList<>();

    public Movie(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    void addPlaySchedule(PlaySchedule playSchedule) {
        playSchedules.add(playSchedule);
    }

    public boolean isId(int id) {
        return this.id == id;
    }

    public boolean withinRangeOneHour(Movie movie) {
        return false;
    }

    public PlaySchedule getPlaySchedule(int index) {
        return this.playSchedules.get(index);
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        int index = 1;
        StringBuilder sb = new StringBuilder();
        for (PlaySchedule playSchedule : playSchedules) {
            sb.append(String.format("[%d] %s", index++, playSchedule));
        }
        return id + " - " + name + ", " + price + "원" + NEW_LINE
                + sb.toString();
    }
}
