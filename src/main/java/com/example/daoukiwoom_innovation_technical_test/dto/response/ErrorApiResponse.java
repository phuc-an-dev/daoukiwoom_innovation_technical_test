package com.example.daoukiwoom_innovation_technical_test.dto.response;

import com.example.daoukiwoom_innovation_technical_test.constant.ApplicationResponseCode;
import com.example.daoukiwoom_innovation_technical_test.exception.ApplicationException;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ErrorApiResponse<T> extends ApiResponse {
    @Builder.Default
    int errorCode = ApplicationResponseCode.UNKNOWN_ERROR;
    T errors;

    public ErrorApiResponse(ApplicationException ex) {
        super(ex.getMessage(), false);
        this.errorCode = ex.getCode();
    }

    public ErrorApiResponse(String message) {
        super(message);
    }
}
