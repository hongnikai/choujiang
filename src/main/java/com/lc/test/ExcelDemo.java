package com.lc.test;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import java.io.File;
public class ExcelDemo {

    public static void main(String[] args) throws Exception{
        Workbook wb = Workbook.getWorkbook(new File("F:\\lc.xls"));
        Sheet sheet = wb.getSheet(0);
        int columns = sheet.getRows();
        for(int i=0;i<columns;i++){
            Cell[] cells = sheet.getRow(i);
            for(Cell cell:cells){
                System.out.print(cell.getContents()+"\t");
            }
            System.out.println("");
        }
    }

}
