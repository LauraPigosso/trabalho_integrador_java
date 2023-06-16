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

        // Cria uma lista vazia para armazenar os produtos
        List<Produto> listaProdutos = new ArrayList<Produto>();

        // Pega o caminho do arquivo Excel
        FileInputStream arquivo = caminho();

        // Cria uma instância do workbook a partir do arquivo Excel
        XSSFWorkbook workbook = new XSSFWorkbook(arquivo);

        // Pega a primeira planilha do workbook
        XSSFSheet sheetareas = workbook.getSheetAt(0);

        // Percorre cada linha da planilha
        for (Row row : sheetareas) {
            // Cria um iterador para percorrer as células de cada linha
            Iterator<Cell> cellIterator = row.cellIterator();

            // Cria um novo objeto Produto para cada linha
            Produto produto = new Produto();
            listaProdutos.add(produto);

            // Percorre cada célula da linha
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();

                // Lê o valor da célula e atribui ao produto de acordo com a coluna
                switch (cell.getColumnIndex()) {
                    case 0 -> produto.setNome(cell.getStringCellValue());
                    case 1 -> produto.setPreco(cell.getNumericCellValue());
                }
            }
        }

        // Fecha o arquivo
        arquivo.close();

        // devolve a lista de produtos lidos do arquivo Excel
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


                FileInputStream arquivo = new FileInputStream(new File(fileName));
                return arquivo;
            } catch (Exception e) {         // se estiver errado pede o caminho de novo
                System.out.println("Verifique o caminho do arquivo Excel.");
            }
        }
    }
}
