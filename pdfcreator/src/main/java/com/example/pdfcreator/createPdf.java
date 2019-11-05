package com.example.pdfcreator;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.html.WebColors;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class createPdf extends AppCompatActivity {


    Activity act = null;
    private static ArrayList<String> Category = new ArrayList<>();
    private static ArrayList<Integer> Amount = new ArrayList<>();
    private static ArrayList<String> DateList = new ArrayList<>();

    String fileNamePdf = "ElgoByte";
    String propertieSubjectPdf = "null";
    String propertieTitlePdf = "null";
    String propertieAuthorPdf = "null";

    String companyNamePdf = "null";
    String datePdf = "null";

    Boolean st1 = false;
    Boolean st2 = false;
    Boolean st3 = false;
    Boolean st4 = false;

    public static String table1Name = "null";
    public static String table1Column1 = "null";
    public static ArrayList table1Data1 = new ArrayList();

    public static String table2Name = "null";
    public static String table2Column1 = "null";
    public static String table2Column2 = "null";
    public static ArrayList table2Data1 = new ArrayList();
    public static ArrayList table2Data2 = new ArrayList();

    public static String table3Name = "null";
    public static String table3Column1 = "null";
    public static String table3Column2 = "null";
    public static String table3Column3 = "null";
    public static ArrayList table3Data1 = new ArrayList();
    public static ArrayList table3Data2 = new ArrayList();
    public static ArrayList table3Data3 = new ArrayList<String>();

    public static String table4Name = "null";
    public static String table4Column1 = "null";
    public static String table4Column2 = "null";
    public static String table4Column3 = "null";
    public static String table4Column4 = "null";
    public static ArrayList table4Data1 = new ArrayList();
    public static ArrayList table4Data2 = new ArrayList();
    public static ArrayList table4Data3 = new ArrayList<String>();
    public static ArrayList table4Data4 = new ArrayList<String>();


    public createPdf(Activity activity) {
        //need to premission

        act = activity;

        //if the SKD < 23
        if (Build.VERSION.SDK_INT >= 23) {

            if (activity.checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
                    PackageManager.PERMISSION_DENIED) {

                //ask for permission!
                ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);

            } else {

                Log.d("Allow", " Permission");
                //pdf();

            }

        } else {

            Log.d("Allow", " Permission");
            //Log.d("Allow", "createPdf: ");
            //pdf();
        }
    }

    public void pdfTest() {

        Category.add("First");
        Category.add("First 1");
        Category.add("First 2");
        Category.add("First 3");
        Category.add("First 4");
        Category.add("First 5");
        Category.add("First 6");
        Category.add("First 7");
        Category.add("First 8");
        Category.add("First 9");
        Category.add("First 10");
        Category.add("First 11");
        Category.add("First 12");


        Amount.add(10);
        Amount.add(110);
        Amount.add(120);
        Amount.add(130);
        Amount.add(140);
        Amount.add(150);
        Amount.add(160);
        Amount.add(170);
        Amount.add(180);
        Amount.add(190);
        Amount.add(1000);
        Amount.add(1100);
        Amount.add(1200);

        DateList.add("11/00/2019");
        DateList.add("11/01/2019");
        DateList.add("11/02/2019");
        DateList.add("11/03/2019");
        DateList.add("11/04/2019");
        DateList.add("11/05/2019");
        DateList.add("11/06/2019");
        DateList.add("11/07/2019");
        DateList.add("11/08/2019");
        DateList.add("11/09/2019");
        DateList.add("11/10/2019");
        DateList.add("11/11/2019");
        DateList.add("11/12/2019");

        //Log.d("Allow", "pdfTest: ");
        Document mDoc = new Document();
        //File Name as a current time Name
        String mFileName = new SimpleDateFormat("dd MMM yyyy HH:mm:ss",
                Locale.getDefault()).format(System.currentTimeMillis());

        //pdf file path
        String FilePath = Environment.getExternalStorageDirectory() + "/" + "Test Table" + "\t \t" + mFileName + ".pdf";

        try {

            PdfWriter.getInstance(mDoc, new FileOutputStream(FilePath));

            //Open the Document the write file
            mDoc.open();

            //add author of the document (optional)
            mDoc.addAuthor("ElgoByte Working");
            mDoc.addTitle("Simple Report");
            mDoc.addSubject("For Expenses Records PDF");
            mDoc.setPageSize(PageSize.A4);

            //Add paragraph to teh document
            Font fTitle = new Font(Font.FontFamily.TIMES_ROMAN.TIMES_ROMAN, 30.0f, Font.ITALIC, WebColors.getRGBColor("#607FBA"));
            Font fLastMonth = new Font(Font.FontFamily.TIMES_ROMAN.TIMES_ROMAN, 30.0f, Font.ITALIC, WebColors.getRGBColor("549E39"));
            Font fIcome = new Font(Font.FontFamily.TIMES_ROMAN.TIMES_ROMAN, 30.0f, Font.ITALIC, WebColors.getRGBColor("c99789"));

            Font fName = new Font(Font.FontFamily.TIMES_ROMAN.TIMES_ROMAN, 15.0f, Font.ITALIC, BaseColor.BLACK);

            Paragraph SoftName = new Paragraph("ElgoByte Team", fName);
            SoftName.setAlignment(Element.ALIGN_LEFT);

            Paragraph CurrentDay = new Paragraph("11/4/2019", fName);
            CurrentDay.setAlignment(Element.ALIGN_RIGHT);

            PdfPCell date, name;

            PdfPTable table = new PdfPTable(2);
            table.setWidthPercentage(100);
            table.setHorizontalAlignment(Element.ALIGN_CENTER);

            //Add new Column in the table
            name = new PdfPCell(new Paragraph(SoftName));
            name.setHorizontalAlignment(Element.ALIGN_LEFT);
            name.setBorder(Rectangle.NO_BORDER);
            name.setColspan(1);

            date = new PdfPCell(new Paragraph(CurrentDay));
            date.setHorizontalAlignment(Element.ALIGN_RIGHT);
            date.setBorder(Rectangle.NO_BORDER);
            date.setColspan(1);

            table.addCell(name);
            table.addCell(date);

            mDoc.add(table);

            Paragraph NewTitle = new Paragraph("Test Table \n ", fTitle);
            NewTitle.setAlignment(Element.ALIGN_CENTER);
            mDoc.add(NewTitle);

            //Method for data input in the table
            mDoc.add(createFirstTestTable());

            mDoc.close();
            Toast.makeText(act, "Data is Save", Toast.LENGTH_SHORT).show();


        } catch (Exception ex) {

            Toast.makeText(act, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    //Crete first test Table
    public static PdfPTable createFirstTestTable() {


        PdfPCell index, amount, category, date, NO, SubCategory, DateShow, AmountShow, Space, TotalAmount;

        Integer total_amount = 0;

        //Add paragraph to teh document
        Font fTitle = new Font(Font.FontFamily.TIMES_ROMAN.TIMES_ROMAN, 14.0f, Font.NORMAL, BaseColor.WHITE);

        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100);
        //table.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.setHorizontalAlignment(Element.ALIGN_CENTER);

        //Add new Column in the table
        NO = new PdfPCell(new Paragraph("No.", fTitle));
        SubCategory = new PdfPCell(new Paragraph("Category ", fTitle));
        DateShow = new PdfPCell(new Paragraph("Date ", fTitle));
        AmountShow = new PdfPCell(new Paragraph("Amount", fTitle));

        //Color fill UpColumn
        NO.setBackgroundColor(WebColors.getRGBColor("#607FBA"));
        SubCategory.setBackgroundColor(WebColors.getRGBColor("#607FBA"));
        DateShow.setBackgroundColor(WebColors.getRGBColor("#607FBA"));
        AmountShow.setBackgroundColor(WebColors.getRGBColor("#607FBA"));

        NO.setHorizontalAlignment(Element.ALIGN_CENTER);
        SubCategory.setHorizontalAlignment(Element.ALIGN_CENTER);
        DateShow.setHorizontalAlignment(Element.ALIGN_CENTER);
        AmountShow.setHorizontalAlignment(Element.ALIGN_CENTER);

        NO.setVerticalAlignment(Element.ALIGN_CENTER);
        SubCategory.setVerticalAlignment(Element.ALIGN_CENTER);
        DateShow.setVerticalAlignment(Element.ALIGN_CENTER);
        AmountShow.setVerticalAlignment(Element.ALIGN_CENTER);

        //topColumn.setBorderColorBottom(BaseColor.BLUE);
        //topColumn.setBackgroundColor(BaseColor.BLUE);
        NO.setColspan(1);
        SubCategory.setColspan(1);
        DateShow.setColspan(1);
        AmountShow.setColspan(1);

        table.addCell(NO);
        table.addCell(SubCategory);
        table.addCell(DateShow);
        table.addCell(AmountShow);

        for (int i = 0; i < Amount.size(); i++) {

            index = new PdfPCell(new Paragraph(String.valueOf(i + 1)));
            amount = new PdfPCell(new Paragraph(String.valueOf(Amount.get(i))));
            category = new PdfPCell(new Paragraph(String.valueOf(Category.get(i))));
            date = new PdfPCell(new Paragraph(String.valueOf(DateList.get(i).substring(0, 10))));

            total_amount += Amount.get(i);

            index.setHorizontalAlignment(Element.ALIGN_CENTER);
            amount.setHorizontalAlignment(Element.ALIGN_CENTER);
            category.setHorizontalAlignment(Element.ALIGN_CENTER);
            date.setHorizontalAlignment(Element.ALIGN_CENTER);

            index.setBorder(Rectangle.NO_BORDER);
            amount.setBorder(Rectangle.NO_BORDER);
            category.setBorder(Rectangle.NO_BORDER);
            date.setBorder(Rectangle.NO_BORDER);


            if (i % 2 == 0) {

                index.setBackgroundColor(WebColors.getRGBColor("#DDE4F0"));
                amount.setBackgroundColor(WebColors.getRGBColor("#DDE4F0"));
                category.setBackgroundColor(WebColors.getRGBColor("#DDE4F0"));
                date.setBackgroundColor(WebColors.getRGBColor("#DDE4F0"));

            } else {

                //No color

            }

            table.addCell(index);
            table.addCell(category);
            table.addCell(date);
            table.addCell(amount);


        }

        Space = new PdfPCell(new Paragraph());
        Space.setColspan(3);
        Space.setBorder(Rectangle.NO_BORDER);

        TotalAmount = new PdfPCell(new Paragraph(String.valueOf("Total = " + total_amount)));
        TotalAmount.setColspan(1);
        TotalAmount.setHorizontalAlignment(Element.ALIGN_CENTER);
        TotalAmount.setBackgroundColor(WebColors.getRGBColor("#F1F1F1"));
        TotalAmount.setBorder(Rectangle.NO_BORDER);

        table.addCell(Space);
        table.addCell(TotalAmount);

        return table;

        //Toast.makeText(, "", Toast.LENGTH_SHORT).show();


    }

    //****************Set Attribute************//
    public void setAttribute(String fileName, String propertieTitle,
                             String propertieAuthor, String propertieSubject) {

        if (fileName == null) {

            fileNamePdf = "ElgoByte";

        } else {

            fileNamePdf = fileName;
        }

        if (propertieTitle == null) {

            propertieTitlePdf = "null";

        } else {

            propertieTitlePdf = propertieTitle;
        }

        if (propertieSubject == null) {

            propertieSubjectPdf = "null";

        } else {

            propertieSubjectPdf = propertieSubject;
        }

        if (propertieAuthor == null) {

            propertieAuthorPdf = "null";

        } else {

            propertieAuthorPdf = propertieAuthor;
        }


    }


    //****************Set Data************//
    public void setData(String companyName, String date) {

        if (companyName == null) {

            companyNamePdf = "null";

        } else {

            companyNamePdf = companyName;
        }

        if (date == null) {

            datePdf = "null";

        } else {

            datePdf = date;
        }


    }

    //********************Set Table************//
    public void setTable(String tableName, String column1, ArrayList<String> data1) {

        st1 = true;
        // data1.clear();

        if (tableName == null) {

            table1Name = "null";

        } else {

            table1Name = tableName;
        }

        if (column1 == null) {

            table1Column1 = "null";

        } else {

            table1Column1 = column1;
        }

        if (!data1.isEmpty()) {

            table1Data1.addAll(data1);

        }

    }

    public void setTable(String tableName, String column1, ArrayList<String> data1, String column2, ArrayList<String> data2) {

        st2 = true;
        // data1.clear();

        if (tableName == null) {

            table2Name = "null";

        } else {

            table2Name = tableName;
        }

        if (column1 == null) {

            table2Column1 = "null";

        } else {

            table2Column1 = column1;
        }

        if (column2 == null) {

            table2Column2 = "null";

        } else {

            table2Column2 = column2;
        }

        if (!data1.isEmpty()) {

            //tableData1.addAll(data1);
            table2Data1.addAll(data1);

        }

        if (!data2.isEmpty()) {

            //tableData2.addAll(data2);
            table2Data2.addAll(data2);
        }

    }

    public void setTable(String tableName, String column1, ArrayList<String> data1, String column2, ArrayList<String> data2,
                         String column3, ArrayList<String> data3) {

        st3 = true;
        // data1.clear();

        if (tableName == null) {

            table3Name = "null";

        } else {

            table3Name = tableName;
        }

        if (column1 == null) {

            table3Column1 = "null";

        } else {

            table3Column1 = column1;
        }

        if (column2 == null) {

            table3Column2 = "null";

        } else {

            table3Column2 = column2;
        }

        if (column3 == null) {

            table3Column3 = "null";

        } else {

            table3Column3 = column3;
        }

        if (!data1.isEmpty()) {

            //tableData1.addAll(data1);
            table3Data1.addAll(data1);

        }

        if (!data2.isEmpty()) {

            //tableData2.addAll(data2);
            table3Data2.addAll(data2);
        }

        if (!data3.isEmpty()) {

            table3Data3.addAll(data3);
        }

    }

    public void setTable(String tableName, String column1, ArrayList<String> data1, String column2, ArrayList<String> data2,
                         String column3, ArrayList<String> data3, String column4, ArrayList<String> data4) {

        st4 = true;
        // data1.clear();

        if (tableName == null) {

            table4Name = "null";

        } else {

            table4Name = tableName;
        }

        if (column1 == null) {

            table4Column1 = "null";

        } else {

            table4Column1 = column1;
        }

        if (column2 == null) {

            table4Column2 = "null";

        } else {

            table4Column2 = column2;
        }

        if (column3 == null) {

            table4Column3 = "null";

        } else {

            table4Column3 = column3;
        }

        if (column4 == null) {

            table4Column4 = "null";

        } else {

            table4Column4 = column4;
        }

        if (!data1.isEmpty()) {

            //tableData1.addAll(data1);
            table4Data1.addAll(data1);

        }

        if (!data2.isEmpty()) {

            //tableData2.addAll(data2);
            table4Data2.addAll(data2);
        }

        if (!data3.isEmpty()) {

            table4Data3.addAll(data3);
        }

        if (!data4.isEmpty()) {

            table4Data4.addAll(data4);
        }

    }

    //****************Create PDF************//
    public void createPdf() {


        if (fileNamePdf == null) {

            Toast.makeText(act, "File name must be enter", Toast.LENGTH_SHORT).show();

        } else {

            //Toast.makeText(act, "Data is save", Toast.LENGTH_SHORT).show();

            //File Name as a current time Name
            String mFileName = new SimpleDateFormat("dd MMM yyyy HH:mm:ss",
                    Locale.getDefault()).format(System.currentTimeMillis());

            //pdf file path
            String Fil1ePath = Environment.getExternalStorageDirectory() + "/" + fileNamePdf + "\t \t" + mFileName + ".pdf";

            //no variable
            Document mDoc = new Document();

            try {

                PdfWriter.getInstance(mDoc, new FileOutputStream(Fil1ePath));

                //Open the Document the write file
                mDoc.open();

                //add author of the document (optional)
                mDoc.addAuthor(propertieAuthorPdf);
                mDoc.addTitle(propertieTitlePdf);
                mDoc.addSubject(propertieSubjectPdf);
                mDoc.setPageSize(PageSize.A4);

                //Add paragraph to teh document
                Font fTitle = new Font(Font.FontFamily.TIMES_ROMAN.TIMES_ROMAN, 30.0f, Font.ITALIC, WebColors.getRGBColor("#607FBA"));
                Font fLastMonth = new Font(Font.FontFamily.TIMES_ROMAN.TIMES_ROMAN, 30.0f, Font.ITALIC, WebColors.getRGBColor("549E39"));
                Font fIcome = new Font(Font.FontFamily.TIMES_ROMAN.TIMES_ROMAN, 30.0f, Font.ITALIC, WebColors.getRGBColor("c99789"));

                Font fName = new Font(Font.FontFamily.TIMES_ROMAN.TIMES_ROMAN, 15.0f, Font.ITALIC, BaseColor.BLACK);


                Paragraph SoftName = new Paragraph(companyNamePdf, fName);
                SoftName.setAlignment(Element.ALIGN_LEFT);

                Paragraph CurrentDay = new Paragraph(datePdf, fName);
                CurrentDay.setAlignment(Element.ALIGN_RIGHT);

                PdfPCell date, name;

                PdfPTable table = new PdfPTable(2);
                table.setWidthPercentage(100);
                table.setHorizontalAlignment(Element.ALIGN_CENTER);

                //Add new Column in the table
                name = new PdfPCell(new Paragraph(SoftName));
                name.setHorizontalAlignment(Element.ALIGN_LEFT);
                name.setBorder(Rectangle.NO_BORDER);
                name.setColspan(1);

                date = new PdfPCell(new Paragraph(CurrentDay));
                date.setHorizontalAlignment(Element.ALIGN_RIGHT);
                date.setBorder(Rectangle.NO_BORDER);
                date.setColspan(1);

                table.addCell(name);
                table.addCell(date);

                mDoc.add(table);

                if (st1) {

                    Paragraph NewTitle = new Paragraph(table1Name + " \n ", fTitle);
                    NewTitle.setAlignment(Element.ALIGN_CENTER);
                    mDoc.add(NewTitle);

                    mDoc.add(createFirstTable1());

                    //Toast.makeText(act, "Data calling table", Toast.LENGTH_SHORT).show();

                }

                if (st2) {

                    Paragraph NewTitle = new Paragraph(table2Name + " \n ", fLastMonth);
                    NewTitle.setAlignment(Element.ALIGN_CENTER);
                    mDoc.add(NewTitle);

                    mDoc.add(createFirstTable2());

                }

                if (st3) {


                    Paragraph NewTitle = new Paragraph(table3Name + " \n ", fIcome);
                    NewTitle.setAlignment(Element.ALIGN_CENTER);
                    mDoc.add(NewTitle);

                    mDoc.add(createFirstTable3());

                }

                if (st4) {

                    Paragraph NewTitle = new Paragraph(table4Name + " \n ", fTitle);
                    NewTitle.setAlignment(Element.ALIGN_CENTER);
                    mDoc.add(NewTitle);

                    mDoc.add(createFirstTable4());

                }

                mDoc.close();
                Toast.makeText(act, "Data is save", Toast.LENGTH_SHORT).show();


            } catch (Exception ex) {

                Toast.makeText(act, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }

        }
    }

    //*********Create table1**********//
    public PdfPTable createFirstTable1() {

        PdfPCell index, No, column1, data1;

        //Add paragraph to teh document
        Font fTitle = new Font(Font.FontFamily.TIMES_ROMAN.TIMES_ROMAN, 14.0f, Font.NORMAL, BaseColor.WHITE);

        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);
        //table.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.setHorizontalAlignment(Element.ALIGN_CENTER);

        //Add new Column in the table
        No = new PdfPCell(new Paragraph("No.", fTitle));
        column1 = new PdfPCell(new Paragraph(table1Column1, fTitle));

        //Color fill UpColumn
        No.setBackgroundColor(WebColors.getRGBColor("#607FBA"));
        column1.setBackgroundColor(WebColors.getRGBColor("#607FBA"));

        No.setHorizontalAlignment(Element.ALIGN_CENTER);
        column1.setHorizontalAlignment(Element.ALIGN_CENTER);


        No.setVerticalAlignment(Element.ALIGN_CENTER);
        column1.setVerticalAlignment(Element.ALIGN_CENTER);

        No.setColspan(1);
        column1.setColspan(1);

        table.addCell(No);
        table.addCell(column1);

        if (!table1Data1.isEmpty()) {

            for (int i = 0; i < table1Data1.size(); i++) {

                index = new PdfPCell(new Paragraph(String.valueOf(i + 1)));
                data1 = new PdfPCell(new Paragraph(String.valueOf(table1Data1.get(i))));

                index.setHorizontalAlignment(Element.ALIGN_CENTER);
                data1.setHorizontalAlignment(Element.ALIGN_CENTER);

                index.setBorder(Rectangle.NO_BORDER);
                data1.setBorder(Rectangle.NO_BORDER);


                if (i % 2 == 0) {

                    index.setBackgroundColor(WebColors.getRGBColor("#DDE4F0"));
                    data1.setBackgroundColor(WebColors.getRGBColor("#DDE4F0"));


                } else {

                    //No color

                }


                table.addCell(index);
                table.addCell(data1);

            }


        }


        return table;
    }

    public PdfPTable createFirstTable2() {

        PdfPCell index, No, column1, data1, column2, data2;

        //Add paragraph to teh document
        Font fTitle = new Font(Font.FontFamily.TIMES_ROMAN.TIMES_ROMAN, 14.0f, Font.NORMAL, BaseColor.WHITE);

        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100);
        //table.setHorizontalAlignment(Element.ALIGN_LEFT);
        table.setHorizontalAlignment(Element.ALIGN_CENTER);

        //Add new Column in the table
        No = new PdfPCell(new Paragraph("No.", fTitle));
        column1 = new PdfPCell(new Paragraph(table2Column1, fTitle));
        column2 = new PdfPCell(new Paragraph(table2Column2, fTitle));

        //Color fill UpColumn
        No.setBackgroundColor(WebColors.getRGBColor("#549E39"));
        column1.setBackgroundColor(WebColors.getRGBColor("#549E39"));
        column2.setBackgroundColor(WebColors.getRGBColor("#549E39"));

        No.setHorizontalAlignment(Element.ALIGN_CENTER);
        column1.setHorizontalAlignment(Element.ALIGN_CENTER);
        column2.setHorizontalAlignment(Element.ALIGN_CENTER);


        No.setVerticalAlignment(Element.ALIGN_CENTER);
        column1.setVerticalAlignment(Element.ALIGN_CENTER);
        column2.setVerticalAlignment(Element.ALIGN_CENTER);

        No.setColspan(1);
        column1.setColspan(1);
        column2.setColspan(1);

        table.addCell(No);
        table.addCell(column1);
        table.addCell(column2);

        if (!table2Data1.isEmpty()) {

            for (int i = 0; i < table2Data1.size(); i++) {

                index = new PdfPCell(new Paragraph(String.valueOf(i + 1)));
                data1 = new PdfPCell(new Paragraph(String.valueOf(table2Data1.get(i))));
                data2 = new PdfPCell(new Paragraph(String.valueOf(table2Data2.get(i))));

                index.setHorizontalAlignment(Element.ALIGN_CENTER);
                data1.setHorizontalAlignment(Element.ALIGN_CENTER);
                data2.setHorizontalAlignment(Element.ALIGN_CENTER);


                index.setBorder(Rectangle.NO_BORDER);
                data1.setBorder(Rectangle.NO_BORDER);
                data2.setBorder(Rectangle.NO_BORDER);


                if (i % 2 == 0) {

                    index.setBackgroundColor(WebColors.getRGBColor("#DBEFD4"));
                    data1.setBackgroundColor(WebColors.getRGBColor("#DBEFD4"));
                    data2.setBackgroundColor(WebColors.getRGBColor("#DBEFD4"));


                } else {

                    //No color

                }

                table.addCell(index);
                table.addCell(data1);
                table.addCell(data2);

            }

        }

        return table;
    }

    public PdfPTable createFirstTable3() {

        PdfPCell index, No, column1, data1, column2, data2, column3, data3;

        //Add paragraph to teh document
        Font fTitle = new Font(Font.FontFamily.TIMES_ROMAN.TIMES_ROMAN, 14.0f, Font.NORMAL, BaseColor.WHITE);

        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100);
        table.setHorizontalAlignment(Element.ALIGN_CENTER);

        //Add new Column in the table
        No = new PdfPCell(new Paragraph("No.", fTitle));
        column1 = new PdfPCell(new Paragraph(table3Column1, fTitle));
        column2 = new PdfPCell(new Paragraph(table3Column2, fTitle));
        column3 = new PdfPCell(new Paragraph(table3Column3, fTitle));

        //Color fill UpColumn
        No.setBackgroundColor(WebColors.getRGBColor("#c99789"));
        column1.setBackgroundColor(WebColors.getRGBColor("#c99789"));
        column2.setBackgroundColor(WebColors.getRGBColor("#c99789"));
        column3.setBackgroundColor(WebColors.getRGBColor("#c99789"));

        No.setHorizontalAlignment(Element.ALIGN_CENTER);
        column1.setHorizontalAlignment(Element.ALIGN_CENTER);
        column2.setHorizontalAlignment(Element.ALIGN_CENTER);
        column3.setHorizontalAlignment(Element.ALIGN_CENTER);


        No.setVerticalAlignment(Element.ALIGN_CENTER);
        column1.setVerticalAlignment(Element.ALIGN_CENTER);
        column2.setVerticalAlignment(Element.ALIGN_CENTER);
        column3.setVerticalAlignment(Element.ALIGN_CENTER);

        No.setColspan(1);
        column1.setColspan(1);
        column2.setColspan(1);
        column3.setColspan(1);

        table.addCell(No);
        table.addCell(column1);
        table.addCell(column2);
        table.addCell(column3);

        if (!table3Data1.isEmpty()) {

            for (int i = 0; i < table3Data1.size(); i++) {

                index = new PdfPCell(new Paragraph(String.valueOf(i + 1)));
                data1 = new PdfPCell(new Paragraph(String.valueOf(table3Data1.get(i))));
                data2 = new PdfPCell(new Paragraph(String.valueOf(table3Data2.get(i))));
                data3 = new PdfPCell(new Paragraph(String.valueOf(table3Data3.get(i))));

                index.setHorizontalAlignment(Element.ALIGN_CENTER);
                data1.setHorizontalAlignment(Element.ALIGN_CENTER);
                data2.setHorizontalAlignment(Element.ALIGN_CENTER);
                data3.setHorizontalAlignment(Element.ALIGN_CENTER);


                index.setBorder(Rectangle.NO_BORDER);
                data1.setBorder(Rectangle.NO_BORDER);
                data2.setBorder(Rectangle.NO_BORDER);
                data3.setBorder(Rectangle.NO_BORDER);


                if (i % 2 == 0) {

                    index.setBackgroundColor(WebColors.getRGBColor("#ffe9bc"));
                    data1.setBackgroundColor(WebColors.getRGBColor("#ffe9bc"));
                    data2.setBackgroundColor(WebColors.getRGBColor("#ffe9bc"));
                    data3.setBackgroundColor(WebColors.getRGBColor("#ffe9bc"));


                } else {

                    //No color

                }

                table.addCell(index);
                table.addCell(data1);
                table.addCell(data2);
                table.addCell(data3);

            }

        }

        return table;
    }

    public PdfPTable createFirstTable4() {

        PdfPCell index, No, column1, data1, column2, data2, column3, data3, column4, data4;

        //Add paragraph to teh document
        Font fTitle = new Font(Font.FontFamily.TIMES_ROMAN.TIMES_ROMAN, 14.0f, Font.NORMAL, BaseColor.WHITE);

        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100);
        table.setHorizontalAlignment(Element.ALIGN_CENTER);

        //Add new Column in the table
        No = new PdfPCell(new Paragraph("No.", fTitle));
        column1 = new PdfPCell(new Paragraph(table4Column1, fTitle));
        column2 = new PdfPCell(new Paragraph(table4Column2, fTitle));
        column3 = new PdfPCell(new Paragraph(table4Column3, fTitle));
        column4 = new PdfPCell(new Paragraph(table4Column4, fTitle));

        //Color fill UpColumn
        No.setBackgroundColor(WebColors.getRGBColor("#607FBA"));
        column1.setBackgroundColor(WebColors.getRGBColor("#607FBA"));
        column2.setBackgroundColor(WebColors.getRGBColor("#607FBA"));
        column3.setBackgroundColor(WebColors.getRGBColor("#607FBA"));
        column4.setBackgroundColor(WebColors.getRGBColor("#607FBA"));

        No.setHorizontalAlignment(Element.ALIGN_CENTER);
        column1.setHorizontalAlignment(Element.ALIGN_CENTER);
        column2.setHorizontalAlignment(Element.ALIGN_CENTER);
        column3.setHorizontalAlignment(Element.ALIGN_CENTER);
        column4.setHorizontalAlignment(Element.ALIGN_CENTER);

        No.setVerticalAlignment(Element.ALIGN_CENTER);
        column1.setVerticalAlignment(Element.ALIGN_CENTER);
        column2.setVerticalAlignment(Element.ALIGN_CENTER);
        column3.setVerticalAlignment(Element.ALIGN_CENTER);
        column4.setVerticalAlignment(Element.ALIGN_CENTER);

        No.setColspan(1);
        column1.setColspan(1);
        column2.setColspan(1);
        column3.setColspan(1);
        column4.setColspan(1);

        table.addCell(No);
        table.addCell(column1);
        table.addCell(column2);
        table.addCell(column3);
        table.addCell(column4);

        if (!table4Data1.isEmpty()) {

            for (int i = 0; i < table4Data1.size(); i++) {

                index = new PdfPCell(new Paragraph(String.valueOf(i + 1)));
                data1 = new PdfPCell(new Paragraph(String.valueOf(table4Data1.get(i))));
                data2 = new PdfPCell(new Paragraph(String.valueOf(table4Data2.get(i))));
                data3 = new PdfPCell(new Paragraph(String.valueOf(table4Data3.get(i))));
                data4 = new PdfPCell(new Paragraph(String.valueOf(table4Data4.get(i))));

                index.setHorizontalAlignment(Element.ALIGN_CENTER);
                data1.setHorizontalAlignment(Element.ALIGN_CENTER);
                data2.setHorizontalAlignment(Element.ALIGN_CENTER);
                data3.setHorizontalAlignment(Element.ALIGN_CENTER);
                data4.setHorizontalAlignment(Element.ALIGN_CENTER);


                index.setBorder(Rectangle.NO_BORDER);
                data1.setBorder(Rectangle.NO_BORDER);
                data2.setBorder(Rectangle.NO_BORDER);
                data3.setBorder(Rectangle.NO_BORDER);
                data4.setBorder(Rectangle.NO_BORDER);


                if (i % 2 == 0) {

                    index.setBackgroundColor(WebColors.getRGBColor("#DDE4F0"));
                    data1.setBackgroundColor(WebColors.getRGBColor("#DDE4F0"));
                    data2.setBackgroundColor(WebColors.getRGBColor("#DDE4F0"));
                    data3.setBackgroundColor(WebColors.getRGBColor("#DDE4F0"));
                    data4.setBackgroundColor(WebColors.getRGBColor("#DDE4F0"));


                } else {

                    //No color

                }

                table.addCell(index);
                table.addCell(data1);
                table.addCell(data2);
                table.addCell(data3);
                table.addCell(data4);

            }

        }

        return table;
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            // Log.d("Allow", "createPdf: ");
            Log.d("Allow", " Permission");
            //pdf();

        } else {

            if (requestCode == 1 && grantResults[0] == PackageManager.PERMISSION_DENIED) {


                //if the SKD < 23
                if (Build.VERSION.SDK_INT >= 23) {

                    if (act.checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
                            PackageManager.PERMISSION_DENIED) {

                        //ask for permission!
                        ActivityCompat.requestPermissions(act, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);

                    }

                }

            }

        }
    }


}
