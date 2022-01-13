package kr.co.mlec.board;



/*
 * 자바 코드 고치면 서버가 restart해야함~!
 * 
 * 자바빈즈 클래스
 * 1. 패키지 존재
 * 2. 클래스의 접근제한자 public
 * 3. 맴버변수의 접근제한자 private
 * 4. getter/setter 구현
 * 5. 기본 생성자
 * 
 * 
 * 기본생성자 alt shift s 누르고 c 선택
 * 매개변수 생성자                               o 선택
 * getter/setter          r 선택
 * toString               s 선택
 */

public class BoardVO {
	private int no;
	private String title;
	
	

	public BoardVO() {
		
	}

	public BoardVO(int no, String title) {
		super();
		this.no = no;
		this.title = title;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
}
