package org.pibreidosreis.controller.vnd;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Embedded {

    private List<VndError> errors;

    public Embedded() {
        errors = new ArrayList<>();
    }
}
