import domain.Movie;
import domain.MovieRepository;
import domain.Payment;
import domain.PaymentInfo;
import view.InputView;
import view.OutputView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MovieApplication {
    public static void main(String[] args) throws IOException {
        List<Movie> movies = MovieRepository.getMovies();
        OutputView.printMovies(movies);

        List<PaymentInfo> paymentInfos = new ArrayList<>();

        boolean wantPay = false;
        while (!wantPay) {
            paymentInfos.add(selectMovie());

            wantPay = InputView.wantPay();
        }
        int payMoney = new Payment().pay(paymentInfos);
        OutputView.printPayResult(payMoney);
    }

    private static PaymentInfo selectMovie() throws IOException {
        int movieId = InputView.inputMovieId();

        Movie selectedMovie = MovieRepository.getMoviesById(movieId);
        OutputView.printMovie(selectedMovie);
        int movieTime = InputView.inputMovieTime() - 1;
        int countOfUser = InputView.inputCountOfUser();

        return new PaymentInfo(selectedMovie , movieTime , countOfUser);
    }
}
