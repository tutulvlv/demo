package com.xdailiao.utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

public class Upload {
	public static String uploadImage(HttpServletRequest request,MultipartFile file ,long date) throws IOException{
			String path=null;
//			String root = request.getRealPath("images/upload");
            if(file != null){  
                //取得当前上传文件的文件名称  
                String myFileName = file.getOriginalFilename();  
                //如果名称不为“”,且以xls/xlsx 结尾 说明该文件可用，否则说明该文件不可处理  
                    //重命名上传后的文件名  
                    String fileName = date+"_"+file.getOriginalFilename();  
                    //定义上传路径   先依照ip创建子文件夹   后期依照用户名    创建子文件夹
                    File temp = new File("d:/images/upload");
                    System.out.println("创建的路径"+temp.getAbsolutePath());
//                    if (!temp.getParentFile().exists()) {
//                        temp.getParentFile().mkdir();
//                    }
//                    if (!temp.exists()) {
//                        temp.mkdir();
//                    }
//                    file.transferTo(temp);

                    path = "d:/images/upload"+"/" + fileName;  
                    System.out.println("最终的文件路径"+path);
                    File localFile = new File(path);
                    //=========================================>>>先抛出异常   完成后catch
                    try {
						file.transferTo(localFile);
					} catch (IllegalStateException e) {
						System.out.println("文件写入出现异常 ");
						e.printStackTrace();
					} catch (IOException e) {
						System.out.println("文件写入出现异常  IO");
						e.printStackTrace();
					}
                    return path;
                }
			return path;  
	}
}
