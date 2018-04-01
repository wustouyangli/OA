package com.utils;

import java.io.File;
import java.util.UUID;

public class FileTools {
	public static final String SavePath = "C:\\E\\upload";
	
	public static String makeFileName(String filename) {
        //Ϊ��ֹ�ļ����ǵ���������ҪΪ�ϴ��ļ�����һ��Ψһ���ļ���
        return UUID.randomUUID().toString() + "_" + filename;
    }
	
	public static String makePath(String filename, String savePath){
        //�õ��ļ�����hashCode��ֵ���õ��ľ���filename����ַ����������ڴ��еĵ�ַ
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
