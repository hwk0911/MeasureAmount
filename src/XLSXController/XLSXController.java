package XLSXController;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSXController {
    private List<String> filesPath;
    private List<List<String>> endExport;

    private final int[] orderColumns = {3, 6, 7};
    private final int[] sendColumns = {5, 7, 8};

    public XLSXController(List<String> filePath) {
        this.filesPath = filePath;
        this.endExport = XLSXDataAnalyzer();
    }

    private List<List<String>> XLSXDataAnalyzer () {
        Iterator<String> pathIterator = this.filesPath.iterator();

        List<List<String>> rowDatas = new ArrayList<>();

        while(pathIterator.hasNext()) {
            try{
                String filePath = pathIterator.next();
                FileInputStream fileInputStream = new FileInputStream(filePath);
                XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

                int[] columns;
                int sheetNum;

                if(filePath.contains("발주")) {
                    columns = this.orderColumns.clone();
                    sheetNum = 0;
                }
                else if(filePath.contains("발송")) {
                    columns = this.sendColumns.clone();
                    sheetNum = 1;
                }
                else {
                    continue;
                }

                XSSFSheet sheet = workbook.getSheetAt(sheetNum);
                int maxRow = sheet.getPhysicalNumberOfRows();

                for(int rowNum = 0 ; rowNum < maxRow ; ++rowNum) {
                    List<String> rowData = new ArrayList<>();
                    XSSFRow row = sheet.getRow(rowNum);

                    for(int index = 0, size = columns.length ; index < size ; ++index) {
                        XSSFCell cell = row.getCell(columns[index]);
                        try {
                            switch (cell.getCellType()) {
                                case XSSFCell.CELL_TYPE_FORMULA:
                                    rowData.add(cell.getCellFormula());
                                    break;

                                case XSSFCell.CELL_TYPE_NUMERIC:
                                    rowData.add(cell.getNumericCellValue() + "");
                                    break;

                                case XSSFCell.CELL_TYPE_STRING:
                                    rowData.add(cell.getStringCellValue() + "");
                                    break;

                                case XSSFCell.CELL_TYPE_BLANK:
                                    rowData.add(cell.getBooleanCellValue() + "");
                                    break;

                                case XSSFCell.CELL_TYPE_ERROR:
                                    rowData.add(cell.getErrorCellValue() + "");
                                    break;
                            }
                        }
                        catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    rowDatas.add(rowData);
                }

            }
            catch (FileNotFoundException e) {
                System.out.println("log : " + e.getMessage());
            }
            catch (IOException e) {
                System.out.println("log : " + e.getMessage());
            }
        }

        return rowDatas;
    }

    public List<List<String>> getEndExport () {
        return this.endExport;
    }
}