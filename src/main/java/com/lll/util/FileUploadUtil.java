package com.lll.util;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;



public class FileUploadUtil extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			FileUploadException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String fileName = "";
		try {
            String code=request.getParameter("code");
        	String[] reqsa = code.split("\\|");
    		String finalCode=reqsa[0].toString();
    		String pathName=reqsa[1].toString();
            // 实例化一个硬盘文件工厂,用来配置上传组件ServletFileUpload
			DiskFileItemFactory factory = new DiskFileItemFactory();

			//创建一个fileUpload 句柄
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setHeaderEncoding("utf-8");


			// 解析 request请求
			List<FileItem> items = upload.parseRequest(request);
			
			// 取得对象进行迭代
			Iterator<FileItem> e = items.iterator();
			while (e.hasNext()) {
				FileItem fileItem = (FileItem)e.next();
				fileName = fileItem.getName();
				if (fileName == null || (fileName.trim()).equals("")) {
					continue;
				}
				String strFormatDate=DateUtils.format(new Date(), "yyyyMMddHHmmssSSSS");
				//取得服务器的根目录
				String serverRooPath=InitSetupListener.rootPath;
				//文件名,此文件名不包括路径信息和后缀
			    String simpleFileName=fileName.substring(0,fileName.lastIndexOf("."));
				//文件后缀名 如 doc,txt
				String fileSuffix=fileName.substring(fileName.lastIndexOf("."),fileName.length());
				//省分 路径
				String strProvincePath=serverRooPath+"upload"+File.separator+finalCode+File.separator;
		        File provincePath=new File(strProvincePath);
		        //如果省分文件夹没有，就创建此文件夹
		        if(!provincePath.exists()){
 			    	provincePath.mkdir();
				}
		        //最终文件上传的路径 
		        String strFinalUploadPath=serverRooPath+"upload"+File.separator+finalCode+File.separator+pathName+File.separator;
		        System.out.println("finalUploadPath:"+strFinalUploadPath);
		        File finalFileUploadPath=new File(strFinalUploadPath);
				//如果此文件夹不存在，就创建此文件夹
 			    if(!finalFileUploadPath.exists()){
 			    	finalFileUploadPath.mkdir();
				}
 			    //对文件名进行编码
 			    String convertSimpleFileName=new String(simpleFileName.getBytes("UTF-8"),"UTF-8");
 			    //要生成的完整文件路径名
				String strFinalFile=serverRooPath+"upload"+File.separator+finalCode+File.separator+pathName+File.separator+convertSimpleFileName+strFormatDate+fileSuffix;
				System.out.println("最终文件名"+strFinalFile);
				File   finalFile=new File(strFinalFile);
				//如果此文件存在，删除这个文件(加上时间戳后，文件重名几乎不可能)
				if(finalFile.exists()){
 			    	finalFile.delete();
 			    }
				//写入磁盘
				fileItem.write(finalFile);
				response.getWriter().print(strFinalFile);
		        //ServletUtils.renderJson(response, "success");
			}
		} catch (FileUploadException e) {

			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			out.close();
		}
	}
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		try {
			processRequest(arg0, arg1);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
