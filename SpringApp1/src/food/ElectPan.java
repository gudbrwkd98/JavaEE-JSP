package food;

public class ElectPan implements Pan{

	@Override
	public void boil() {
		System.out.println("음식을 전기로 데워요");
	}

}
