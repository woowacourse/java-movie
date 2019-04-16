package domain;

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

    public int getPrice() {
        return price;
    }

    public boolean isMovieId(int id) {
        return (this.id == id);
    }

    public int isValidTime(int timeCode) {
        if (this.playSchedules.size() < timeCode) {
            throw new IllegalArgumentException("유효하지 않은 시간을 선택하셨습니다.");
        }
        return timeCode;
    }

    public int isValidCapacity(int id, int reserveCount) {
        if (!this.playSchedules.get(id).isCapacityPossible(reserveCount)) {
            throw new IllegalArgumentException("예약 가능 인원 수를 초과하였습니다.");
        }
        return reserveCount;
    }

    void addPlaySchedule(PlaySchedule playSchedule) {
        playSchedules.add(playSchedule);
    }

    private PlaySchedule getPlayScheduleByTime(int time) {
        return playSchedules.get(time - 1);
    }

    public String toStringFromIdAndTime(int movieTime, int reserveCount) {
        return id + " - " + name + ", " + price + "원" + NEW_LINE
                + getPlayScheduleByTime(movieTime).toStringExceptCapacity()
                + "예약 인원: " + reserveCount + "명" + NEW_LINE;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (PlaySchedule playSchedule : playSchedules) {
            sb.append(playSchedule);
        }
        return id + " - " + name + ", " + price + "원" + NEW_LINE
                + sb.toString();
    }
}
