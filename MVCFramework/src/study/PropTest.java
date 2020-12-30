/*
 * �ڹ��� �÷��� �����ӿ� ��ü�� �����Ͱ� key-value�� ������ �Ǿ��ִ� ������ �����Ͽ� 
 * ó���Ҽ� �ִ� ��ü�� Properties �� �Ѵ�!
 * �� ������ ���� ������ ���� �� ���� key-value �� �� �ָ��� �����Ѵ�!!
 * 
 * */

package study;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropTest {
	public PropTest() {
		FileInputStream fis = null;
		Properties props = new Properties();
		//���� ���� �ڹ��ڵ忡�� Ư�� ���丮�� �� �ִ� ���������� ���� �����ؾ��� 
		try {
		 fis = new FileInputStream("C:/workspace/javaEE_workspace/MVCFramework/WebContent/WEB-INF/mapping/mapping.properties");
		 props.load(fis); //������Ƽ�� ��ü�� ��Ʈ�� ����
		 //���ݺ��ʹ� key ������ �˻��� �����ϴ�!!
		System.out.println(props.getProperty("/movie.do"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fis !=null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new PropTest();
	}
}
