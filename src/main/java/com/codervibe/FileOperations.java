package com.codervibe;
/*
 * Created by Administrator on 2021/3/8  0008
 * DateTime:2021/03/08 16:31
 * Description:fileOperationClass
 * Others:
 */

import java.io.*;
import java.util.ArrayList;

/**
 * @author Administrator
 */
public class FileOperations {
    /**
     * 文件切割
     *
     * @param filePath
     * @throws IOException
     */
    public static void fileCut(String filePath) throws IOException {
        String fileName = extractTheFileNameBasedOnThePath(filePath);
        ;
        String fileExtension = extractFileExtensionBasedOnPath(filePath);
        FileInputStream fis = new FileInputStream(filePath);
        /**
         * 1024*1024=每个文件的大小为1MB
         * 1024*1024*1024=每个文件大小为1GB
         * 1024*1024*1024*1024=每个文件大小为1TB
         */
        byte[] ba = new byte[1024 * 1024];
        int total = 0;
        int count = 0;
        while ((total = fis.read(ba)) != -1) {
            FileOutputStream fos = new FileOutputStream(fileName + (++count) + "." + fileExtension);
            fos.write(ba, 0, total);
            fos.close();
        }
        //specify
        fis.close();

    }

    /**
     * 按文件大小均匀切割
     *
     * @param filePath          文件路径
     * @param numberOfDocuments 文件要平局分割成几份
     * @throws IOException
     */
    public static void cutEvenlyByFileSize(String filePath, int numberOfDocuments) throws IOException {
        String fileName = extractTheFileNameBasedOnThePath(filePath);
        ;
        String fileExtension = extractFileExtensionBasedOnPath(filePath);
        FileInputStream fis = new FileInputStream(filePath);
        File file = new File(filePath);
        long averageFileSize = (file.length() / numberOfDocuments);
        byte[] ba = new byte[(int) averageFileSize];
        int total;
        int count = 0;
        while ((total = fis.read(ba)) != -1) {
            FileOutputStream fos = new FileOutputStream(fileName + (++count) + "." + fileExtension);
            fos.write(ba, 0, total);
            fos.close();
        }
        fis.close();

    }

    /**
     * 文件合并
     *
     * @param filePath
     * @throws IOException
     */
    public static void fileMerge(String filePath, int numberOfMergedFiles) throws IOException {
        //文件名
        String fileName = extractTheFileNameBasedOnThePath(filePath);
        //文件扩展名
        String fileExtension = extractFileExtensionBasedOnPath(filePath);
        FileOutputStream fos = new FileOutputStream(filePath);

        for (int i = 0; i < numberOfMergedFiles; i++) {
            System.out.println("fileName+(i+1)+\".\"+fileExtension"+"="+fileName+(i+1)+"."+fileExtension);
            FileInputStream fis = new FileInputStream(fileName + (i + 1) + "." + fileExtension);
            byte[] bs = new byte[10000];
            int total = 0;
            while ((total = fis.read(bs)) != -1) {
                fos.write(bs, 0, total);

            }
            fis.close();
        }
        fos.close();

    }


    /**
     * 指定要合并的文件列表
     *
     * @param arrayList 文件全路径
     * @param filePath  文件导出路径
     * @throws IOException
     */
    public static void specifyAListOfFilesToBeMerged(ArrayList<String> arrayList, String filePath) throws IOException {
        FileOutputStream fos = new FileOutputStream(filePath);
        for (int i = 0; i < arrayList.size(); i++) {
            FileInputStream fis = new FileInputStream(arrayList.get(i));
            byte[] bs = new byte[10000];
            int total = 0;
            while ((total = fis.read(bs)) != -1) {
                fos.write(bs, 0, total);

            }
            fis.close();
        }
        fos.close();

    }


    /**
     * 根据路径提取文件名
     *
     * @param filePath
     */
    public static String extractTheFileNameBasedOnThePath(String filePath) {
        String[] a = filePath.split("\\.");
        String fileName = a[0] + "";
        return fileName;
    }

    /**
     * 基于路径提取文件扩展名
     *
     * @param filePath
     * @return
     */
    public static String extractFileExtensionBasedOnPath(String filePath) {
        String[] a = filePath.split("\\.");
        String fileExtension = a[1] + "";
        return fileExtension;
    }

}
