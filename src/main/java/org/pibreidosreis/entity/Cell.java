package org.pibreidosreis.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Cell extends AbstractEntity{

    @Enumerated(EnumType.STRING)
    private CellType type;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "leader_id")
    private Member leader;

    @OneToMany(mappedBy = "cell")
    private List<Member> members;
}
