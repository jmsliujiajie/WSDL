package com.lll.util;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFComment;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

import com.google.common.collect.Lists;


/**
 * 利用开源组件POI3.0.2动态导出EXCEL文档 转载时请保留以下信息，注明出处！
 * 
 * @author leno
 * @version v1.0
 * @param <T>
 *            应用泛型，代表任意一个符合javabean风格的类
 *            注意这里为了简单起见，boolean型的属性xxx的get器方式为getXxx(),而不是isXxx()
 *            byte[]表jpg格式的图片数据
 */
public class ExportExcel {

    public HSSFWorkbook exportExcel(List<Map<String, Object>> dataset, String []keys) {
    	return exportExcel("测试POI导出EXCEL文档", null, dataset, keys, "yyyy-MM-dd");
    }

    public HSSFWorkbook exportExcel(String[] headers, List<Map<String, Object>> dataset,String []keys) {
        return exportExcel("测试POI导出EXCEL文档", headers, dataset,keys, "yyyy-MM-dd");
    }

    public HSSFWorkbook exportExcel(String[] headers, List<Map<String, Object>> dataset, String pattern,String []keys) {
    	return exportExcel("测试POI导出EXCEL文档", headers, dataset,keys, pattern);
    }

    /**
     * 这是一个通用的方法，利用了JAVA的反射机制，可以将放置在JAVA集合中并且符号一定条件的数据以EXCEL 的形式输出到指定IO设备上
     * 
     * @param title
     *            表格标题名
     * @param headers
     *            表格属性列名数组
     * @param dataset
     *            需要显示的数据集合,集合中一定要放置符合javabean风格的类的对象。此方法支持的
     *            javabean属性的数据类型有基本数据类型及String,Date,byte[](图片数据)
     * @param out
     *            与输出设备关联的流对象，可以将EXCEL文档导出到本地文件或者网络中
     * @param pattern
     *            如果有时间数据，设定输出格式。默认为"yyy-MM-dd"
     */
    @SuppressWarnings("deprecation")
    public HSSFWorkbook exportExcel(String title, String[] headers,
            List<Map<String, Object>> maps,String []keys, String pattern) {
        // 声明一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 生成一个表格
        HSSFSheet sheet = workbook.createSheet(title);
        // 设置表格默认列宽度为15个字节
        sheet.setDefaultColumnWidth((short) 15);
        // 生成一个样式
        HSSFCellStyle style = workbook.createCellStyle();
        // 设置这些样式
        style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 生成一个字体
        HSSFFont font = workbook.createFont();
        font.setColor(HSSFColor.VIOLET.index);
        font.setFontHeightInPoints((short) 12);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        // 把字体应用到当前的样式
        style.setFont(font);
        // 生成并设置另一个样式
        HSSFCellStyle style2 = workbook.createCellStyle();
        style2.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
        style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        // 生成另一个字体
        HSSFFont font2 = workbook.createFont();
        font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
        // 把字体应用到当前的样式
        style2.setFont(font2);

        // 声明一个画图的顶级管理器
        HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
        // 定义注释的大小和位置,详见文档
        HSSFComment comment = patriarch.createComment(new HSSFClientAnchor(0,
                0, 0, 0, (short) 4, 2, (short) 6, 5));
        // 设置注释内容
        comment.setString(new HSSFRichTextString("si-tech"));
        // 设置注释作者，当鼠标移动到单元格上是可以在状态栏中看到该内容.
        comment.setAuthor("si-tech");

        // 产生表格标题行
        HSSFRow row = sheet.createRow(0);
        for (short i = 0; i < headers.length; i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellStyle(style);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }

        // 遍历集合数据，产生数据行
        int index = 0;
        for (Map<String, Object> map: maps) {
        	index++;
            row = sheet.createRow(index);
            
            for (int i = 0; i < keys.length; i++) {
            	HSSFCell cell = row.createCell(i);
                cell.setCellStyle(style2);
                
                String textValue = (String)map.get(keys[i]);
                
                if (textValue != null) {
                    Pattern p = Pattern.compile("^//d+(//.//d+)?{1}quot;");
                    Matcher matcher = p.matcher(textValue);
                    if (matcher.matches()) {
                        // 是数字当作double处理
                        cell.setCellValue(Double.parseDouble(textValue));
                    } else {
                        HSSFRichTextString richString = new HSSFRichTextString(
                                textValue);
                        HSSFFont font3 = workbook.createFont();
                        font3.setColor(HSSFColor.BLUE.index);
                        richString.applyFont(font3);
                        cell.setCellValue(richString);
                    }
                }
            }
        }
        
        return workbook;
    }

    public static void main(String[] args) {
        ExportExcel ex2 = new ExportExcel();
        String[] headers2 = { "学号2", "姓名2", "年龄2", "性别2", "出生日期2" };
        List<Map<String,Object>> maps = Lists.newArrayList();
        
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("id", "10000001");
        map.put("name", "张三");
        map.put("three", "阿萨德2");
        map.put("four", "阿萨德3");
        map.put("five", "阿萨德12");
        maps.add(map);
        
        Map<String,Object> map2 = new HashMap<String, Object>();
        map2.put("id", "10000001");
        map2.put("name", "张三");
        map2.put("three", "阿萨德2");
        map2.put("four", "阿萨德3");
        map2.put("five", "阿萨德12");
        maps.add(map2);
        
        String[] keys = { "id", "name", "three", "four", "five"};
        
        try {
           
            OutputStream out = new FileOutputStream("E://a.xls");
            HSSFWorkbook workBook = ex2.exportExcel(headers2, maps, keys );
            workBook.write(out);
            out.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
}
