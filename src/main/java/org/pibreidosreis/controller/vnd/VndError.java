package org.pibreidosreis.controller.vnd;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VndError {

    private String logref;
    private String message;
    private String path;
}
