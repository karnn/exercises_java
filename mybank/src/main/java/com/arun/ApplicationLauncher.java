package com.arun;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;

public class ApplicationLauncher {

    public static void main(String[] args) throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        String port = System.getProperty("port");
        int portNumber = port == null ? 8000 : Integer.parseInt(port);
        tomcat.setPort(portNumber);
        tomcat.getConnector();

        Context context = tomcat.addContext("", null);
        Wrapper servletClass = Tomcat.addServlet(context, "servletClass", new ServletClass());
        servletClass.setLoadOnStartup(1);
        servletClass.addMapping("/*");
        tomcat.start();
    }
}
