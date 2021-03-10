package com.bdqn.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//属性配置文件类
public class ConfigManager {
    private  static Properties prop;

   static {
       //
       prop=new Properties();
       InputStream is=ConfigManager.class.getClassLoader().getResourceAsStream("db.properties");
       try {
           prop.load(is);
       } catch (IOException e) {
           e.printStackTrace();
       }

   }
    //跟据屬性的鍵
    public  static  String getProperty(String pan){
        return  prop.getProperty(pan);
    }
}
