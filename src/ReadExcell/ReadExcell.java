package ReadExcell;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Calculator.Calculator;
import GUI.GUI;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcell {
    private String route;

    public ReadExcell(String route) throws Exception {
        this.route = route;
    }

    public List<Integer> setColumns(XSSFWorkbook workbook) {
        List<Integer> columns = new ArrayList<>();

        int columnIndex = 0;

        XSSFSheet sheet = workbook.getSheetAt(0);

        XSSFRow row = sheet.getRow(0);

        if (row != null) {
            int cells = row.getPhysicalNumberOfCells();

            for (columnIndex = 0; columnIndex <= cells; ++columnIndex) {
                XSSFCell cell = row.getCell(columnIndex);
                String value = "";

                if (cell == null) {
                    continue;
                }
                else if(cell.getStringCellValue().equals("상품명")){
                    columns.add(columnIndex);
                }
                else if(cell.getStringCellValue().equals("옵션 정보")){
                    columns.add(columnIndex);
                }
                else if(cell.getStringCellValue().equals("수량")){
                    columns.add(columnIndex);
                }
            }
        }

        for(int index = 0, size = columns.size() ; index < size ; ++index) {
            System.out.println(columns.get(index));
        }

        System.out.println();

        return columns;
    }

    public HashMap<String, HashMap<String, Double>> getData() throws Exception {
        FileInputStream fileInputStream = new FileInputStream(route);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        List<String> datas = new ArrayList<>();
        String data = "";

        int rowIndex = 0;

        XSSFSheet sheet = workbook.getSheetAt(0);

        int rows = sheet.getPhysicalNumberOfRows();

        List<Integer> columns = setColumns(workbook);

        for (rowIndex = 1; rowIndex < rows; ++rowIndex) {
            XSSFRow row = sheet.getRow(rowIndex);

            data = "";

            if (row != null) {
                for (int index = 0, size = columns.size() ; index < size ; ++index) {
                    XSSFCell cell = row.getCell(columns.get(index));

                    if (cell == null) {
                        continue;
                    } else {
                        switch (cell.getCellType()) {
                            case XSSFCell.CELL_TYPE_FORMULA:
                                data += cell.getCellFormula();
                                break;

                            case XSSFCell.CELL_TYPE_NUMERIC:
                                data += cell.getNumericCellValue() + "";
                                break;

                            case XSSFCell.CELL_TYPE_STRING:
                                data += cell.getStringCellValue() + "";
                                break;

                            case XSSFCell.CELL_TYPE_BLANK:
                                data += cell.getBooleanCellValue() + "";
                                break;

                            case XSSFCell.CELL_TYPE_ERROR:
                                data += cell.getErrorCellValue() + "";
                                break;
                        }
                    }
                    data += "KHWKHW";
                }
                System.out.println("data : " + data);
                datas.add(data);
            }
        }

        Calculator calculator = new Calculator();
        return calculator.dataManufacture(datas);
    }
}

/*
상품명
옵션 정보
수량

 */