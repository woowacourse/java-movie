import domain.Movie;
import domain.MovieRepository;
import domain.MovieService;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        int movieId = InputView.inputMovieId(movies);
        Movie selectedMovie = MovieService.findMovieForId(movies, movieId);
        OutputView.printMovieInfo(selectedMovie);
        int selectedMoviePlayTime = InputView.inputMoviePlaySchedule(selectedMovie);
        int numOfReservation = InputView.inputReservationNumber(selectedMovie, selectedMoviePlayTime);
        MovieService.updateMoviePlayScheduleCapacity(selectedMovie, selectedMoviePlayTime, numOfReservation);
        int answer = InputView.inputPlayPaymentOrAdditionalOrder();
    }
}
