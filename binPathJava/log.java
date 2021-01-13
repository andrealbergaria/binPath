package binPathJava;


import java.io.BufferedReader;

import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;



import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;





public class log {

	public static ArrayList<log> allLogs;
	public static DateTimeFormatter dateFormat;
	public static File triedCombinations =  new File ("/home/andrec/workspace_3_8/binPath/files/tried_combinations");   
	public LocalDateTime logDate;
	public String dateString;
	public int minKey;
	public int maxKey;
	static int num=0;
	ArrayList<Byte[]> listOfPlainTexts;
	
	public log(int minKey,int maxKey,ArrayList<Byte[]> plainTextList) {
		 dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		 dateFormat.withZone(ZoneId.systemDefault());
		  num++;
		allLogs = new ArrayList<>();
		
		dateString = logDate.format(dateFormat);
		System.out.println("\n[log] Init data : "+dateString);
		
		this.minKey = minKey;
		this.maxKey = maxKey;
		this.listOfPlainTexts = plainTextList;
			
	}
	
	
	
  public void writeLogToFile(File f) {
	  try {
		  
		  /*	date  
		    minKey 
		    maxKey  
		    --plaintext : 
		    --end\n
		    
		  */
		  
		  
	  FileWriter fw = new FileWriter(f,true);
	  
	  fw.write("date ");
	  fw.write(dateString+"\n");
	  fw.write("minKey "+minKey+"\n");
	  fw.write("maxKey "+maxKey+"\n");
	  fw.write("--plaintext "+"\n");
		
	  byte[] ba;
		String r = new String();
		for (Byte[] bArr : listOfPlainTexts) {
			byte[] pr = util.toPrimitives(bArr);
			String str = new String(pr);
			fw.write(str);
		}
		fw.write("--end\n");
	  fw.close();
	  }
	  catch(IOException e) {
		  e.printStackTrace();
	  }
	  
  }
  /*
   * returns block reads (	date minKey  maxKey --plaintext :  --end )
   * 
   */
  public static ArrayList<log> readLog(String logFile) {
	  try {
		  
		  ArrayList<log> retValue = new ArrayList<>();
		  
		  Charset cs = Charset.defaultCharset(); 
		  Path path = FileSystems.getDefault().getPath(logFile); 
		  BufferedReader br = Files.newBufferedReader(path,cs);
		  
		  String line=br.readLine();
		  log logToAdd = new log(0,0,null);
		  String[] tokens;
		  while (line != null) {
			  tokens = line.split(" ");
			  if (tokens[0].contains("date")) {
				  	Arrays.toString(tokens);
				  	logToAdd.logDate = LocalDateTime.parse(tokens[1]);
				  	logToAdd.dateString =  logToAdd.logDate.format(dateFormat);
			  }
			  else if(tokens[0].contains("minKey")) {
				  logToAdd.minKey = Integer.parseInt(tokens[0]);
				  Arrays.toString(tokens);
			  }
			  else if (tokens[0].contains("maxKey")) {
				  logToAdd.maxKey = Integer.parseInt(tokens[0]);
				  Arrays.toString(tokens);
			  }
			  else if(tokens[0].contains("--plaintext")) {
				  String temp = br.readLine();
				  while (!temp.contains("--end")) {
					  byte[] arr = temp.getBytes();
					  Byte[] t = util.toObjects(arr);
					  logToAdd.listOfPlainTexts.add(t);
					  temp = br.readLine();
				  }
			  }
			logToAdd.print();	
			retValue.add(logToAdd);
			
			logToAdd = new log(0,0,null);		
			line = br.readLine(); 	
		  }				
			return retValue;	
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return null;
  }
  public void print() {
	  
	  System.out.println("\nLog #"+num+" print: ("+triedCombinations.getAbsolutePath());
	  System.out.println("Date -> "+logDate.format(dateFormat));
	  System.out.println("\nMinKey : "+minKey);
	  System.out.println("\nMaxKey : "+maxKey);
	  for (Byte[] plainTexts : listOfPlainTexts) {
		  Arrays.toString(plainTexts);
		  
	  }
	  System.out.println("\nFinished log");
	  
  }

}
