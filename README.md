### 文件切割和合并
#### 文件切割  

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

  

####  文件合并  
-   普通文件合并

  ```java
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
  ```

- ​合并文件列表    


设想：  将几个不相关的文件合并到一起

代码：

```java
   /**
     *
     * @param arrayList
     * @param filePath
     * @throws IOException
     */
    public static void specifyFileNameToMerge(ArrayList<String> arrayList,String filePath) throws IOException {
        FileOutputStream fos = new FileOutputStream(filePath);
        for (int i = 0; i < arrayList.size(); i++) {
            FileInputStream fis = new FileInputStream(arrayList.get(i));
            byte[] bs =new byte[10000];
            int total=0;
            while ((total=fis.read(bs))!=-1){
                fos.write(bs, 0, total);

            }
            System.out.println(arrayList.get(i));
            fis.close();
        }
        fos.close();
        System.out.println("合并成功！！");
    }
```