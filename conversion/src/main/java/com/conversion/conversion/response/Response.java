package com.conversion.conversion.response;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Response implements Serializable {
    private String message;
    private Double result;

    public Response(String message)
    {
        this.message = message;
    }
}
