package com.example.springbootbase.chapter10_mvc.view;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author bmr
 * @time 2020-02-28 11:37
 */
public interface PdfExportService {
    public void make(Map<String,Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws DocumentException;
}
