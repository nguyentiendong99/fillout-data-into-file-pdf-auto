package com.example.filldatapdf.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
public class FileContract {
    private List<PdfUtility.TextProperties> listText;

    private final String CHECKED = "#Yes";
    private final String UNCHECKED = "#Off";

    public FileContract(Contract data) {
        this.listText = init(data);
    }

    @SuppressWarnings("unused")
    private List<PdfUtility.TextProperties> init(Contract data) {
        List<PdfUtility.TextProperties> listText = new ArrayList<>();
        String name = "Hoang thi bich hong";
        listText.add(new PdfUtility.TextProperties("#" + name, OBConstant.CONTRACT_FIELD_LOCATION.name));
        listText.add(new PdfUtility.TextProperties(CHECKED, OBConstant.CONTRACT_FIELD_LOCATION.checkbox));
        return listText;
    }
}
