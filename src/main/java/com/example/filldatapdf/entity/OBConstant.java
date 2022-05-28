package com.example.filldatapdf.entity;

public class OBConstant {
    public static final String OBCONTRACT_FILE = "./onboarding/Contract.pdf";
    public static final String PDF_EXTENSION = ".pdf";
    public static interface CONTRACT_FIELD_LOCATION {
        PdfUtility.TextProperties name = new PdfUtility.TextProperties("1", 1, 92, 200, "#Text Field0#");
        PdfUtility.TextProperties checkbox = new PdfUtility.TextProperties("1", 1, 92, 200, "#Check Box18");
    }
}
