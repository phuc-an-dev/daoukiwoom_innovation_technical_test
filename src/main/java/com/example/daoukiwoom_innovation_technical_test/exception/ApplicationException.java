package com.example.daoukiwoom_innovation_technical_test.exception;

import com.example.daoukiwoom_innovation_technical_test.constant.ApplicationResponseCode;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PROTECTED)
public class ApplicationException extends RuntimeException {
    int code = ApplicationResponseCode.UNKNOWN_ERROR;
    public ApplicationException(String message, int code) {
        super(message);
        this.code = code;
    }
}
