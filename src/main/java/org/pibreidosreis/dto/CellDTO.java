package org.pibreidosreis.dto;

import lombok.Data;
import org.pibreidosreis.entity.CellType;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class CellDTO {

    private Long id;

    @NotNull
    private CellType type;

    @NotNull
    private AddressDTO address;

    @NotNull
    private Long leaderId;

    private List<MemberDTO> members;

}
