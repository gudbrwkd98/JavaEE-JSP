/*
 * �ڹٿ��� Ŭ������ �ν��Ͻ��� �����ϴ� ������� new �����ڸ� �ִ°��� �ƴϴ�!!
 * 
 * */
package study;

import java.lang.reflect.Method;

public class InstanceTest {
		public static void main(String[] args) {
			//Dog Ŭ������ new ������ �����ʰ� �÷�����
			try {
				Class dogClass = Class.forName("study.Dog");
				System.out.println("�ε� ����");
				Method[] methods = dogClass.getMethods();
				
				for (Method m : methods){
					System.out.println(m.getName());
				}
				
				//Dog Ŭ������ new �����ڸ� �����ʰ� �÷�����
				Dog dog = (Dog)dogClass.newInstance();
				System.out.println(dog.getName());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
