package food;

public class Cook {
	private Pan pan; //��Ȯ�� �ڷ������� has a ���踦 ǥ���ҽ� Ŭ������ ����� ��� Ŭ������ Ÿ�����԰Եȴ�
	
	
	//�ܺηκ��� �ʿ��� ��ü�� �����ϱ����� setter�޼���

	public void setPan(Pan pan) {
		this.pan = pan;
	}

	public void makeFood() {
		pan.boil();
	}
}
