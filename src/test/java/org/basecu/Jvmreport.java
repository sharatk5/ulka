package org.basecu;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Jvmreport {
	
	
	public void jvmreportgenerate(String jsonpath) {

	//mentione the file location
		
		
		File f=new File(System.getProperty("user.dir")+"\\target\\Jvmreports");
	
	
	Configuration c=new Configuration(f, "happiness");
	
	c.addClassifications("Browser", "chrome");
	c.addClassifications("platform", "windows");
	
	
	List<String> l=new ArrayList<String>();
	
	l.add(jsonpath);
	
	ReportBuilder r=new ReportBuilder(l, c);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
