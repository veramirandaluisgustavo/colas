package com.SERVER_CONTROLLER.CONTROLLER.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SERVER_CONTROLLER.CONTROLLER.commons.GenericServiceApi;
import com.SERVER_CONTROLLER.CONTROLLER.commons.GenericServiceImpl;
import com.SERVER_CONTROLLER.CONTROLLER.dto.MedicamentoDTO;
import com.SERVER_CONTROLLER.CONTROLLER.model.Medicamento;
import com.SERVER_CONTROLLER.CONTROLLER.service.API.MedicamentoServiceApi;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;


@Service
public class MedicamentoServiceImpl extends GenericServiceImpl<Medicamento,MedicamentoDTO> implements MedicamentoServiceApi{

    @Autowired
    private Firestore firestore;

    @Override
    public CollectionReference getCollection() {
        
        return firestore.collection("medicamento");
    }

    
}
