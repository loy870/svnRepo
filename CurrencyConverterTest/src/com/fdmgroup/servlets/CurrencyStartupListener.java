package com.fdmgroup.servlets;

import java.util.ArrayList;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.fdmgroup.xmlparser.DOMParser;

/**
 * Application Lifecycle Listener implementation class CurrencyStartupListener
 *
 */
@WebListener
public class CurrencyStartupListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public CurrencyStartupListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    	DOMParser parser = new DOMParser();
		ArrayList<String> names = parser.ParseXMLGetCurrencyNames();
		
		
		arg0.getServletContext().setAttribute("names", names);
	
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    }
	
}
