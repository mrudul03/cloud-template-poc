package cf;

import java.util.Map;

import com.google.common.base.Charsets;
import com.google.common.collect.Maps;
import com.google.common.io.Resources;
import com.hubspot.jinjava.Jinjava;


public class JinjavaTest {

	public static void main(String args[]){
		JinjavaTest test = new JinjavaTest();
		test.runJinja();
	}
	
	private void runJinja(){
		try {
			Jinjava jinjava = new Jinjava();
			Map<String, Object> context = Maps.newHashMap();
			context.put("name", "Mrudul");
	
			String template = Resources.toString(Resources.getResource("my-template.yml"), Charsets.UTF_8);
	
			String renderedTemplate = jinjava.render(template, context);
			System.out.println(renderedTemplate);
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
