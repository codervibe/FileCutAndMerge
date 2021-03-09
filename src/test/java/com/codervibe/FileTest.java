package com.codervibe;
/*
 * Created by Administrator on 2021/3/8 0008
 * DateTime:2021/03/08 16:43
 * Description:
 * Others:
 */

import org.junit.Test;
import java.io.IOException;
import java.util.ArrayList;

public class FileTest {
    @Test
    public void cutTest() throws IOException {
//        FileOperations.cutEvenlyByFileSize("冥王.mp3",3);
//        FileOperations.fileMerge("145482549546456.mp3",2);
        FileOperations.cutEvenlyByFileSize("合并.mp3",4);
    }

    @Test
    public void MergeTest() throws IOException {
        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add("冥王.mp3");
        arrayList.add("纳米核心.mp3");
        arrayList.add("合并.mp3");
        FileOperations.specifyAListOfFilesToBeMerged(arrayList,"./合并2.mp3");
//        FileOperations.fileMerge("合并.mp3",5);
    }
    @Test
    public void MergePassWord() throws IOException {
        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add("J:\\ZAI\\20200215\\pwd\\common.txt");
        arrayList.add("J:\\ZAI\\20200215\\pwd\\common_pass.txt");
        arrayList.add("J:\\ZAI\\20200215\\pwd\\MyDict.txt");
        arrayList.add("J:\\ZAI\\20200215\\pwd\\names.txt");
        FileOperations.specifyAListOfFilesToBeMerged(arrayList,"./password.txt");

    }
}
