package com.example.filldatapdf.util;

import com.example.filldatapdf.entity.FileContract;
import com.example.filldatapdf.entity.OBConstant;
import com.example.filldatapdf.entity.PdfUtility;

import java.io.File;
import java.util.HashMap;

public class OBFileUtil {
    public static String genContract(FileContract contract) throws Exception {
        String templateFile = OBConstant.OBCONTRACT_FILE;
        String fileName = "Contract";
        File pdfFile = File.createTempFile(fileName, OBConstant.PDF_EXTENSION);
        HashMap<String, String> data = prepareData(contract);
        PdfUtility.fillForm(templateFile, pdfFile.getPath(), data);
        return pdfFile.getPath();
    }

    public static HashMap<String, String> prepareData(FileContract contract) {
        HashMap<String, String> data = new HashMap<>();
        for (PdfUtility.TextProperties txt : contract.getListText()) {
            if (txt != null) {
                String[] values = txt.getText().split("#");
                String[] keys = txt.getFieldId().split("#");
                int size = keys.length == values.length ? values.length : 0;
                if (size > 0) {
                    for (int i = 0; i < size; i++) {
                        data.put(keys[i], values[i]);
                    }
                } else {
                    System.out.println("error");
                }
            }
        }
        return data;
    }
}
