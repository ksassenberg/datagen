package com.fenergo.fdim.datagen.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.unix4j.Unix4j;

import com.fenergo.fdim.datagen.config.Config;

public class FileUtils {
	public static void removeExcessDeclarations(Config config){
		
		// Remove all occurences of xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" attribute
    	String remove_string = "xmlns:" + Config.XSI_NAMESPACE_PREFIX + "=\\\"" + Config.XSI_NAMESPACE_URI.replaceAll("/", "\\\\/") + "\\\"";
    	String remove_string_command = "s/" + " " + remove_string + "//g";
    	
    	// Reintroduce xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" attribute in to wrapper element.
    	String reintroduce_string = "<" + Config.WRAPPER_ELEMENT + ">";
    	String reintroduce_string_command = "s/" 
    			+ reintroduce_string 
    			+ "/" 
    			+ "<" + Config.WRAPPER_ELEMENT + " " + remove_string +  ">" 
    			+ "/g";
		
		BufferedReader br = null;
    	FileWriter fw = null;
		BufferedWriter bw = null;

		File tmp = new File(config.getFilename()+".xsi.stripped");
    	File output = new File(config.getFilename());
		
		try {

			br = new BufferedReader(new FileReader(output));
			if (!tmp.exists()) {
				tmp.createNewFile();
			}
			fw = new FileWriter(tmp);
			bw = new BufferedWriter(fw);
			
			Unix4j.from(br).sed(remove_string_command).sed(reintroduce_string_command).toWriter(bw);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
				if (bw != null)bw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
    	
		Unix4j.fromFile(tmp).toFile(output);
		tmp.deleteOnExit();
    	
	}
}
