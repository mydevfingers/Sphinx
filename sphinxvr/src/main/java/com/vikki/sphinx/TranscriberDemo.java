package com.vikki.sphinx;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.result.WordResult;

public class TranscriberDemo {       
                                     
    public static void main(String[] args) throws Exception {

        Configuration configuration = new Configuration();

        configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
        configuration.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");

	    LiveSpeechRecognizer recognizer = new LiveSpeechRecognizer(configuration);
	    System.out.println("Starting recognizer...");
		recognizer.startRecognition(true);
	    SpeechResult result;
	    while ((result = recognizer.getResult()) != null) 
	    {
		    System.out.format("Hypothesis: %s\n", result.getHypothesis());
		    
		    // Get individual words and their times.
//		    for (WordResult r : result.getWords()) 
//		    {
//		        System.out.println(r);
//		    }    
	    }    
	    System.out.println("Stopping recognizer...");
		recognizer.stopRecognition();
    
    
    
//    result = recognizer.getResult();
//    System.out.println(result.getHypothesis());
//	recognizer.stopRecognition();
    }
}
