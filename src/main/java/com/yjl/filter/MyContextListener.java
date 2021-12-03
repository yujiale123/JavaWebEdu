package com.yjl.filter;

import com.mysql.jdbc.AbandonedConnectionCleanupThread;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

/**
 * @program: JavaWeb-Edu
 * @author: yjl
 * @created: 2021/12/02
 */
@WebListener
public class MyContextListener implements ServletContextListener {
    /**
     * 监听web容器的启动
     *
     * @param servletContextEvent
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("webServer start");
    }

    /**
     * 监听容器关闭
     */
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        try {
            //取消JDBC驱动注册
            Enumeration<Driver> drivers = DriverManager.getDrivers();
            Driver driver = null;
            while (drivers.hasMoreElements()) {
                driver = DriverManager.getDrivers().nextElement();
                DriverManager.deregisterDriver(driver);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            AbandonedConnectionCleanupThread.shutdown();
            com.mysql.jdbc.AbandonedConnectionCleanupThread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}