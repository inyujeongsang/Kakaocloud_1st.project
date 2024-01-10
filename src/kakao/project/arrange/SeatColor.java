package kakao.project.arrange;


public interface SeatColor {
	/* - 좌석 색상을 설정하는데 사용되는 메서드를 정의한 인터페이스다.
	 * - 인터페이스는 다른 클래스에서 implements한다면, 무조건 오버라이딩 해야한다.
	 * */
	public void setMenSeatColor(int i);
	public void setWomenSeatColor(int i);
	public void setReaderSeatColor(int i);
}