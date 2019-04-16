package domain;

import java.time.LocalDateTime;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (PlaySchedule playSchedule : playSchedules) {
            sb.append(playSchedule);
        }
        return id + " - " + name + ", " + price + "원" + NEW_LINE
                + sb.toString();
    }

    public String showMovieDetail(){
        return id + " - " + name + ", " + price + "원";
    }

    public boolean isValidPlaySchedule(int playScheduleId, int audience) {
        return playSchedules.get(playScheduleId - 1).isValidCapacity(audience);
    }

    public boolean isMatchedId(int id) {
        return this.id == id;
    }

    public PlaySchedule getPlaySchedule(int selectedPlayScheduleId){
        return playSchedules.get(selectedPlayScheduleId);
    }


    public int showPrice(int audience){
        return audience * price;
    }

    public String showSelectedPlaySchedule(int id){
        return playSchedules.get(id).toStringWithoutCapacity();
    }

    public boolean updateAudienceCount(int selectedPlayScheduleId, int audience){
        return playSchedules.get(selectedPlayScheduleId).updateCapacity(audience);
    }

}
