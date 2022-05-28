package com.example.filldatapdf.entity;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.core.io.ClassPathResource;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

public class PdfUtility {
    public static void getAll() {

    }

    @AllArgsConstructor
    @Setter
    @Getter
    public static class TextProperties {
        private String text;
        private String key;
        private int page;
        private float x;
        private float y;
        private String fieldId;

        public TextProperties(String text, int page, float x, float y, String fieldId) {
            this.text = text;
            this.page = page;
            this.x = x;
            this.y = y;
            this.fieldId = fieldId;
        }

        public TextProperties(String text, String key) {
            this.text = text;
            this.key = key;
        }

        public TextProperties(String text, int page, float x, float y) {
            this.text = text;
            this.page = page;
            this.x = x;
            this.y = y;
        }

        public TextProperties(String value, TextProperties text) {
            this.text = value;
            this.key = text.getKey();
            this.x = text.getX();
            this.y = text.getY();
            this.fieldId = text.getFieldId();
        }
    }

    public static void fillForm(String pdfPath, String copyPath, HashMap<String, String> data) throws DocumentException, IOException {
        PdfReader reader = null;
        PdfStamper stamper = null;
        try {
            ClassPathResource cpr = new ClassPathResource(pdfPath);
            reader = new PdfReader(cpr.getInputStream());
            stamper = new PdfStamper(reader, new FileOutputStream(copyPath));
            stamper.setFullCompression();
            AcroFields form = stamper.getAcroFields();
//            BaseFont bf = BaseFont.createFont("font/ARIALUNI.TTF", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
//            form.addSubstitutionFont(bf);
            for (String key : data.keySet()) {
                form.setFieldProperty(key, "textcolor", BaseColor.RED, null);
                form.setFieldProperty(key, "textsize", 8f, null);
                form.setField(key, data.get(key).replace("\n", " ").toLowerCase());
                if (key.contains("Check")) {
                    form.setField(key, data.get(key));
                }
            }
            stamper.setFormFlattening(true);
        } catch (Exception e) {

        } finally {
            if (stamper != null) {
                stamper.close();
            }
            reader.close();
        }

    }

    private static void onlyOnboard(AcroFields form , String key, String value) {

    }
}
