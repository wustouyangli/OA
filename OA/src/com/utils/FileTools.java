package com.utils;

import java.io.File;
import java.util.UUID;

public class FileTools {
	public static final String SavePath = "C:\\E\\upload";
	
	public static String makeFileName(String filename) {
        //为防止文件覆盖的现象发生，要为上传文件产生一个唯一的文件名
        return UUID.randomUUID().toString() + "_" + filename;
    }
	
	public static String makePath(String filename, String savePath){
        //得到文件名的hashCode的值，得到的就是filename这个字符串对象在内存中的地址
        int hashcode = filename.hashCode();
        int dir1 = hashcode&0xf;  
        int dir2 = (hashcode&0xf0)>>4;  
        String dir = savePath + "\\" + dir1 + "\\" + dir2;  
        File file = new File(dir);
        if(!file.exists()){   
            file.mkdirs();
        }
        return dir;
    }
	
	public static boolean deleteFile(String path, String filename){
		String absolutePath = path + "\\" + filename;
		File file = new File(absolutePath);
		if (file.exists()){
			file.delete();
			System.out.println("delete: " + absolutePath);
		}
		return !file.exists();
	}
}
