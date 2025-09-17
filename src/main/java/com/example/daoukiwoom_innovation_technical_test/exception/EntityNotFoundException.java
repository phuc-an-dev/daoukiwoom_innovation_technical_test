package com.example.daoukiwoom_innovation_technical_test.exception;

import com.example.daoukiwoom_innovation_technical_test.constant.ApplicationResponseCode;

public class EntityNotFoundException extends ApplicationException {
    public EntityNotFoundException(String message) {
        super(message, ApplicationResponseCode.ENTITY_NOT_FOUND);
    }
}
