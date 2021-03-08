package com.codervibe;
/*
 * Created by Administrator on 2021/3/8  0008
 * DateTime:2021/03/08 16:31
 * Description:fileOperationClass
 * Others:
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Administrator
 */
public class FileOperations {
    /**
     * 文件切割
     * @param filePath
     * @throws IOException
     */

    public static void fileCut(String filePath) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        /**
         * 1024*1024=每个文件的大小为1MB
         * 1024*1024*1024=每个文件大小为1GB
         * 1024*1024*1024*1024=每个文件大小为1TB
         */
        byte[] ba =new byte[1024*1024];
        int total= 0;
        int count = 0;
        while((total=fis.read(ba))!=-1){
            FileOutputStream fos = new FileOutputStream("第"+(++count)+"个.mp3");
            fos.write(ba, 0, total);
            fos.close();
        }
        //specify
        fis.close();
        System.out.println("分割成功！！");
    }

    /**
     * 按文件大小均匀切割
     * @param filePath  文件路径
     * @param numberOfDocuments   文件要平局分割成几份
     * @throws IOException
     */
    public static void cutEvenlyByFileSize(String filePath,int numberOfDocuments) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        File file = new File(filePath);
        long averageFileSize=(file.length()/numberOfDocuments);
        byte[] ba =new byte[(int) averageFileSize];
        int total= 0;
        int count = 0;
        while((total=fis.read(ba))!=-1){
            FileOutputStream fos = new FileOutputStream("第"+(++count)+"个.mp3");
            fos.write(ba, 0, total);
            fos.close();
        }
        //specify
        fis.close();
        System.out.println("平均分割成功！！");
    }

    /**
     * 文件合并
     * @param filePath
     * @throws IOException
     */
    public static void fileMerge(String filePath,int numberOfMergedFiles) throws IOException {
        FileOutputStream fos = new FileOutputStream(filePath);
        for (int i = 0; i < numberOfMergedFiles; i++) {
            FileInputStream fis = new FileInputStream("第"+(i+1)+"个.mp3");
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
