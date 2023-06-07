import java.io.File;

import jxl.Cell;
import jxl.NumberCell;
import jxl.Sheet;
import jxl.Workbook;

import jxl.write.*;
import jxl.write.Number;

import jxl.read.biff.BiffException;
import java.io.IOException;

public class LerEscreverExcel {

//    Aqui estou falando que terei 5 colunas com cada uma com 3 linhas e o final é para evitar a herança

    private final String[] as1 = new String[10];
    private final String[] as2 = new String[10];

    private String enderecoExcel = "Área de Trabalho";

    public LerEscreverExcel(String excel) {
        this.enderecoExcel = excel; // costrutor, estou pegando o endereço do arquivo que o usuario passou
    }

    public String[] getAs1() {
        return this.as1;
    }

    public String[] getAs2() {
        return this.as2;       // metodos que vão pegar as informaçoes das colunas
    }

    public void lerExcel() throws IOException, BiffException {

        Workbook workbook = Workbook.getWorkbook(new File(enderecoExcel)); // pegar o arquivo na pasta de trabalho colocar nos padroes da biblioteca e colocar no objeto workbook

        Sheet sheet = workbook.getSheet(0); //devine a panilha que estou pegando atravez da possicao

        int linhas = sheet.getRows(); // pegando a quantidades de linhas com valor

        for (int i = 0; i < linhas; i++) {

            Cell a1 = sheet.getCell(0, i);

            Cell a2 = sheet.getCell(1, i); // coloquei o valor da celula no objeto celula(coluna, linha(de 0 a 2))

            this.as1[i] = a1.getContents(); // pegar o conteudo e colocar no vetor por linha

            this.as2[i] = a2.getContents();



        }

        workbook.close();

    }
}