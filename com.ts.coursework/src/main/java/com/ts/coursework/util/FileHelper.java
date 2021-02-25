package com.ts.coursework.util;
/**
 * 完成写入文件和读取文件操作
 * @author TS
 *
 */

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

public class FileHelper {
	public final static String indexPath="D:/CourseWork/";
	public final static String exploreWorkFilePath=indexPath+"ExploreWorkFile/";
	public final static String submitWorkFilePath=indexPath+"submitWorkFile/";
	//上传文件(相对于客户端而言)
	/**
	 * 
	 * @param file
	 * @param folderPath
	 * @return 文件的存储名字
	 */
	public static String uploadFile(MultipartFile file ,String folderPath) {
		if (!file.isEmpty()) {
            String saveFileName = createFileName(file);
            File saveFile = new File(folderPath+saveFileName);
            //如果父目录不存在则创建父目录
            if (!saveFile.getParentFile().exists()) {
            	saveFile.getParentFile().mkdirs();
            }
            //开始写入到文件
            try {
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(saveFile));
                out.write(file.getBytes());
                out.flush();
                out.close();
              //前端只需要知道文件名（及存储名字）,数据库中只存储文件的存储名字，补全路径名交给后台负责
                return saveFileName;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return "上传失败,";
            } catch (IOException e) {
                e.printStackTrace();
                return "上传失败,";
            }
        } else {
            return "上传失败，因为文件为空.";
        }
	}
	//下载文件(相对于客户端而言)
	public static void downLoadFile(HttpServletResponse response,String saveName,String folderPath,String name) {
		
		File file=new File(folderPath+saveName);
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			response.setContentType("application/force-download");
			response.addHeader("Content-disposition", "attachment;fileName=" +name);
			OutputStream os = response.getOutputStream();
			byte[] buf = new byte[1024];
			int len = 0;
			while((len = fis.read(buf)) != -1) {
				os.write(buf, 0, len);
			}
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*从磁盘删除文件*/
	public static void delFile(String saveName,String path) {
		File file=new File(path+saveName);
		if(file.exists()) {
			file.delete();
		}
	}
	
	/*根据时间生成文件名*/
	private static String createFileName(MultipartFile file) {
		String name = file.getOriginalFilename();
        StringBuilder sb = new StringBuilder();
        Date date = new Date();
        sb.append(date.getTime());
        sb.append(name.substring(name.indexOf(".")));
        return sb.toString();
	}
}
