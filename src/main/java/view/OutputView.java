package view;

import domain.Movie;

import java.util.List;

public class OutputView {
	static final String DEMAND_USER_INPUT_AGAIN = "잘못된 입력입니다. 다시 입력해주세요.";
	static final String NO_MOIVE_TIME = "상영 시간표에 없는 번호입니다. 다시 입력해주세요.";
	static final String MOIVE_TIME_PASS = "시작 시간이 지난 영화입니다. 다시 입력해주세요.";

	public static void printMovies(List<Movie> movies) {
		for (Movie movie : movies) {
			System.out.println(movie);
		}
	}

	public static void printMovie(Movie movie) {
		System.out.println(movie);
	}

	public static void printUserInputAgain() {
		System.out.println(DEMAND_USER_INPUT_AGAIN);
	}

	public static void printUserInputAgainNoMovieTime(){
		System.out.println(NO_MOIVE_TIME);
	}

	public static void printUserInputAgainMovieTimePass(){
		System.out.println(MOIVE_TIME_PASS);
	}
}