package xml;

import java.io.File;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.PasswordAuthentication;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
public class XmlRead {
	public boolean status=true;
	public double va=0;
	public void getMeasure(){
		try {
	        this.status=true;
	        Authenticator.setDefault(new CustomAuthenticator());
	        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	        // URL for the xml file
	        URL url = new URL("http://192.168.30.100/setup/devicexml.cgi?ADDRESS=1&TYPE=DATA");
	        DocumentBuilder db = dbf.newDocumentBuilder();
	        Document doc = db.parse((url).openStream());
	        doc.getDocumentElement().normalize();
	       
	        NodeList nodeLst = doc.getElementsByTagName("point");
	        //System.out.println("Information of AggieVillage");
	           // Loop through the list
	        for (int s = 0; s < nodeLst.getLength(); s++) {

	          Node fstNode = nodeLst.item(s);

	          if (fstNode.getNodeType() == Node.ELEMENT_NODE) {

	                 Element fstElmnt = (Element) fstNode;
	                 String name = fstElmnt.getAttribute("name");
	                 String value = fstElmnt.getAttribute("value");
	                 String number = fstElmnt.getAttribute("number");
	                 if ("32".equals(number))  //  |"361".equals(number)|"376".equals(number)
	                 {
	                     this.va = Double.parseDouble(value);
	                     System.out.println("Point " + name + " : " + "value " + va);
	                 }
	          }

	            }
	            } catch (Exception e) {
	            	System.out.println("Error while reading from XML.");
	           this.status=false;
	  }
	    }
	    public static class CustomAuthenticator extends Authenticator {
	    	
	    	       
	    	
	    	        // Called when password authorization is needed
	    	
	    	        protected PasswordAuthentication getPasswordAuthentication() {
	    	
	    	             
	    	
	    	            // Get information about the request    	
	    	            String prompt = getRequestingPrompt();    	
	    	            String hostname = getRequestingHost();    	
	    	            InetAddress ipaddr = getRequestingSite();
	   	   	            int port = getRequestingPort();
	       	            String username = "admin";    	
	    	            String password = "tomato12";    	    	   	
	    	            // Return the information (a data holder that is used by Authenticator)
	    	
	    	            return new PasswordAuthentication(username, password.toCharArray());
	    	        }
	    	    }    
	}

