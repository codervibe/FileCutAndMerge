### 文件切割和合并
- 文件切割  

  - 按输入的文件份数切割文件  

    ```java
    FileOperations.cutEvenlyByFileSize();
    ```

  - 将文件以MB为单位等分成几份 


    ```java
    FileOperations.fileCut();  
    ```

- 文件切割代码

  ```Java
  
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
       * @param filePath  
       * @param numberOfDocuments   
       * @throws IOException
       */
      public static void cutEvenlyByFileSize(String filePath,int numberOfDocuments) throws IOException {
          FileInputStream fis = new FileInputStream(filePath);
          File file = new File(filePath);
          long averageFileSize=(file.length()/numberOfDocuments);
          byte[] ba =new byte[(int) averageFileSize];
          int total;
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
  
  
  
  ```

  

* 文件合并  
多个输入流，一个输出流

    

