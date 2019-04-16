import domain.Movie;
import domain.MovieRepository;
import domain.Reservation;
import view.OutputView;
import java.util.List;

public class MovieApplication {
    public static void main(String[] args) {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);
        Reservation reservation = new Reservation();
        reservation.startReservation();
    }
}
