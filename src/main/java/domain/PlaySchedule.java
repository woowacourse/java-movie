package domain;

import java.time.LocalDateTime;

import static utils.DateTimeUtils.format;

public class PlaySchedule {
    private final LocalDateTime startDateTime;
    private int capacity;

    public PlaySchedule(LocalDateTime startDateTime, int capacity) {
        this.startDateTime = startDateTime;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "시작시간: " + format(startDateTime) + " 예약가능인원: " + capacity + "\n";
    }

    // 공석이 있는지
    public boolean isNotEmpty(){
        return capacity > 0;
    }
    // 예매 가능한지
    public boolean isReservePossible(int count){
        return capacity >= count;
    }
    // 시간만 출력하기
    public void showOnlyTimeInfo(){
        System.out.println("시작시간: " + format(startDateTime));
    }

    public void decreasePersonCount(int count){
        capacity -= count;
    }
}
