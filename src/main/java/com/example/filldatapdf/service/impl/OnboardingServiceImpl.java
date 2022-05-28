package com.example.filldatapdf.service.impl;

import com.example.filldatapdf.entity.Contract;
import com.example.filldatapdf.entity.FileContract;
import com.example.filldatapdf.entity.GetAllFileRequest;
import com.example.filldatapdf.service.OnboardingService;
import com.example.filldatapdf.util.OBFileUtil;
import org.springframework.stereotype.Service;

import java.sql.Connection;

@Service
public class OnboardingServiceImpl implements OnboardingService {
    @Override
    public String getAllFile() throws Exception {
        Contract contract = new Contract();
        contract.setName("Hoang Thi bich hong");
        doGenerateForm(contract);
        return "nguyen tien dong";
    }

    private void doGenerateForm(Contract data) throws Exception {
        FileContract contract = new FileContract(data);
        String pathFile = OBFileUtil.genContract(contract);
        System.out.println(pathFile);
    }

}
