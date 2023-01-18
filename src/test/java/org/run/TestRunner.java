package org.run;

import org.junit.runner.RunWith;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\REYANSH\\eclipse-workspace\\Cucumber\\src\\test\\resources\\FeaturedFiles\\facebook.feature", glue="org.step", snippets=SnippetType.CAMELCASE, plugin= {"html:target","jason:target\\Reports\\fb.json","Junit:target\\Reports\\lo.xml"})


public class TestRunner {
	
	

}
