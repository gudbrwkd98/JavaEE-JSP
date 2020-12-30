package food;

public class Cook {
	private Pan pan; //정확한 자료형으로 has a 관계를 표시할시 클래스를 지우면 모든 클래스에 타격을입게된다
	
	
	//외부로부터 필요한 객체를 주입하기위한 setter메서드

	public void setPan(Pan pan) {
		this.pan = pan;
	}

	public void makeFood() {
		pan.boil();
	}
}
