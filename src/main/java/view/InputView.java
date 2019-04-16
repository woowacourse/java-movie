package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMovieId() {
        System.out.println("## 예약할 영화를 선택하세요.");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("영화 아이디는 숫자입니다.");
            return inputMovieId();
        }
    }

    public static int inputMovieSchedule() {
        System.out.println("##예약할 시간표를 선택하세요.(첫번째 상영 시간이 1번)");
        try{
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("영화 시간은 숫자를 입력하여 선택하세요");
            return inputMovieSchedule();
        }
    }

    public static int inputMovieWatcher() {
        System.out.println("##예약할 인원을 입력하세요.");
        try{
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("예약 인원은 숫자를 입력하세요");
            return inputMovieWatcher();
        }
    }

    public static int inputMoreReservation() {
        System.out.println("##예약을 종료하고 결제를 진행하려면 1번, 추가 예약을 진행하려면 2번");
        try{
            int more = Integer.parseInt(scanner.nextLine());
            validateMoreReservationNumber(more);
            return more;
        } catch (NumberFormatException e) {
            System.out.println("예약 인원은 숫자를 입력하세요");
            return inputMovieWatcher();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputMoreReservation();
        }
    }

    private static void validateMoreReservationNumber(int more) throws IllegalArgumentException {
        if (more != 1 && more != 2) {
            throw new IllegalArgumentException("1 또는 2를 입력하세요.");
        }
    }
}
