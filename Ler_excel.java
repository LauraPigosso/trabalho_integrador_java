package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

public class Ler_excel {
    public static List<Produto> lendoExcel() throws IOException {

        List<Produto> listaProdutos = new ArrayList<Produto>();

        FileInputStream arquivo = caminho();

        XSSFWorkbook workbook = new XSSFWorkbook(arquivo);

        XSSFSheet sheetareas = workbook.getSheetAt(0);

        for (Row row : sheetareas) {
            Iterator<Cell> cellIterator = row.cellIterator();

            Produto produto = new Produto();
            listaProdutos.add(produto);


            while (cellIterator.hasNext()) {

                Cell cell = cellIterator.next();




                switch (cell.getColumnIndex()) {
                    case 0 -> produto.setNome(cell.getStringCellValue());
                    case 1 -> produto.setPreco(cell.getNumericCellValue());
                }
            }
        }

        // Fecha o arquivo
        arquivo.close();

        // Retorna a lista de produtos lidos do arquivo Excel
        return listaProdutos;
    }

    public static FileInputStream caminho() {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);

                System.out.print("Digite o nome do arquivo que você escolheu lá no python: ");
                String filenome = scanner.nextLine();
                System.out.print("Digite o caminho do arquivo Excel: ");
                String filePath = scanner.nextLine();
                String fileName = filePath + "\\" + filenome;

                System.out.println(fileName);

                FileInputStream arquivo = new FileInputStream(new File(fileName));
                return arquivo;
            } catch (Exception e) {
                System.out.println("Verifique o caminho do arquivo Excel.");
            }
        }
    }
}