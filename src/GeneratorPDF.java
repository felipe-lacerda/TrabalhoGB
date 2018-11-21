import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GeneratorPDF {
    private String titleReport;
    private JTable table;

    public GeneratorPDF(String reportTitle, final HashMap<String, ArrayList> table) {
        this.titleReport = reportTitle;
        this.table = hashMapToJTable(table);
    }

    public void runReport() throws Exception {
        Document document = new Document();
        document.setMargins(10, 20, 20, 10);
        PdfWriter.getInstance(document, new FileOutputStream("Grupo1_FelipeLacerda_FelipeFlores_JhonLennon.pdf"));
        document.open();
        document.add(getPdfPTable());
        document.close();
    }

    private PdfPTable getPdfPTable() throws Exception {
        PdfPTable pdfPTable = new PdfPTable(table.getColumnCount());
        pdfPTable.addCell(getCellTitle());
        for (int i = 0; i < table.getColumnCount(); i++) {
            pdfPTable.addCell(table.getColumnName(i));
        }
        for (int rows = 0; rows < table.getRowCount(); rows++) {
            for (int cols = 0; cols < table.getColumnCount(); cols++) {
                pdfPTable.addCell(table.getModel().getValueAt(rows, cols).toString());
            }
        }
        return pdfPTable;
    }

    private PdfPCell getCellTitle() {
        PdfPCell cell = new PdfPCell(new Paragraph(titleReport));
        cell.setColspan(20);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        return cell;
    }

    private JTable hashMapToJTable(final HashMap<String, ArrayList> table) {
        DefaultTableModel model = new DefaultTableModel();
        JTable jTable = new JTable(model);
        model.addColumn("n");
        model.addColumn("Bubble");
        model.addColumn("Insertion");
        model.addColumn("Selection");
        model.addColumn("Heap");
        model.addColumn("Shell");
        model.addColumn("Merge");
        model.addColumn("Quick");
        int linha = 0;
        int size = 128;
        while (linha < table.get("Bubble").size()) {
            model.addRow(new Object[]{
                    size,
                    table.get("Bubble").get(linha),
                    table.get("Insertion").get(linha),
                    table.get("Selection").get(linha),
                    table.get("Heap").get(linha),
                    table.get("Shell").get(linha),
                    table.get("Merge").get(linha),
                    table.get("Quick").get(linha)
            });
            size *= 2;
            linha++;
        }

        return jTable;
    }
}