import Program.BookSystem;
import Program.PaymentSystem;
import domain.BookMovie;
import domain.Movie;
import domain.MovieRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

/**
 * BookSystem - 한 세트
 * bookingMovie = 예약중인 영화(인원 수 포함)
 * bookingMovieList = 예약중인 영화 정보
 * order = 예약 횟수
 *
 */
public class MovieApplication {

    public static void main(String[] args) {
        int order = 0;
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);
        BookSystem bookSystem = new BookSystem(new BookMovie());
        BookMovie bookingMovie = bookSystem.booking(InputView.inputMovieId());
        OutputView.printMovies(bookingMovie.getBookMovieList());
        bookSystem.selectSchedule(order++,InputView.inputMovieSchedule());
        bookSystem.selectPeopleBooking(InputView.inputPeopleBooking());
        PaymentSystem paymentSystem = new PaymentSystem();
        paymentSystem.paymentStart(bookingMovie,InputView.inputPaymentType());
        OutputView.printTotalPrice(paymentSystem.getTotalPrice());
    }
}
