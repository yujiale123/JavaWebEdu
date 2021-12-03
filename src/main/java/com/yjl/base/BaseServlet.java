package com.yjl.base;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @program: JavaWeb-Edu
 * @author: yjl
 * @created: 2021/12/02
 */
public class BaseServlet extends HttpServlet {
    /**
     * doGet方法作为调度器，根据功能调度相应的方法
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取参数获取方法名
        String methodName = req.getParameter("methodName");
        //2、判断执行相应的方法
        if (null != methodName) {
            // 3、通过反射方法提升代码的可维护性
            //3.1、获取字节码对象
            Class<? extends BaseServlet> aClass = this.getClass();
            try {
                //3.2、根据传入的方法名获取对应的方法对象
                Method method = aClass.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
                //3.3、调用method方法中的invoke方法
                method.invoke(this, req, resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
