package LiveTvRecording;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigFile 
{
    Properties property;
    String path="C:\\EclipseLatest\\sliketm\\src\\test\\java\\LiveTvRecording\\config.properties";
    
    public ReadConfigFile() 
    {
    	property = new Properties();
    	try {
			FileInputStream fis = new FileInputStream(path);
			try {
				property.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    }
   
    public String getURL() 
    {
    	String url = property.getProperty("url");
    	if(url!=null)
    	return url;
    	else throw new RuntimeException ("url not specified configuration");
    	
    }
    
    public String getUN()
    {
    	String un = property.getProperty("email");
    	if(un!=null)
    	return un;
    	else throw new RuntimeException("Un not specified configuration");
    }
    
    public String getPWD()
    {
    	String pwd = property.getProperty("password");
    	if(pwd!=null)
        return pwd;
    	else throw new RuntimeException("Un not specified configuration");
    }


	}
    
    
    
    

