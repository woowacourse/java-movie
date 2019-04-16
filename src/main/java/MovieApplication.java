import domain.Movie;
import domain.MovieRepository;
import domain.PlaySchedule;
import utils.DateTimeUtils;
import view.InputView;
import view.OutputView;

import java.time.LocalDateTime;
import java.util.List;

public class MovieApplication {
    public void showAllMovieInfo() {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);
    }

    public void reserveMovie() {
        Movie movieToReserve = selectMovieToReserve();
        PlaySchedule playSchedule = selectPlayScheduleToReserve(movieToReserve);
        int peopleToReserve = selectPeopleToReserve(playSchedule);
        
    }

    private Movie selectMovieToReserve() {
        int movieId = InputView.inputMovieId();
        Movie movieToReserve = MovieRepository.getMovieById(movieId);
        OutputView.printMovie(movieToReserve);
        return movieToReserve;
    }

    private PlaySchedule selectPlayScheduleToReserve(Movie movie) {
        return InputView.inputPlaySchedule(movie);
    }

    private int selectPeopleToReserve(PlaySchedule playSchedule) {
        return InputView.inputPeopleToReserve(playSchedule);
    }

    public static void main(String[] args) {
        MovieApplication movieApplication = new MovieApplication();
        movieApplication.showAllMovieInfo();
        movieApplication.reserveMovie();
    }
}
