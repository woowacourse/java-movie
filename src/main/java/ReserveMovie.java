import domain.Movie;
import domain.SelectedMovie;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ReserveMovie {
    private static List<SelectedMovie> selectedMovies = new ArrayList<>();
    private Movie selectMovie;
    private int selectSchedule;
    private int selectPeople;

    public ReserveMovie(Movie selectMovie, int selectSchedule, int selectPeople){
        this.selectMovie = selectMovie;
        this.selectSchedule = selectSchedule;
        this.selectPeople = selectPeople;
    }

    public static void addReserveMovie(Movie selectMovie, int selectSchedule, int selectPeople) {
        selectedMovies.add(new SelectedMovie(selectMovie.getId(), selectMovie.getName(), selectMovie.getPrice(),
                selectMovie.getPlaySchedules().get(selectSchedule - 1).getStartDateTime(), selectPeople));
    }

    public static int assertMovieId(List<Movie> movies, int movieId) {
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getId() == movieId) {
                return i;
            }
        }
        return -1;
    }

    public static boolean assertMovieSchedule(List<Movie> movies, int movieIndex, int movieSchedule) {
        if (movies.get(movieIndex).getPlaySchedules().get(movieSchedule - 1).getStartDateTime().isAfter(LocalDateTime.now())) {
            return true;
        }
        return false;
    }

    public static boolean assertMovieWatchPeople(List<Movie> movies, int movieIndex, int movieSchedule, int movieWatchPeople) {
        if(movies.get(movieIndex).getPlaySchedules().get(movieSchedule-1).getCapacity() >= movieWatchPeople) {
            return true;
        }
        return false;
    }


    public static List<SelectedMovie> getSelectedMovies() {
        return selectedMovies;
    }
} 
