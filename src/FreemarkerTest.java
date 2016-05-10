import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;


public class FreemarkerTest {

	public static void main(String[] args) throws Exception {

		Configuration conf = new Configuration();

		String ftl = "D:\\babaSports\\workspace\\freemaker\\ftl\\";

		conf.setDirectoryForTemplateLoading(new File(ftl));

		Template template = conf.getTemplate("Test.html");

		template.setEncoding("UTF-8");
		FileOutputStream fos= new FileOutputStream(ftl+"freemaker.html");
		OutputStreamWriter osw =new OutputStreamWriter(fos, "UTF-8");
		BufferedWriter bw =new BufferedWriter(osw, 1024);
		
		
		Map<String, Object> rootMap = new HashMap<String, Object>();
		rootMap.put("user", new User("杨景江","admin"));
		List<User> list  = new ArrayList<User>();
		for (int i = 0; i < 10; i++) {
			User user   = new User("杨景江","admin");
			list.add(user);
		}
		rootMap.put("list", list);
		
		template.process(rootMap, bw);
		

		bw.flush();
		bw.close();
		
		System.out.println("以流的方式输出成功！");
	}
	
}
