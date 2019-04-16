package view;

import java.util.Scanner;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);

	public static int inputMovieId() {
		System.out.println("## ������ ��ȭ�� �����ϼ���.");
		return scanner.nextInt();
	}

	public static int inputMovieTime() {
		System.out.println("## ������ �ð�ǥ�� �����ϼ���.(ù���� ���� 1��)");
		return scanner.nextInt();
	}

	public static int inputGroupSize() {
		System.out.println("## ������ �ο��� �Է��ϼ���.");
		return scanner.nextInt();
	}
	
	public static int inputNextStep() {
		System.out.println("##������ �����ϰ� ������ �����Ϸ��� 1��, �߰� ������ �����Ϸ��� 2��");
		return scanner.nextInt();
	}

	public static int inputPoint() {
		System.out.println("## ������ �����մϴ�.");
		System.out.println("## ����Ʈ ��� �ݾ��� �Է��ϼ���. ����Ʈ�� ������ 0 �Է�");
		return scanner.nextInt();
	}

	public static int inputCashOrCredit() {
		System.out.println("##�ſ�ī��� 1��, ������ 2��");
		return scanner.nextInt();
	}
}
