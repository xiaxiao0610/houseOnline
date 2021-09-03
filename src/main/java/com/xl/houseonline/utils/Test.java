package com.xl.houseonline.utils;

import java.io.File;

public class Test {
    public static void main(String[] args) {
        //1.创建文件
        File file = new File("http://localhost:8080/upload/2021/07/04/949d0acc-2f87-4711-972a-e0923e25a3de.png");
        //2.调用方法，传入要在服务器上保存的目录及文件名    和  文件
        TencentUploadUtil.uploadFile("xlmall/images/949d0acc-2f87-4711-972a-e0923e25a3de.png",file);
    }
}