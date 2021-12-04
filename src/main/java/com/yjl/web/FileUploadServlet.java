package com.yjl.web;

import com.yjl.utils.UUIDUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @program: JavaWeb-Edu
 * @author: yjl
 * @created: 2021/12/04
 */
@WebServlet("/upload")
public class FileUploadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.创建磁盘文件工厂对象
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //2.创建文件上传核心类
        ServletFileUpload upload = new ServletFileUpload(factory);
        //2.1 设置上传文件的编码
        upload.setHeaderEncoding("utf-8");
        //2.2 判断表单是否是 文件上传表单
        boolean multipartContent = ServletFileUpload.isMultipartContent(req);
        //2.3 是文件上传表单
        if (multipartContent) {
            //3.解析request -- 获取表单项的集合
            try {
                List<FileItem> list = upload.parseRequest(req);
                if (null != list) {
                    //4.遍历集合 获取表单项
                    for (FileItem item : list) {
                        //5.判断当前表单项 是不是普通表单项
                        boolean formField = item.isFormField();
                        if (formField) {
                            //普通表单项
                            String fieldName = item.getFieldName();
                            //设置编码
                            String fieldValue = item.getString("utf-8");
                            System.out.println(fieldName + " = " + fieldValue);
                        } else {
                            //文件上传项
                            //获取文件名
                            String fileName = item.getName();

                            //拼接新的文件名 使用UUID保证不重复
                            String newFileName = UUIDUtils.getUUID() + "_" + fileName;

                            //获取输入流
                            InputStream in = item.getInputStream();

                            //创建输出流
                            //1.获取项目的运行目录 H:\software\apache-tomcat-8.5.55\webapps\lagou_edu_home\
                            String realPath = this.getServletContext().getRealPath("/");

                            //2.截取到 webapps目录路径
                            String wabappsPath = realPath.substring(0, realPath.indexOf("lagou_edu_home"));

                            //3.拼接输出路径,将图片保存到 upload
                            FileOutputStream out = new FileOutputStream(wabappsPath + "/upload/" + newFileName);

                            //使用IOUtils完成 文件的copy
                            IOUtils.copy(in, out);

                            //关闭流
                            out.close();
                            in.close();
                        }
                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
