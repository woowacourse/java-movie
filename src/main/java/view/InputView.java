package view;

import domain.MovieRepository;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId() {
        System.out.println("## 예약할 영화를 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputMovieDataTime() {
        System.out.println("## 예약할 시간표를 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputMoviePerson() {
        System.out.println("## 예약할 인원를 선택하세요.");
        return scanner.nextInt();
    }


}
