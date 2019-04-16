package view;

import utils.InputNumber;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private static final String SELECT_MOVIE_TO_RESERVE_MESSAGE = "## 예약할 영화를 선택하세요.";
    private static final String SELECT_MOVIE_PLAY_SCHEDULE_MESSAGE = "## 예약할 시간표를 선택하세요. (첫번째 상영 시간이 1번)";
    private static final String ENTER_PEOPLE_NUMBER_OF_RESERVE_MESSAGE = "## 예약할 인원을 입력하세요.";
    private static final String SELECT_END_OR_ADD_RESERVE_MESSAGE = "## 예약을 종료하고 결제를 진행하려면 1번, 추가 예약을 진행하려면 2번";
    private static final String ENTER_AMOUNT_OF_POINT_TO_USE_MESSAGE = "## 포인트 사용 금액을 입력하세요. 포인트가 없으면 0 입력";
    private static final String SELECT_PAYMENT_METHOD_MESSAGE = "## 신용카드는 1번, 현금은 2번";

    public static int inputMovieId() {
        System.out.println(SELECT_MOVIE_TO_RESERVE_MESSAGE);
        return InputNumber.getNaturalNumber();
    }

    public static int inputMoviePlaySchedule() {
        System.out.println(SELECT_MOVIE_PLAY_SCHEDULE_MESSAGE);
        return InputNumber.getNaturalNumber();
    }

    public static int inputPeopleNumberOfReservation() {
        System.out.println(ENTER_PEOPLE_NUMBER_OF_RESERVE_MESSAGE);
        return InputNumber.getNaturalNumber();
    }

    public static int inputEndOrAddReservation() {
        System.out.println(SELECT_END_OR_ADD_RESERVE_MESSAGE);
        return InputNumber.getNaturalNumber();
    }

    public static int inputAmountOfPointToUse() {
        System.out.println(ENTER_AMOUNT_OF_POINT_TO_USE_MESSAGE);
        return InputNumber.getNaturalNumber();
    }

    public static int inputPaymentMethod() {
        System.out.println(SELECT_PAYMENT_METHOD_MESSAGE);
        return InputNumber.getNaturalNumber();
    }
}
