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
        FileOperations.cutEvenlyByFileSize("冥王.mp3",3);
    }
    @Test
    public void MergeTest() throws IOException {
        ArrayList<String> arrayList=new ArrayList<String>();
        arrayList.add("冥王.mp3");
        arrayList.add("纳米核心.mp3");
        FileOperations.specifyFileNameToMerge(arrayList,"./合并.mp3");
    }

}
