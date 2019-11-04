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

    public void pdf() {

        //no variable
        Log.d("Allow", "createPdf: ");
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
        String mFileName = new SimpleDateFormat("yyyyMMdd_HHmmss",
                Locale.getDefault()).format(System.currentTimeMillis());

        //pdf file path
        String FilePath = Environment.getExternalStorageDirectory() + "/" + "Expense Report" + mFileName + ".pdf";

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
