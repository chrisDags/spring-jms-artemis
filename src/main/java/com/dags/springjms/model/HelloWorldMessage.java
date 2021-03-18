package com.dags.springjms.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HelloWorldMessage implements Serializable {
    // if we were sending this as a JMS object, the serialVersionUID is necessary
    static final long serialVersionUID = -7750645422395283049L;

    private UUID id;
    private String message;
}
