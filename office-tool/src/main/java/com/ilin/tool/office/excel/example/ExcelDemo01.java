package com.ilin.tool.office.excel.example;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.ilin.tool.office.excel.listener.ExcelDemo01Listener;
import com.ilin.tool.office.excel.model.DiscountModel;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ExcelDemo01 {
    public static void main(String[] args) {
        // 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
//        // 写法1：
//        String fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx";
//        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
//        EasyExcel.read(fileName, .class, new DemoDataListener()).sheet().doRead();

        // 写法2：
        String fileName = ExcelDemo01.class.getClassLoader().getResource("excel/excel-demo01.xlsx").getPath();
        ExcelReader excelReader = EasyExcel.read(fileName, new ExcelDemo01Listener()).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);
        // 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
        excelReader.finish();
    }
}
