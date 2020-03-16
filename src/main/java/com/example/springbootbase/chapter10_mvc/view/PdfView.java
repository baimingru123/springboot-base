package com.example.springbootbase.chapter10_mvc.view;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author bmr
 * @time 2020-02-28 11:45
 */
public class PdfView extends AbstractPdfView {

    //导出服务接口
    private PdfExportService pdfExportService;

    //创建对象时导出服务接口
    public PdfView(PdfExportService pdfExportService){
        this.pdfExportService=pdfExportService;
    }
    //调用实现
    @Override
    protected void buildPdfDocument(Map<String, Object> map, Document document, PdfWriter pdfWriter, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        //调用导出服务接口类
        pdfExportService.make(map,document,pdfWriter,httpServletRequest,httpServletResponse);
    }
}
