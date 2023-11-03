package utilities;

import logManager.LoggerHelper;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.Properties;


public class PropertyReader {
   private static Properties properties;
    private static final  String PROPERTIES_FILE =System.getProperty("user.dir") + "/src/test/resources/global.properties";
    public static String testNGBrowser=null;

    public static void initialize()
    {
        properties= loadProperties();
        for(String key :properties.stringPropertyNames())
        {
            if(System.getProperties().containsKey(key))
            {
                properties.setProperty(key,System.getProperty(key));
            }
        }
    }
   private static Properties  loadProperties()
   {
       Properties properties = new Properties();
       FileInputStream fis = null;
       try {
           fis = new FileInputStream(PROPERTIES_FILE);
           properties.load(fis);
       }catch (IOException e)
       {
           LoggerHelper.logError("Issue in reading properties file "+e.getMessage());
       }
       finally {
          if(fis!=null)
          {
              try {
                  fis.close();
              }catch (Exception e)
              {
                  LoggerHelper.logError("Issue in closing file stream "+e);
              }
          }
       }

       return properties;
   }


   public static String getProperty(String key)
   {
       initialize();
       return  properties.getProperty(key);
   }

   public static String getBrowser()
   {
       return getProperty("browser");
   }

   public static String getProjectURL()
   {
      return getProperty("url");
   }

   public static String getPlateform()
   {
       return getProperty("remote");
   }

   public static String getHubURL()
   {
       return getProperty("hubURL");

   }

   public static void setTestNGBrowser(String browser)
   {
   testNGBrowser=browser;
   }

   public static String getTestNGBrowser()
   {
       if(testNGBrowser!=null)
       {
           return testNGBrowser;
       }
       return null;
   }
}



