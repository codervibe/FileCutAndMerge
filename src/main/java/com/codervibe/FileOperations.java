package com.codervibe;
/*
 * Created by Administrator on 2021/3/8  0008
 * DateTime:2021/03/08 16:31
 * Description:fileOperationClass
 * Others:
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Administrator
 */
public class FileOperations {
    public static void fileCut(String filePath) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        byte[] ba =new byte[1024*1024];
        int total= 0;
        int count = 0;
        while((total=fis.read(ba))!=-1){
            FileOutputStream fos = new FileOutputStream("第"+(++count)+"个.txt");
            fos.write(ba, 0, total);
            fos.close();
        }
        //specify
        fis.close();
        System.out.println("分割成功！！");
    }
    public static void fileMerge(String filePath) throws IOException {
        FileOutputStream fos = new FileOutputStream(filePath);
        for (int i = 0; i < 8; i++) {
            FileInputStream fis = new FileInputStream("第"+(i+1)+"个");
            byte[] bs =new byte[10000];
            int total=0;
            while ((total=fis.read(bs))!=-1){
                fos.write(bs, 0, total);

            }
            fis.close();
        }
        fos.close();
        System.out.println("合并成功！！");
    }
}
