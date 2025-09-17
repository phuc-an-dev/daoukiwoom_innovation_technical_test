package com.example.daoukiwoom_innovation_technical_test.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SuccessApiResponse<T> extends ApiResponse {
    T data;

    public SuccessApiResponse (T data) {
        this.data = data;
        super.setSuccess(true);
        super.setMessage("Success");
    }
}
