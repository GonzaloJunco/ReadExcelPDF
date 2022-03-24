import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadPDF {
    public static void main(String[] args) throws IOException {
        FileInputStream file = new FileInputStream("C:\\Users\\pjuncodi\\Downloads\\Consulta_ financiamientos.pdf");
        PDDocument fileDocumen = PDDocument.load(file);
        PDFTextStripper filePDFStrip = new PDFTextStripper();
        String pdfContent = filePDFStrip.getText(fileDocumen);
        System.out.println(pdfContent);

    }
}
