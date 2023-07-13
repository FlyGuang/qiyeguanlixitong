package com.hs.util;

import org.junit.Test;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;

public class UploadFile {

    public static String uploadfile(CommonsMultipartFile file){
        String newPath="";
        String path="";
        try {
            String newName=File.separator+createName(file.getOriginalFilename());
            newPath="D:"+ File.separator+"dir"+newName;
            File newFile=new File(newPath);
            file.transferTo(newFile);
            path="http:"+File.separator+File.separator+File.separator+File.separator+"localhost:8080"+File.separator+File.separator+"dir"+File.separator+ newName;
            System.out.println(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }
    private static String createName(String originalFilename) {
        return System.currentTimeMillis()+(int)(Math.random()*100000+1)+originalFilename.substring(originalFilename.indexOf("."));
    }


    public static boolean checkPdf(String str){
        if (str.endsWith(".pdf")){
            return true;
        }else {
            return false;
        }
    }

    @Test
    public void checkPdf(){
        String s = "123454.p1df";
        System.out.println(checkPdf(s));
    }

    public static boolean checkMag(String str){
        if (str.endsWith(".jpg")||str.endsWith(".png")||str.endsWith(".jpeg")){
            return true;
        }else {
            return false;
        }
    }

    @Test
    public void checkMag(){
        String s = "123454.jpg";
        System.out.println(checkMag(s));
    }

}
