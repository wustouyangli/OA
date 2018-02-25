package com.image;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;


public class SecurityImage {
	private static BufferedImage getSecurityImage(String code){
		int codeLength = code.length();  
        // 字体大小  
        int fSize = 18;  
        int fWidth = fSize + 1;  
        // 图片宽度  
        int width = codeLength * fWidth + 20;  
        // 图片高度  
        int height = fSize * 2 + 10;
		BufferedImage image = new BufferedImage(width, height,  
                BufferedImage.TYPE_INT_RGB); 
		Graphics g = image.createGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		// 设置边框颜色  
        g.setColor(Color.DARK_GRAY);  
        // 边框字体样式  
        g.setFont(new Font("Arial", Font.BOLD, height - 2));
        // 绘制边框  
        g.drawRect(0, 0, width - 1, height - 1);
        // 绘制小圆点
        for (int i = 0; i < codeLength*6; i++){
        	int x = (int)(Math.random() * width);
        	int y = (int)(Math.random() * height);
        	int red = (int)(Math.random() * 255);
        	int green = (int)(Math.random() * 255);
        	int blue = (int)(Math.random() * 255);
        	g.setColor(new Color(red, green, blue));
        	//g.drawOval(x, y, 10, 0);
        	g.drawOval(x, y, 3, 3);
        	
        }
        
        int codeY = 2* height / 3;  
        // 设置字体颜色和样式  
        g.setColor(new Color(0, 0, 153));  
        g.setFont(new Font("Georgia", Font.BOLD, fSize));
        for (int i = 0; i < codeLength; i++) { 
        	g.drawString(String.valueOf(code.charAt(i)), i*20+10,  codeY); 
        }
        g.dispose();  
        
        return image;
	}
	
	public static ByteArrayInputStream getImageAsInputStream(String code) throws IOException { 
        return convertImageToStream(getSecurityImage(code));  
    }
	
	private static ByteArrayInputStream convertImageToStream(BufferedImage image) throws IOException {  
	       
		ByteArrayInputStream inputStream = null;  
        ByteArrayOutputStream bos = new ByteArrayOutputStream();  
        ImageIO.write(image, "JPEG", bos);
        byte[] bts = bos.toByteArray();  
        inputStream = new ByteArrayInputStream(bts);  
        bos.close();
        return inputStream; 
     }
}
