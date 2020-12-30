/*
 * 자바의 컬렉션 프레임웍 객체중 데이터가 key-value의 쌍으로 되어있는 형식을 전담하여 
 * 처리할수 있는 객체를 Properties 라 한다!
 * 이 세상의 여러 형태의 형식 중 오직 key-value 로 된 쌍만을 이해한다!!
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
		//실행 중인 자바코드에서 특정 디렉토리에 들어가 있는 문서파일을 먼저 접근해야함 
		try {
		 fis = new FileInputStream("C:/workspace/javaEE_workspace/MVCFramework/WebContent/WEB-INF/mapping/mapping.properties");
		 props.load(fis); //프로퍼티스 객체와 스트림 연결
		 //지금부터는 key 값으로 검색이 가능하다!!
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
