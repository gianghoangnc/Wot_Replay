package abc;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class WriteExcel {

	public void Write(List<Vehicle> listVehicle,String fileName) throws IOException {
		HSSFWorkbook workbook = new HSSFWorkbook();

		//
		// Create two sheets in the excel document and name it First Sheet and
		// Second Sheet.
		//
		HSSFSheet firstSheet = workbook.createSheet("FIRST SHEET");

		//
		// Manipulate the firs sheet by creating an HSSFRow wich represent a
		// single row in excel sheet, the first row started from 0 index. After
		// the row is created we create a HSSFCell in this first cell of the row
		// and set the cell value with an instance of HSSFRichTextString
		// containing the words FIRST SHEET.
		//
		// Row Header
		HSSFRow rowHeader = firstSheet.createRow(0);
		HSSFCell cellA1 = rowHeader.createCell(0);
		cellA1.setCellValue(new HSSFRichTextString("Clan"));

		HSSFCell cellB1 = rowHeader.createCell(1);
		cellB1.setCellValue(new HSSFRichTextString("Event"));

		HSSFCell cellC1 = rowHeader.createCell(2);
		cellC1.setCellValue(new HSSFRichTextString("igrType"));

		HSSFCell cellD1 = rowHeader.createCell(3);
		cellD1.setCellValue(new HSSFRichTextString("isAlive"));

		HSSFCell cellE1 = rowHeader.createCell(4);
		cellE1.setCellValue(new HSSFRichTextString("isTeamKiller"));

		HSSFCell cellG1 = rowHeader.createCell(5);
		cellG1.setCellValue(new HSSFRichTextString("name"));

		HSSFCell cellH1 = rowHeader.createCell(6);
		cellH1.setCellValue(new HSSFRichTextString("team"));

		HSSFCell cellI1 = rowHeader.createCell(7);
		cellI1.setCellValue(new HSSFRichTextString("vehicleType"));
		
		for(int i = 0; i < listVehicle.size(); i++){
			Vehicle vehicle = listVehicle.get(i);
			HSSFRow row = firstSheet.createRow(i+1);
			HSSFCell cellA2 = row.createCell(0);
			cellA2.setCellValue(new HSSFRichTextString(vehicle.getClanAbbrev()));

			HSSFCell cellB2 = row.createCell(1);
			cellB2.setCellValue(new HSSFRichTextString(
					vehicle.getEvents()));

			HSSFCell cellC2 = row.createCell(2);
			cellC2.setCellValue(new HSSFRichTextString(vehicle.getIgrType()));

			HSSFCell cellD2 = row.createCell(3);
			cellD2.setCellValue(new HSSFRichTextString(vehicle.getIsAlive()));

			HSSFCell cellE2 = row.createCell(4);
			cellE2.setCellValue(new HSSFRichTextString(vehicle.getIsTeamKiller()));

			HSSFCell cellG2 = row.createCell(5);
			cellG2.setCellValue(new HSSFRichTextString(vehicle.getName()));

			HSSFCell cellH2 = row.createCell(6);
			cellH2.setCellValue(new HSSFRichTextString(vehicle.getTeam()));

			HSSFCell cellI2 = row.createCell(7);
			cellI2.setCellValue(new HSSFRichTextString(vehicle.getVehicleType()));
		}

		FileOutputStream fileOut = new FileOutputStream("dist"+File.separator+fileName+".xls");
		workbook.write(fileOut);
        fileOut.close();
	}
}
