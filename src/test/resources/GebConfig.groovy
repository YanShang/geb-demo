/*
	This is the Geb configuration file.
	
	See: http://www.gebish.org/manual/current/configuration.html
*/

import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.chrome.ChromeDriver

//driver = { new FirefoxDriver() }
driver = { new ChromeDriver() }

baseUrl = "http://dl2k469v.am.mot-mobility.com:8080/productanalytics"
