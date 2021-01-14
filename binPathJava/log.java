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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;





public class log {

	public static ArrayList<log> allLogs;
	public static DateTimeFormatter dateFormat;
	public static File logFile =  new File ("/home/andrec/workspace_3_8/binPath/files/log");   
	public LocalDateTime logDate;
	public String dateString;
	public int minKey=-1;
	public int maxKey=-1;
	
	public HashMap<Integer,String> keysToPlain = new HashMap<Integer,String>();
	public ArrayList<Integer> workingKeys = new ArrayList<>();
	
	public log(int min,int max) {
		 dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		 //dateFormat.withZone(ZoneId.systemDefault());
		 
		allLogs = new ArrayList<>();
		
		LocalDateTime ldt = LocalDateTime.now();
		
		dateString = ldt.format(dateFormat);
		this.minKey=min;
		this.maxKey = max;
		try {
		if (minKey==-1 || maxKey==-1) {
			
			throw new KeyOutOfRangeException("[log constructor] [KeyOutOfRange Exception] Couldn't create instance of log, min or max key are -1");
		}
		}
		catch(KeyOutOfRangeException e) {
			e.printStackTrace();
		}
		System.out.println("\n[log] Init Log Block date : "+dateString);
		
		
	}
	
	
	public void writePrelude(File f) {
		try {
		FileWriter fw = new FileWriter(f,true);
		  
		
		  }
		catch(IOException e) {
			e.printStackTrace();
		}
		  
	}
	
	public boolean hasPlainText() {
		if (!keysToPlain.isEmpty())
			return true;
		return false;
	}
	
	
	
  public void writeLog(File f) {
	  try {
		  /* format of file
		  /*	date  
		    minKey 
		    maxKey  
		    --plaintext :
		    key plaintext 
		    --end\n
		    
		  */
		  System.out.println("\n[writeLog] Running writeLog");
		  FileWriter fw = new FileWriter(f,true);
			
		  System.out.println("\n[writeLog] Writing prelude log to file "+f.getAbsolutePath());
		  
		  
		  fw.write("date ");
		  fw.write(dateString+"\n");
		  System.out.println("\n[writeLog] written prelude");
		  
	   
	   String s=String.valueOf(minKey);
	   String s1=String.valueOf(maxKey);
	   fw.write("minKey "+s+"\n");
	   System.out.println("minKey : "+s);
	  fw.write("maxKey "+s+"\n");
	   System.out.println("maxKey : "+s1);
	  
	  fw.write("--plaintext "+"\n");
	 
	  
		if (hasPlainText()) {
			  for (Entry<Integer, String> entry : keysToPlain.entrySet()) {
		          fw.write("key "+entry.getKey()+")\n"+ "PlainText "+entry.getValue());
		          System.out.println("[writeLog] key "+entry.getKey()+" plainText "+entry.getValue());
		      }

		}
		else {
			fw.write("NoPlainText\n");
			System.out.println("\n[writeLog] Couldn't decrypt cipherText (no key works))");
		}
		fw.write("--end\n");
	  fw.close();
	  System.out.println("\n[log.writeLog] Wrote "+f.getAbsolutePath());
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
		  log logToAdd = new log(-1,-1);
		  String[] tokens;
		  while (line != null) {
			  tokens = line.split(" ");
			  Arrays.toString(tokens);
			  if (tokens[0].contains("date")) {
				  
				  	logToAdd.logDate = LocalDateTime.parse(tokens[1]);
				  	logToAdd.dateString =  logToAdd.logDate.format(dateFormat);
			  }
			  else if(tokens[0].contains("minKey")) {
				  logToAdd.minKey = Integer.parseInt(tokens[1]);
				  
			  }
			  else if (tokens[0].contains("maxKey")) {
				  logToAdd.maxKey = Integer.parseInt(tokens[1]);
				  
			  }
			  else if(tokens[0].contains("--plaintext")) {
				  
				  
				  String tempLine = br.readLine();
				  while (!tempLine.contains("--end")) {
					  String[] toks = tempLine.split(" ");
					  int keyRead = Integer.parseInt(toks[0]);
					  logToAdd.keysToPlain.put(keyRead,toks[1]);
					  tempLine = br.readLine();
				  }
			  }
			  try {
			  if (logToAdd.minKey<0) {
				  throw new KeyOutOfRangeException("\n[log.readLog] Min key is below zero");
			  }
			  if (logToAdd.maxKey < 0) {

				  throw new KeyOutOfRangeException("\n[log.readLog] Max key is below zero");
			  }
			  }
			  catch(KeyOutOfRangeException e) {
				  System.err.println("\n[readLog] Couldn read mink key and max key from file");
			  }
				  
			logToAdd.print();	
			retValue.add(logToAdd);
			
			logToAdd = new log(-1,-1);		
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
	  
	  System.out.println("\nLog File : "+logFile.getAbsolutePath());
	  System.out.println("Date : "+logDate.format(dateFormat));
	  System.out.println("\nMinKey : "+minKey);
	  System.out.println("\nMaxKey : "+maxKey);
	  
	  
	  for (Map.Entry<Integer, String> pair : keysToPlain.entrySet()) {
	      System.out.println("Key "+pair.getKey() +" PlainText " +pair.getValue());
	  }

		  
	  }
	  
	  
  }


