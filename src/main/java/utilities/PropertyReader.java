package utilities;

import logManager.LoggerHelper;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class PropertyReader {
    private Properties properties;
    public static String testNGBrowser=null;
   public  PropertyReader()
   {
       try {
           properties= new Properties();
           FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/global.properties");
           properties.load(fis);
       }catch (IOException e)
       {
           LoggerHelper.logError("Issue in reading properties file "+e.getMessage());
       }
   }

   public  String getProperty(String key)
   {
       return  properties.getProperty(key);
   }

   public String getBrowser()
   {
       return getProperty("browser");
   }

   public String getProjectURL()
   {
      return getProperty("url");
   }

   public String getPlateform()
   {
       return getProperty("remote");
   }

   public String getHubURL()
   {
       return getProperty("hubURL");

   }

   public void setTestNGBrowser(String browser)
   {
   testNGBrowser=browser;
   }

   public String getTestNGBrowser()
   {
       if(testNGBrowser!=null)
       {
           return testNGBrowser;
       }
       return null;
   }

}



