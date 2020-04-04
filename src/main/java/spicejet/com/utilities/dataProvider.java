package spicejet.com.utilities;

import java.lang.reflect.Method;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

public class dataProvider {
	@DataProvider(name="searchBuses")
	public static Object[][] getBusesSearchInfoByMethod(Method m){
	Object[][] searchBuses = null;
		if(m.getName().equalsIgnoreCase("searchBuses")){
			searchBuses = new Object[][] { 
					{ "HYD", "GOI" }, 
					{ "GOI", "HYD" }, 
					{ "HYD", "CJB" } 
				};
		
		}	
	return searchBuses;		
	}
	@DataProvider
	public static Object[][] getBusesSearchInfoByGroup(ITestContext c){
	Object[][] searchBuses = null;
	for (String group : c.getIncludedGroups()) {
		if(group.equalsIgnoreCase("Regression")){
			searchBuses = new Object[][] { 
				{ "HYD", "GOI" }, 
				{ "GOI", "HYD" },
				};
		break;	
		}
	}
	return searchBuses;		
	}
	
}
