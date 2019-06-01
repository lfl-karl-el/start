package com.example.api.utils.FileUtils;

import java.io.File;

/**
 * @program: start-FileCommonUtil
 * @description: 文件操作公共类
 * @author: Mr.lfl
 * @create: 2019-02-25 14:30
 **/
public class FileCommonUtil {
    public static void main(String[] args) {
        delDirectoryNoFile("E://zj-uni-mapp");

    }

    /**
     * 递归删除文件夹里面的文件
     * @param path
     */
    public static void delFile(String path){
        File file = new File(path);
        File[] files = file.listFiles();
        for(int i=0;i<files.length;i++){
            if(files[i].isFile()){
                files[i].delete();
            }
            if(files[i].isDirectory()){
                delFile(files[i].getPath());
            }
        }
    }

    /**
     * 如果文件夹里面没有文件就删除外层文件夹
     * @param path
     */
    public static void delDirectoryNoFile(String path){
        File file = new File(path);
        File[] files = file.listFiles();
        if(files.length > 0){
            for(int i=0;i<files.length;i++){
                if(files[i].isDirectory()){
                    delDirectoryNoFile(files[i].getPath());
                }
            }
        }else{
            file.delete();
        }
    }

    /**
     * 读取文件中的英文单词，分析个数
     */

}
