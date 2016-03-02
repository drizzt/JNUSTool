package de.mas.jnustool.util;

import java.io.File;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class Util {
	
	public static byte[] commonKey;
	
	public static byte[] hexStringToByteArray(String s) {
	    int len = s.length();
	    byte[] data = new byte[len / 2];
	    for (int i = 0; i < len; i += 2) {
	        data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
	                             + Character.digit(s.charAt(i+1), 16));
	    }
	    return data;
	}
	
	
	public static String ByteArrayToString(byte[] ba)
	{
	  if(ba == null) return null;
	  StringBuilder hex = new StringBuilder(ba.length * 2);
	  for(byte b : ba){
	    hex.append(String.format("%02X", b));
	  }
	  return hex.toString();
	}
	
	public static int getIntFromBytes(byte[] input,int offset){		
		return ByteBuffer.wrap(Arrays.copyOfRange(input,offset, offset+4)).getInt();
	}
	public static long getIntAsLongFromBytes(byte[] input,int offset){
		long result = 0 ;		
		if((int)input[offset]+128 > 0 && (int)input[offset]+128  < 128){			
			
			input[offset] += 128;
			
			result = (long)ByteBuffer.wrap(Arrays.copyOfRange(input,offset, offset+4)).getInt();
			
			result += 1024L*1024L*2048L;
			return result;
			
		}
		return (long)ByteBuffer.wrap(Arrays.copyOfRange(input,offset, offset+4)).getInt();
	}

	public static short getShortFromBytes(byte[] input, int offset) {
		return ByteBuffer.wrap(Arrays.copyOfRange(input,offset, offset+2)).getShort();		
	}

	public static long StringToLong(String s) {
		try{
			BigInteger bi = new BigInteger(s, 16);			
		    return bi.longValue();
		}catch(NumberFormatException e){
			System.err.println("Invalid Title ID");
			return 0L;
		}
	}
	
	public static void createSubfolder(String folder){
		
		String [] path = folder.split("/");		
		File folder_ = null;
		String foldername = new String();
		if(path.length == 1){
			folder_ = new File(folder);				
		    if(!folder_.exists()){
		    	folder_.mkdir();	    	    	
		    }
		}
		for(int i = 0;i<path.length-1;i++){
			if(!path[i].equals("")){	    		
				foldername += path[i] + "/";
				folder_ = new File(foldername);				
			    if(!folder_.exists()){
			    	folder_.mkdir();	    	    	
			    }
			}	    	
		}
	}
}
