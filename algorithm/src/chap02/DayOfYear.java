package chap02;

import java.util.Scanner;

public class DayOfYear {
	
	/*
	 * <한 해의 경과 일 수를 계산하는 프로그램>
	 * 
	 * m월 d일
	 * - 1월의 일수 + 2월의 일수 +...+(m-1)월의 일수 +d
	 *
	 * 1. 윤년, 평년 따로 월의 일수를 적은 2차원 배열 생성
	 * 2. 윤년, 평년인지 확인 : 평년의 1월 = mdays[0][0], 윤년의 1월 = mdays[1][0]
	 *    ex)2020년 4월 15일  (-윤년): mdays[1][0](윤년의 1월 일수) + mdays[1][1](윤년의 2월 일수) + mdays[1][2](윤년의 3월 일수) + 15 = 106
	 * 
	 */
	
	static int[][] mdays= {
			{31,28,31,30,31,30,31,31,30,31,30,31},//평년(0)
			{31,29,31,30,31,30,31,31,30,31,30,31}//윤년(1)
	};
	
	//서기 year년은 윤년인가?(윤년:1/평년:0)
	static int isLeap(int year) {
		return(year % 4 == 0 && year % 100 != 0 || year % 400 == 0)? 1:0;
		
	}
	
	//서기 y년 m월 d일의 그해 경과 일 수를 구함
	static int dayOfYear(int y, int m, int d) {
		int days = d; //일수
		
		for(int i =1; i<m; i++) { //1월~(m-1)월의 일 수를 더함
			days += mdays[isLeap(y)][i-1];//윤년의 월 일수 더하기, 평년의 월 일수 더하기
		}
		return days;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int retry;
		
		System.out.println("그 해 경과 일수를 구합니다.");
		
		do {
			System.out.println("년: ");
			int year = sc.nextInt();
			
			System.out.println("월: ");
			int month = sc.nextInt();
			
			System.out.println("일: ");
			int day = sc.nextInt();
			
			System.out.printf("그 해 %d일째입니다.\n", dayOfYear(year, month, day));
			
			System.out.print("한번 더 할까요?(1.예/0.아니요) : ");
			retry = sc.nextInt();
			
		}while(retry == 1);
	}

}
