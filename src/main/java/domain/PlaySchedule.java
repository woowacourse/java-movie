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
        return "���۽ð�: " + format(startDateTime) + " ���డ���ο�: " + capacity + "\n";
    }

    public String getRst() {
    	return  "���۽ð�: " + format(startDateTime);
    }
    
	public int getCapacity() {
		return capacity;
	}
	
	public LocalDateTime getStarDateTime() {
		 return startDateTime;
	}
	
	public void buyTickets(int ticketNum) {
		capacity = capacity - ticketNum;
	}
}
