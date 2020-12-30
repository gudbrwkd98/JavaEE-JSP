package food;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UseCook {
	public static void main(String[] args) {
		
		
		/* spring �� ��������ʰ� ���������� !
		//���� �ø���
		FriPan pan = new FriPan();
		ElectPan ePan = new ElectPan();
		Cook cook = new Cook();
	
		cook.setPan(ePan);
		cook.makeFood();
		*/
		//�������� �̿��ؼ� ��ü�� ���Խ��� ����..
		//xml�� ���ϴ� ��ü�� ����ϸ� �̰�ü�� �ۼ��� xml. �� �ľ��Ͽ� ��ü���� �ν��Ͻ��� ���� �� 
		//�������ش� .. �̷��� ������ �����ϴ� ��ü�� ������ Spring Context ��ü�� �Ѵ� 
		ClassPathXmlApplicationContext context = null; //������ xml ���� ������ �о �ۼ��� ��ü��
		//�ν��Ͻ��� ���� �� �������ش� (���Ե� ����)
		context = new ClassPathXmlApplicationContext("spring/config/context.xml");
		
		//xml �� �̹� ������ �����̹Ƿ� �޸𸮿��� �ν��Ͻ����� ������ ���̰� �� �� � �ν��Ͻ��� ����������
		//getBean �޼���� �������� �ȴ�..
		Cook cook = (Cook)context.getBean("cook");
		cook.makeFood();
	}
}
