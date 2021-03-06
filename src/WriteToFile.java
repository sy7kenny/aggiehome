
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WriteToFile {
	public void SetDatalog(AggieHome home){
		// here we write the data to a txt file
	       try{  
	    	   SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
	    	   Date date = new Date();
	    	   StringBuilder  dateNow= new StringBuilder( formatter.format( date ) );
	           FileWriter fr = new FileWriter("System_data"+dateNow+".txt",true);  
	           BufferedWriter br = new BufferedWriter(fr);
	           PrintWriter out = new PrintWriter(br);
	           // writing to file
               // first write the time
	           out.write(String.format("%.2f", home.time.timeDt));
	           //out.write(","+String.format("%.1f", home.time.timeDay));
	           // then write house measurements
	           //out.write(","+String.format("%4", home.time.timeDayOfWeek));
	           //out.write(","+String.format("%4", home.time.timeDayOfYear));
	           //out.write(","+String.format("%4", home.time.timeYear));
	           //out.write(","+String.format("%4", home.time.timeMonth));
	           //out.write(","+String.format("%4", home.time.timeHour));
	           //out.write(","+String.format("%4", home.time.timeMinute));
	           //out.write(","+String.format("%4", home.time.timeSecond));
	           out.write(","+String.format("%.4f", home.time.timeNow));
	           // then battery data
	           out.write(","+String.format("%.2f", home.battery.vMax));
	           out.write(","+String.format("%.2f", home.battery.vMin));
	           out.write(","+String.format("%.2f", home.battery.tMax));
	           out.write(","+String.format("%.2f", home.battery.tMin));
	           out.write(","+String.format("%.2f", home.battery.vPack));
	           out.write(","+String.format("%.2f", home.battery.cPack));
	           out.write(","+String.format("%.2f", home.battery.socSuper));
	           out.write(","+String.format("%.2f", home.battery.sohSuper));
	           out.write(","+String.format("%.1f", home.pB));
	           out.write(","+String.format("%.1f", home.pG));
	           out.write(","+String.format("%.1f", home.pH));
	           out.write(","+String.format("%.1f", home.pP));
	           // control data
	           for (int p = 0; p < home.battery.nS; p++){
	           out.write(","+String.format("%.4f", home.battery.cell[p].c));
	           out.write(","+String.format("%.4f", home.battery.cell[p].v));
	           out.write(","+String.format("%.4f", home.battery.cell[p].t));
	           //out.write(","+String.format("%.4f", home.battery.cell[p].b));
	           out.write(","+String.format("%.4f", home.battery.cell[p].socC));
	           out.write(","+String.format("%.4f", home.battery.cell[p].sohP));
	           out.write(","+String.format("%.4f", home.battery.cell[p].sohC));
	           }
	           // out.write(","+String.format("%.4f", batteryPack.energy24Hours.get(14)));
	           // 
	           out.write("\n");
	           //
	           out.close();
	           br.close();  
	       }  
	       catch(IOException e){System.out.println(home.time.timeNow+"save system data error occured");}
	    // down writing the data to txt file
		
	}
}

