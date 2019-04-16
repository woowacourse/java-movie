package view;

import domain.Customer;
import domain.Movie;
import domain.PlaySchedule;

import java.util.List;

public class OutputView {
    public static void printMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }
    
    public static void printSchedules(List<PlaySchedule> playSchedules) {
    	for(PlaySchedule playSchedule : playSchedules) {
    		playSchedule.toString();
    	}
    }
    
    public static void printErr(int errType) {
    	for(ErrMsg msg : ErrMsg.values())
    	if(errType == msg.index) System.out.println(msg.getMsg());
    }
    
    public static void printCurState(Customer customer) {
    	System.out.println("���� ����");
    	for(int i = 0; i < customer.getUserMovies().size(); i++) {
    		System.out.println(customer.getUserMovies().get(i).getRst());
    		System.out.println(customer.getUserSchedules().get(i).getRst());
    		System.out.println("�����ο� : " + customer.getUsers().get(i) + "��");
    	}
    }

	public static void printResult(int result) {
		System.out.println("���� ������ �ݾ���" +  result + " �� �Դϴ�.");
		System.out.println("���Ÿ� �Ϸ��߽��ϴ�. ��ſ� ��ȭ���� �Ǽ���.");
	}
}
