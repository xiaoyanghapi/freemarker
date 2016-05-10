import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;


/** 
 * freemaker测试类
 * @author 作者 yjj: 
 * @version 创建时间：2016-5-10 下午7:27:34 
 * 类说明 
 */

public class Freemarker {

	public static void main(String[] args) throws Exception {
		//配置对象
		Configuration conf = new Configuration();
		//模板路径
		String ftl = "D:\\babaSports\\workspace\\freemaker\\ftl\\";
		//导入模板
		conf.setDirectoryForTemplateLoading(new File(ftl));
		//获取模板
		Template template = conf.getTemplate("Test.html");
		
		//设置输出路径创建输出流
		Writer out = new FileWriter(new File(ftl+"freemaker.html"));
		
		Map<String, Object> rootMap = new HashMap<String, Object>();
		rootMap.put("user", new User("杨景江","admin"));
		List<User> list  = new ArrayList<User>();
		for (int i = 0; i < 10; i++) {
			User user   = new User("杨景江","admin");
			list.add(user);
		}
		rootMap.put("list", list);
		
		//开始输出生成文件
		template.process(rootMap, out);
		
		//输出前要先flush下
		out.flush();
		out.close();
		
		System.out.println("生成成功！");
	}
	
}
