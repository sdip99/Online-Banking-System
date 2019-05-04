package com.igate.obs.logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class BankingLogger {

	public static Logger logger;
	public static Logger getLogger(){
		if(logger==null){
			logger = Logger.getLogger("BankingLogger");
			PropertyConfigurator.configure("/log4j.properties");
		}
		return logger;
	}
}
