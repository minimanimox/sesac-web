package kr.co.mlec.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class HandlerMapping {

	
	private Map<String,Controller> mappings =null;
	   
	public HandlerMapping(String propLoc) {

		Properties prop = new Properties();
		mappings = new HashMap<>();
		
		try {
		//InputStream is = new FileInputStream("D:\\web-workspace\\Mission-Web-MVC\\bean.properties");
		
		InputStream is = new FileInputStream(propLoc);
		prop.load(is);
		
		Set<Object> keys = prop.keySet();
		for(Object key : keys) {
			String className = prop.getProperty(key.toString());
			System.out.println(key + " : " + className);
				
			Class<?> clz = Class.forName(className);
			mappings.put(key.toString(), (Controller)clz.newInstance());
			//모두 컨트롤러를 상속받고 있어서 형변환
		}
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public Controller getController(String uri) {
	      
	      return mappings.get(uri);   
	   }
	
	public static void main(String[] args) throws Exception {
		
		/*
		java.util.Random r = new java.util.Random();
		int random = r.nextInt(100);
		System.out.println("추출된 난수 : " + random);
		*/
		/*
		Class<?> clz = Class.forName("java.util.Random");
		java.util.Random obj = (java.util.Random)clz.newInstance();
		int random = obj.nextInt(100);
		System.out.println("추출된 난수 : " + random);
		*/
		/*
		Class<?> clz = Class.forName("kr.co.mlec.controller.BoardListController");
		BoardListController obj = (BoardListController)clz.newInstance();
		obj.handlerRequest(null, null);
		
		*/
		
		
	}
	
	/*
	  switch(uri) {
	      case "/board/list.do" :
	         //모든 비즈니스 수행 
	         control = new BoardListController();
	         break;
	      case "/board/writeForm.do" :
	         control = new BoardWriteFormController();
	         break;
	      }
	
	
	*/
	
}
