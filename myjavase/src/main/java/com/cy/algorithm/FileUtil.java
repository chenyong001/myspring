package com.cy.algorithm;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

//            4、实现一个函数，接受入参String filePath，返回该目录整个目录下所有的图片格式的文件名称
//    List<String> getPicName(String filePath)

    public static void main(String[] args) {
        String filePath = "E:\\test";
        List<String> picName = new FileUtil().getPicName(filePath);
        picName.forEach(System.out::println);
    }
    List<String> fileList = new ArrayList<>();
    /**
     * 递归查找
     * @param filePath
     * @return
     */
    public List<String> getPicName(String filePath) {

        File file = new File(filePath);
        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.isFile()) {
                String name = file1.getName();
//            检查图片格式的文件
                if (name.substring(name.lastIndexOf(".")).equalsIgnoreCase(".png")
                        || name.substring(name.lastIndexOf(".")).equalsIgnoreCase(".jpg")) {
                    fileList.add(name);
                }

            }
            if (file1.isDirectory()) {
                return getPicName(file1.getAbsolutePath());
            }
        }

        return fileList;
    }




}
