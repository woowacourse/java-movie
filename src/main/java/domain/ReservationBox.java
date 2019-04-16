package domain;

import java.util.*;


public class ReservationBox {
    private List<Movie> listOfBoughtMovies = new ArrayList<>();
    private List<Integer>listOfMovieTimes = new ArrayList<>();
    private List<Integer> listOfPeopleCount = new ArrayList<>();
    private List<Integer> listOfPoints = new ArrayList<>();
    private List<Double> listOfSaleAmouts = new ArrayList<>();
    private List<Integer> listOfPayments = new ArrayList<>();
    private List<Integer> listOfRevenues = new ArrayList<>();

    public String askUserWhatMovie() {
        boolean isUserInputRight = false;
        String userInput = "error:askUserWhatMovie()";
        while (!isUserInputRight) {
            userInput = askAndReceiveInput("##예약할 영화를 선택하세요.");
            isUserInputRight = checkUserInput(userInput);
        }
        return userInput;
    }

    public static String askAndReceiveInput(String sentence) {
        System.out.println(sentence);
        Scanner reader = new Scanner(System.in);
        String userInput = reader.nextLine();
        return userInput;
    }

    public static boolean checkUserInput(String userInput) {
        if (isNonNumeric(userInput) || isNotMovieNumber(userInput) || isLengthNot1(userInput)) {
            return false;
        }
        return true;
    }

    public static boolean isNonNumeric(String userInput) {
        if (userInput.matches("[0-9]+")) {
            return false;
        }
        System.out.println("숫자만 입려가능합니다. 공백이나 특수문자도 안됩니다.");
        return true;
    }

    public static boolean isNotMovieNumber(String userInput) {
        int intUserInput = Integer.parseInt(userInput);
        if (intUserInput != 1 && intUserInput != 5 && intUserInput != 7 && intUserInput != 8) {
            System.out.println("영화목록에 없는 숫자입니다. 1,5,7,8 중 선택해 주세요!");
            return true;
        }
        return false;
    }

    public static boolean isLengthNot1(String userInput) {
        if (userInput.length() != 1) {
            System.out.println("입력은 한 숫자만 해주세요!");
            return true;
        }
        return false;
    }

    public String askUserWhatTime(Movie selectedMovie) {
        boolean isUserInputRight = false;
        String userInput = "error:askUserWhatTime()";
        while (!isUserInputRight) {
            userInput = askAndReceiveInput("예약할 시간표를 선택하세요. (첫번째 상영 시간이 1번)");
            isUserInputRight = checkUserTime(userInput, selectedMovie);
        }
        return userInput;
    }

    public static boolean checkUserTime(String userInput, Movie selectedMovie) {
        if (isNonNumeric(userInput) || isLengthNot1(userInput) || isNotMovieTime(userInput, selectedMovie) || isNotAvailable(userInput, selectedMovie)) {
            return false;
        }
        return true;
    }

    private static boolean isNotMovieTime(String userInput, Movie selectedMovie) {
        int intUserInput = Integer.parseInt(userInput);
        if (intUserInput < 0 || intUserInput > selectedMovie.getTimeLength()) {
            System.out.println("영화시간표에 있는 시간만 입력해주세요!");
            return true;
        }
        return false;
    }

    private static boolean isNotAvailable(String userInput, Movie selectedMovie) {
        if (selectedMovie.getAvailableSeat(userInput) < 1) {
            System.out.println("좌석이 없습니다");
            return true;
        }
        return false;
    }

    public String askHowManyPeople(String whatTime, Movie selectedMovie) {
        boolean isUserInputRight = false;
        String userInput = "error:askUserWhatMovie()";
        while (!isUserInputRight) {
            userInput = askAndReceiveInput("##예약할 인원은 입력하세요");
            isUserInputRight = checkUserPeople(userInput, whatTime, selectedMovie);
        }
        return userInput;
    }

    private static boolean checkUserPeople(String userInput, String whatTime, Movie selectedMovie) {
        if (isLengthNot1(userInput) || isPeopleBiggerThanAvailalble(userInput, whatTime, selectedMovie)) {
            return false;
        }
        return true;
    }

    private static boolean isPeopleBiggerThanAvailalble(String userInput, String whatTime, Movie selectedMovie) {
        int intUserInput = Integer.parseInt(userInput);
        if (intUserInput > selectedMovie.getAvailableSeat(whatTime)) {
            System.out.println("신청인원이 빈좌석을 초과했습니다!");
            return true;
        }
        return false;
    }

    public void saveInformation(Movie selectedMovie, String whatTime, String howManyPeople) {
        listOfBoughtMovies.add(selectedMovie);
        int intWhatTime = Integer.parseInt(whatTime);
        listOfMovieTimes.add(intWhatTime);
        int intHowManyPeople = Integer.parseInt(howManyPeople);
        listOfPeopleCount.add(intHowManyPeople);
        int currentRevenue = selectedMovie.getPrice()*intHowManyPeople;
        listOfRevenues.add(currentRevenue);

    }

    public int askUserContinue() {
        String userInput = this.askContinue();
        int intUserInput = Integer.parseInt(userInput);
        return intUserInput;
    }

    public String askContinue() {
        boolean isUserInputRight = false;
        String userInput = "error:askUserWhatMovie()";
        while (!isUserInputRight) {
            userInput = askAndReceiveInput("예약을 종료하고 결제를 진행하려면 1, 추가예약하려면 2번을 눌러주세요");
            isUserInputRight = checkUserContinue(userInput);
        }
        return userInput;
    }

    public static boolean checkUserContinue(String userInput) {
        if (isNonNumeric(userInput) || isNot1Or2(userInput)) {
            return false;
        }
        return true;
    }

    private static boolean isNot1Or2(String userInput) {
        int intUserInput = Integer.parseInt(userInput);
        if (intUserInput != 1 && intUserInput != 2) {
            System.out.println("1이나 2만 입력해주세요");
            return true;
        }
        return false;
    }

    public void finalizePayment() {
        System.out.println("##결제를 진행합니다.");
        String pointAmount = this.askPointAmount();
        String cashOrCredit = this.askCashOrCredit();
        int intPointAmount = Integer.parseInt(pointAmount);
        this.listOfPoints.add(intPointAmount);
        int intCashOrCredit = Integer.parseInt(cashOrCredit);
        double saleAmount = returnSaleAmount(intCashOrCredit);
        this.listOfSaleAmouts.add(saleAmount);

    }

    public static double returnSaleAmount(int intCashOrCredit) {
        if (intCashOrCredit == 1) {
            return 0.05;
        }
        return 0.02;
    }

    public String askCashOrCredit() {
        boolean isUserInputRight = false;
        String userCashOrCredit = "error:askUserWhatMovie()";
        while (!isUserInputRight) {
            userCashOrCredit = askAndReceiveInput("##신용카드는 1번, 현금은 2번");
            isUserInputRight = checkCashOrCredit(userCashOrCredit);
        }
        return userCashOrCredit;
    }

    public static boolean checkCashOrCredit(String userInput) {
        if (isNonNumeric(userInput) || isNot1Or2(userInput)) {
            return false;
        }
        return true;
    }

    public String askPointAmount() {
        boolean isUserInputRight = false;
        String userPointAmount = "error:askUserWhatMovie()";
        while (!isUserInputRight) {
            userPointAmount = askAndReceiveInput("##포인트 사용 금액을 입력하세요! 포인트가 없으면 0을 입력하세요");
            isUserInputRight = checkUserPointAmount(userPointAmount);
        }
        return userPointAmount;
    }

    public static boolean checkUserPointAmount(String userInput) {
        if (isNonNumeric(userInput) || isBiggerThanMovieTicket(userInput)) {
            return false;
        }
        return true;
    }

    public static boolean isBiggerThanMovieTicket(String userInput) {
        int intUserInput = Integer.parseInt(userInput);
        if (intUserInput > 8000) {
            System.out.println("포인트는 영화가격을 초과할 수 없습니다!");
            return true;
        }
        return false;
    }

    public int calculatePayment() {
        // get all the movie prices
        int totalRevenues = 0;
        for (int i=0, n=this.listOfRevenues.size(); i<n; i++) {
            totalRevenues += listOfRevenues.get(i);
        }

        //get all the points
        int totalPoints = 0;
        for (int i=0, n=this.listOfPoints.size(); i<n; i++) {
            totalPoints += listOfPoints.get(i);
        }
        //get all the saleAmounts
        double totalSales = 0;
        for (int i=0, n=this.listOfSaleAmouts.size(); i<n; i++) {
            totalSales += listOfSaleAmouts.get(i);
        }
        //int result = (int) ((totalRevenues)*totalSales);
        //int resultWitoutSales = totalRevenues
        int resultWithoutSales = totalRevenues - totalPoints;
        double salePrice = resultWithoutSales*totalSales;
        int result = (int) (resultWithoutSales - salePrice);
        return result;
    }

    public void printPayment(int total) {
        System.out.println("최종 결제한 금액은 " + total +"원 입니다.");
        System.out.println("예매를 완료했습니다. 즐거운 영화 관람되세요.");

    }
}
