package com.Keyword_Base;

import java.awt.Robot;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;

public class PomConstantClass {
	 public static WebDriver driver;
	 public static Properties prop;
	 public static EventFiringWebDriver e_driver;
	// public static WebEventListener eventListener;
	    public static WebElement element;
	    public static File file;
	    public static FileInputStream fis;
	   // public static AShot ashot;
	    public static Robot robot;
	    public static Actions action;
	    public static String doubleHash="##";
	    public static String singleHash="#";
	    public static String underScore="_";
	    public static Select select;
		public static String  value;
		public static String path="C:\\eclipse\\FinalPOM_DDFramework\\Input\\POM_OR.properties";
public static long PAGE_LOAD_TIMEOUT=20;
public static long IMPLICIT_WAIT=10;

}
