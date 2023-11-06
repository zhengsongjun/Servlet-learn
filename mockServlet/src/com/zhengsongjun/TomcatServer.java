package com.zhengsongjun;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class TomcatServer {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String url = getUserInputUrl();
        Servlet servlet = getServlet(url);
        servlet.Service();
    };


    public static String getUserInputUrl(){
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    };

    public static Servlet getServlet(String url) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        FileReader fileReader = new FileReader("/Users/promise/Desktop/server/servlet/mockServlet/src/com/zhengsongjun/web.properties");
        Properties properties = new Properties();
        properties.load(fileReader);
        fileReader.close();
        String property = properties.getProperty(url);
        Class<?> aClass = Class.forName(property);
        return (Servlet) aClass.newInstance();
    };
}
